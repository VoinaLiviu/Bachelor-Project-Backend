package com.thesisProject.cryptography.domain.jsonWrappers;

public class Result {
    private String algorithm;
    private String ciphertext;
    private String runningTime;
    private int security;
    private int popularity;

    public Result() {

    }

    public Result(String algorithm, String ciphertext, String runningTime,  int security, int popularity) {
        this.algorithm = algorithm;
        this.ciphertext = ciphertext;
        this.runningTime = runningTime;
        this.security = security;
        this.popularity = popularity;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getCiphertext() {
        return ciphertext;
    }

    public void setCiphertext(String ciphertext) {
        this.ciphertext = ciphertext;
    }

    public String getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(String runningTime) {
        this.runningTime = runningTime;
    }

    public int getSecurity() {
        return security;
    }

    public void setSecurity(int security) {
        this.security = security;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }
}
