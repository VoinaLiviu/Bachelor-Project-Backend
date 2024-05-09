package com.thesisProject.cryptography.domain.algorithms;

import com.thesisProject.cryptography.domain.jsonWrappers.Result;
import com.thesisProject.cryptography.domain.jsonWrappers.ToEncrypt;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RSATest {
    static ToEncrypt toEncrypt;
    static RSA rsa;
    static Result result;

    @BeforeAll
    static void initializeVariables() {
        toEncrypt = new ToEncrypt("RSA", "key","encryptme");
        rsa = new RSA(toEncrypt);
        result = rsa.run();
    }

    @Test
    void testRunTextChanged() {
        assertNotEquals("encryptme", result.getCiphertext());
    }

    @Test
    void testRunTextIsCorrect() {
        assertEquals("asd54f65der7tflht8",result.getCiphertext());
    }

}