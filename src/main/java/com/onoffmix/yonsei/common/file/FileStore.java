package com.onoffmix.yonsei.common.file;

import org.springframework.core.io.Resource;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;

public interface FileStore {

    UploadFile store(FileItem fileItem) throws IOException;

    Resource download(String path) throws MalformedURLException;

    boolean delete(String path) throws IOException;
}
