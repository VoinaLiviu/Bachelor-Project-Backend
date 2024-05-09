package com.thesisProject.cryptography.domain.jsonWrappers;

public class ResultDouble {
    private String algorithm1;
    private String algorithm2;
    private String ciphertext1;
    private String ciphertext2;
    private String runningTime1;
    private String runningTime2;
    private int security1;
    private int popularity1;
    private int security2;
    private int popularity2;

    public ResultDouble(String algorithm1, String algorithm2, String ciphertext1, String ciphertext2, String runningTime1, String runningTime2, int security1, int security2, int popularity1, int popularity2) {
        this.algorithm1 = algorithm1;
        this.algorithm2 = algorithm2;
        this.ciphertext1 = ciphertext1;
        this.ciphertext2 = ciphertext2;
        this.runningTime1 = runningTime1;
        this.runningTime2 = runningTime2;
        this.security1 = security1;
        this.security2 = security2;
        this.popularity1 = popularity1;
        this.popularity2 = popularity2;
    }

    public ResultDouble() {
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

    public String getCiphertext1() {
        return ciphertext1;
    }

    public void setCiphertext1(String ciphertext1) {
        this.ciphertext1 = ciphertext1;
    }

    public String getCiphertext2() {
        return ciphertext2;
    }

    public void setCiphertext2(String ciphertext2) {
        this.ciphertext2 = ciphertext2;
    }

    public String getRunningTime1() {
        return runningTime1;
    }

    public void setRunningTime1(String runningTime1) {
        this.runningTime1 = runningTime1;
    }

    public String getRunningTime2() {
        return runningTime2;
    }

    public void setRunningTime2(String runningTime2) {
        this.runningTime2 = runningTime2;
    }

    public int getSecurity1() {
        return security1;
    }

    public void setSecurity1(int security1) {
        this.security1 = security1;
    }

    public int getPopularity1() {
        return popularity1;
    }

    public void setPopularity1(int popularity1) {
        this.popularity1 = popularity1;
    }

    public int getSecurity2() {
        return security2;
    }

    public void setSecurity2(int security2) {
        this.security2 = security2;
    }

    public int getPopularity2() {
        return popularity2;
    }

    public void setPopularity2(int popularity2) {
        this.popularity2 = popularity2;
    }
}
