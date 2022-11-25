package com.onoffmix.yonsei.controller.v1.test;

import com.onoffmix.yonsei.common.file.FileItem;
import com.onoffmix.yonsei.common.file.FileType;
import com.onoffmix.yonsei.common.file.LocalFileStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@RestController
public class TestApiController {

    private final LocalFileStore fileStore;

    @GetMapping("/test")
    public void test() throws IOException {
        FileItem fileItem = FileItem.of(FileType.USER_PROFILE, "test.txt", "String".getBytes());

        fileStore.store(fileItem);
    }
}
