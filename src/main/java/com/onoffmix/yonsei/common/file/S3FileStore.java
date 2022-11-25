package com.onoffmix.yonsei.common.file;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Qualifier(value = "S3FileStore")
@Component
public class S3FileStore implements FileStore {

    @Value("${file.dir.s3}")
    private String rootPath;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    private final AmazonS3Client s3Client;

    @Override
    public UploadFile store(FileItem fileItem) {
        if (fileItem == null || fileItem.isEmpty()) {
            return UploadFile.createEmptyFile();
        }

        String originName = fileItem.getName();
        String encodedName = createEncodedName(originName);
        String dir = fileItem.getFileType().getDir() + "/" + encodedName;
        String fullPath = getFullPath(dir);

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(fileItem.getSize());
        s3Client.putObject(new PutObjectRequest(bucket, dir, fileItem.getInputStream(), metadata)
                .withCannedAcl(CannedAccessControlList.PublicRead));

        return UploadFile.of(StoreType.LOCAL, originName, encodedName, fullPath, fileItem.getSize());
    }

    private String createEncodedName(String fileName) {
        UUID encodedName = UUID.randomUUID();
        String ext = extractExt(fileName);

        return encodedName + "." + ext;
    }

    private String extractExt(String fileName) {
        int index = fileName.lastIndexOf('.');

        return fileName.substring(index + 1);
    }

    @Override
    public Resource download(String path) {
        S3Object s3Object = s3Client.getObject(new GetObjectRequest(bucket, path));
        S3ObjectInputStream inputStream = s3Object.getObjectContent();

        return new InputStreamResource(inputStream);
    }

    @Override
    public boolean delete(String path) {
        try {
            s3Client.deleteObject(bucket, path);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getFullPath(String filepath) {
        return rootPath + "/" + filepath;
    }
}
