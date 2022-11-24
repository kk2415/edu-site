package com.onoffmix.yonsei.common.file;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@Getter
public class FileItem {

    private byte[] contents;
    private FileType fileType;
    private String name;
    private Long size;

    public FileItem(FileType fileType, byte[] contents) {
        this.contents = contents;
        this.fileType = fileType;
        this.name = fileType.name();
        this.size = (long) contents.length;
    }

    public FileItem(FileType fileType, MultipartFile multipartFile) throws IOException {
        if (multipartFile == null || multipartFile.isEmpty()) {
            throw new NullPointerException();
        }

        this.contents = multipartFile.getBytes();
        this.fileType = fileType;
        this.name = multipartFile.getOriginalFilename();
        this.size = multipartFile.getSize();
    }

    public FileItem(FileType fileType, File file) throws IOException {
        if (file == null) {
            throw new NullPointerException();
        }

        this.contents = Files.readAllBytes(file.toPath());
        this.fileType = fileType;
        this.name = file.getName();
        this.size = file.length();
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
