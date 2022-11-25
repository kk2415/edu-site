package com.onoffmix.yonsei.common.file;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Qualifier(value = "LocalFileStore")
@Component
public class LocalFileStore implements FileStore {

    @Value("${file.dir.local}")
    private String rootPath;

    @Override
    public UploadFile store(FileItem fileItem) throws IOException {
        if (fileItem == null || fileItem.isEmpty()) {
            return UploadFile.createEmptyFile();
        }

        String originName = fileItem.getName();
        String encodedName = createEncodedName(originName);
        String fullPath = getFullPath(fileItem.getFileType().getDir() + "/" + encodedName);

        fileItem.write(fullPath);

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
    public Resource download(String path) throws MalformedURLException {
        String fullPath = getFullPath(path);

        return new UrlResource("file:" + fullPath);
    }

    @Override
    public boolean delete(String path) {
        String fullPath = getFullPath(path);

        try {
            Files.delete(Paths.get(fullPath));
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private String getFullPath(String filepath) {
        return rootPath + "/" + filepath;
    }
}
