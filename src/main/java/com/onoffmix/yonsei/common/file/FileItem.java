package com.onoffmix.yonsei.common.file;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class FileItem {

    private byte[] contents;
    private FileType fileType = FileType.NONE;
    private String name;
    private Long size = 0L;

    private FileItem(FileType fileType, byte[] contents) {
        this.contents = contents;
        this.fileType = fileType;
        this.name = fileType.name();
        this.size = (long) contents.length;
    }

    private FileItem(FileType fileType, String name, byte[] contents) {
        this.contents = contents;
        this.fileType = fileType;
        this.name = name;
        this.size = (long) contents.length;
    }

    private FileItem(FileType fileType, MultipartFile multipartFile) throws IOException {
        if (multipartFile != null && !multipartFile.isEmpty()) {
            this.contents = multipartFile.getBytes();
            this.fileType = fileType;
            this.name = multipartFile.getOriginalFilename();
            this.size = multipartFile.getSize();
        }
    }

    private FileItem(FileType fileType, File file) throws IOException {
        if (file != null) {
            this.contents = Files.readAllBytes(file.toPath());
            this.fileType = fileType;
            this.name = file.getName();
            this.size = file.length();
        }
    }

    public static FileItem of(FileType fileType, byte[] contents) {
        return new FileItem(fileType, contents);
    }

    public static FileItem of(FileType fileType, String name, byte[] contents) {
        return new FileItem(fileType, name, contents);
    }

    public static FileItem of(FileType fileType, MultipartFile multipartFile) throws IOException {
        return new FileItem(fileType, multipartFile);
    }

    public static FileItem of(FileType fileType, File file) throws IOException {
        return new FileItem(fileType, file);
    }

    public InputStream getInputStream() {
        return new ByteArrayInputStream(this.contents);
    }

    public void write(OutputStream out) throws IOException {
        out.write(contents);
    }

    public void write(String path) throws IOException {
        Files.write(Paths.get(path), contents);
    }

    public boolean isEmpty() {
        return contents == null || contents.length == 0;
    }
}
