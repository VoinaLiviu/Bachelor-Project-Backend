package com.thesisProject.cryptography.service;

import com.thesisProject.cryptography.domain.algorithms.DES;
import com.thesisProject.cryptography.domain.algorithms.DSA;
import com.thesisProject.cryptography.domain.algorithms.EncryptionAlgorithm;
import com.thesisProject.cryptography.domain.algorithms.RSA;
import com.thesisProject.cryptography.domain.jsonWrappers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@org.springframework.stereotype.Service
public class Service {
    private String codeAbsolutePath = "D:\\Liviu\\Faculta\\Licenta\\projectBackend\\cryptography\\src\\main\\java\\com\\thesisProject\\cryptography\\algorithms\\";
    private String theoryAbsolutePath = "D:\\Liviu\\Faculta\\Licenta\\projectBackend\\cryptography\\src\\main\\java\\com\\thesisProject\\cryptography\\theory\\";

    public EncryptionAlgorithm interpretRequest(ToEncrypt toEncrypt) {
        if (toEncrypt.getAlgorithm().equals("RSA")) {
            return new RSA(toEncrypt);
        }
        if (toEncrypt.getAlgorithm().equals("DES")) {
            return new DES(toEncrypt);
        }
        if (toEncrypt.getAlgorithm().equals("DSA")) {
            return new DSA(toEncrypt);
        } else return null;
    }

    public Result encrypt(ToEncrypt toEncrypt) {
        EncryptionAlgorithm algorithm = this.interpretRequest(toEncrypt);
        if (algorithm == null) return null;
        return algorithm.run();
    }

    public ResultDouble encryptDouble(ToEncryptDouble toEncryptDouble) {
        ToEncrypt toEncrypt1 = new ToEncrypt(toEncryptDouble.getAlgorithm1(), toEncryptDouble.getKey(), toEncryptDouble.getMessage());
        EncryptionAlgorithm algorithm1 = this.interpretRequest(toEncrypt1);

        ToEncrypt toEncrypt2 = new ToEncrypt(toEncryptDouble.getAlgorithm2(), toEncryptDouble.getKey(), toEncryptDouble.getMessage());
        EncryptionAlgorithm algorithm2 = this.interpretRequest(toEncrypt2);

        Result result1 = algorithm1.run();
        Result result2 = algorithm2.run();

        ResultDouble result = new ResultDouble(result1.getAlgorithm(), result2.getAlgorithm(), result1.getCiphertext(), result2.getCiphertext(), result1.getRunningTime(), result2.getRunningTime(), result1.getSecurity(), result2.getSecurity(), result1.getPopularity(), result2.getPopularity());
        return result;
    }

    public List<CodeSnippet> getAlgorithm(FileLocation fileName) throws FileNotFoundException {
        List<CodeSnippet> code = new ArrayList<>();
        String completeFileName = codeAbsolutePath + fileName.getFileName() + ".txt";
        File algorithmFile = new File(completeFileName);
        Scanner scanner = new Scanner(algorithmFile);
       while (scanner.hasNextLine()) {
           CodeSnippet codeLine = new CodeSnippet();
           codeLine.setCodeLine(scanner.nextLine());
           code.add(codeLine);
       }
       scanner.close();
        return code;
    }

    public List<Theory> getTheory(FileLocation fileName) throws FileNotFoundException {
        List<Theory> theory = new ArrayList<>();
        String completeFileLocation = theoryAbsolutePath + fileName.getFileName().toLowerCase() + ".txt";
        File theoryFile = new File(completeFileLocation);
        Scanner scanner = new Scanner(theoryFile);
        while (scanner.hasNextLine()) {
            Theory theoryLine = new Theory();
            theoryLine.setTheoryLine(scanner.nextLine());
            theory.add(theoryLine);
        }
        scanner.close();
        //System.out.println("finished");
        return theory;
    }
}
