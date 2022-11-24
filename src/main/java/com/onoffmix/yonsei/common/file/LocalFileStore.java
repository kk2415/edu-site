package com.onoffmix.yonsei.common.file;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.UUID;

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

    public String getFullPath(String filepath) {
        return rootPath + "/" +  filepath;
    }

    @Override
    public Resource download(String fileName) {
        return null;
    }

    @Override
    public boolean delete(String fileName) {
        return false;
    }
}
