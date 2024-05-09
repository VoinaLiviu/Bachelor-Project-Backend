package com.thesisProject.cryptography.domain.algorithms;

import com.thesisProject.cryptography.domain.jsonWrappers.Result;
import com.thesisProject.cryptography.domain.jsonWrappers.ToEncrypt;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DSATest {
    static ToEncrypt toEncrypt;
    static DSA dsa;
    static Result result;

    @BeforeAll
    static void initializeVariables(){
        toEncrypt = new ToEncrypt("DSA", "key","encryptme");
        dsa = new DSA(toEncrypt);
        result = dsa.run();
    }

    @Test
    void testRunTextChanged() {
        assertNotEquals("encryptme", result.getCiphertext());
    }

    @Test
    void testRunTextIsCorrect() {
        assertEquals("encryptmeasdasd", result.getCiphertext());
    }

}