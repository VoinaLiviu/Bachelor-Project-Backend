package com.thesisProject.cryptography.domain.jsonWrappers;

public class CodeSnippet {
    private String codeLine;

    public CodeSnippet(String codeLine) {
        this.codeLine = codeLine;
    }

    public CodeSnippet() {
    }

    public String getCodeLine() {
        return codeLine;
    }

    public void setCodeLine(String codeLine) {
        this.codeLine = codeLine;
    }
}
