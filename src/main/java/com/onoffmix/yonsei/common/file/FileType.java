package com.onoffmix.yonsei.common.file;

public enum FileType {

    USER_PROFILE("user/profile"),
    VIDEO_THUMBNAIL("video/thumbnail"),
    COURSE_THUMBNAIL("course/thumbnail"),
    NONE("");

    private String dir;

    FileType(String dir) {
        this.dir = dir;
    }

    public String getDir() {
        return dir;
    }
}
