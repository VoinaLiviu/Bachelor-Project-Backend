package com.thesisProject.cryptography.domain.algorithms;

import com.thesisProject.cryptography.domain.jsonWrappers.Result;
import com.thesisProject.cryptography.domain.jsonWrappers.ToEncrypt;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DESTest {
    static ToEncrypt toEncrypt;
    static DES des;
     static Result result;

    @BeforeAll
    static void initializeVariables() {
        toEncrypt = new ToEncrypt("DES", "key","encryptme");
        des = new DES(toEncrypt);
        result = des.run();
    }

    @Test
    void testRunTextChanged() {
        assertNotEquals("encryptme", result.getCiphertext());
    }

    @Test
    void testRunTextIsCorrect() {
        assertEquals("778409de93a2e8ad",result.getCiphertext());
    }

}