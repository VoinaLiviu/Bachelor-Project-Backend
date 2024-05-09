package com.thesisProject.cryptography.domain.jsonWrappers;

public class FileLocation {
    private String fileName;

    public FileLocation(String fileName) {
        this.fileName = fileName;
    }

    public FileLocation() {}

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
