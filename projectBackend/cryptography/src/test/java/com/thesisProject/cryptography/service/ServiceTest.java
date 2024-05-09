package com.thesisProject.cryptography.service;

import com.thesisProject.cryptography.domain.jsonWrappers.FileLocation;
import com.thesisProject.cryptography.domain.jsonWrappers.Theory;
import com.thesisProject.cryptography.domain.jsonWrappers.ToEncrypt;
import com.thesisProject.cryptography.domain.algorithms.RSA;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {
    static Service service;
    static FileLocation theoryFilename;

    @BeforeAll
    static void initializeVariables(){
        service = new Service();
        theoryFilename = new FileLocation("testTheory");
    }

    @Test
    void testInterpretRequestNullResponse() {
        ToEncrypt toEncrypt = new ToEncrypt("Ceasar", "key", "message");
        assertNull(service.interpretRequest(toEncrypt));
    }

    @Test
    void testInterpretRequestCorrectAlgorithm() {
        ToEncrypt toEncrypt = new ToEncrypt("RSA", "key", "message");
        assertTrue(service.interpretRequest(toEncrypt) instanceof RSA);
    }

    @Test
    void testGetTheory() throws FileNotFoundException {
        List<Theory> theoryList = service.getTheory(theoryFilename);
        assertEquals("this is a test file", theoryList.get(0).getTheoryLine());
    }
}