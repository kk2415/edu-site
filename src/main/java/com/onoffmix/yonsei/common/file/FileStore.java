package com.onoffmix.yonsei.common.file;

import org.springframework.core.io.Resource;

import java.io.IOException;

public interface FileStore {

    UploadFile store(FileItem fileItem) throws IOException;

    Resource download(String fileName);

    boolean delete(String fileName);
}
