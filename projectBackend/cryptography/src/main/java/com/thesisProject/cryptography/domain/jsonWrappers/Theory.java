package com.thesisProject.cryptography.domain.jsonWrappers;

public class Theory {
    private String theoryLine;

    public Theory(String theory) {
        this.theoryLine = theory;
    }

    public Theory() {
    }

    public String getTheoryLine() {
        return theoryLine;
    }

    public void setTheoryLine(String theoryLine) {
        this.theoryLine = theoryLine;
    }
}
