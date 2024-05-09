package com.thesisProject.cryptography.domain.jsonWrappers;

public class ToEncryptDouble {
    private String algorithm1;
    private String algorithm2;
    private String key;
    private String message;

    public ToEncryptDouble(String algorithm1, String algorithm2, String key, String message) {
        this.algorithm1 = algorithm1;
        this.algorithm2 = algorithm2;
        this.key = key;
        this.message = message;
    }

    public ToEncryptDouble() {
    }

    public String getAlgorithm1() {
        return algorithm1;
    }

    public void setAlgorithm1(String algorithm1) {
        this.algorithm1 = algorithm1;
    }

    public String getAlgorithm2() {
        return algorithm2;
    }

    public void setAlgorithm2(String algorithm2) {
        this.algorithm2 = algorithm2;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
