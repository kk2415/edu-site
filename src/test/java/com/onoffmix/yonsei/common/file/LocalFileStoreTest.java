package com.onoffmix.yonsei.common.file;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class LocalFileStoreTest {

    @Value("${file.dir.local}")
    private String dir;

    @Autowired @Qualifier("LocalFileStore")
    private FileStore fileStore;

    @Test
    public void given_plainTextFile_when_LocalFileStoreSaveFile_then_success() throws IOException {
        FileItem fileItem = FileItem.of(FileType.USER_PROFILE, "test.txt", "String".getBytes());

        fileStore.store(fileItem);
    }
}