package com.onoffmix.yonsei.common.file;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UploadFile {

    private StoreType storeType;
    private String originalName;
    private String encodedName;
    private String storageFullPath;

    /*the size of the file in bytes.*/
    private Long size;

    public static UploadFile of(StoreType storeType, String originalName, String encodedName, String fullPath, Long size) {
        return new UploadFile(storeType, originalName, encodedName, fullPath, size);
    }

    public static UploadFile createEmptyFile() {
        return new UploadFile(StoreType.NONE, "", "", "", 0L);
    }
}
