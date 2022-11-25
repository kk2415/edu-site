package com.onoffmix.yonsei.controller.v1.test;

import com.onoffmix.yonsei.common.file.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
public class TestApiController {


    private final FileStore fileStore;

    @Autowired
    public TestApiController(@Qualifier("S3FileStore") FileStore fileStore) {
        this.fileStore = fileStore;
    }

    @GetMapping("/test/file/upload")
    public void upload() throws IOException {
        FileItem fileItem = FileItem.of(FileType.USER_PROFILE, "test.txt", "String".getBytes());

        fileStore.store(fileItem);
    }

    @GetMapping("/test/file/delete")
    public void delete(@RequestParam(defaultValue = "test.txt") String name) throws IOException {
        fileStore.delete(FileType.USER_PROFILE.getDir() + "/" + name);
    }

    @GetMapping("/test/file/download")
    public void download(@RequestParam(defaultValue = "test.txt") String name) throws IOException {
        Resource resource = fileStore.download(FileType.USER_PROFILE.getDir() + "/" + name);
    }
}
