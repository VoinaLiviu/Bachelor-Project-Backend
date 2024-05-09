package com.thesisProject.cryptography.domain.algorithms;

import com.thesisProject.cryptography.domain.jsonWrappers.Result;
import com.thesisProject.cryptography.domain.jsonWrappers.ToEncrypt;

import java.security.*;
import java.util.Scanner;
import jakarta.xml.bind.DatatypeConverter;
public class DSA implements EncryptionAlgorithm {
    private ToEncrypt toEncrypt;
    private int security = 3;
    private int popularity = 4;

    public DSA(ToEncrypt toEncrypt) {
        this.toEncrypt = toEncrypt;
    }

    private static final String
            SIGNING_ALGORITHM
            = "SHA256withRSA";
    private static final String RSA = "RSA";
    private static Scanner sc;

    // Function to implement Digital signature
    // using SHA256 and RSA algorithm
    // by passing private key.
    public static byte[] Create_Digital_Signature(
            byte[] input,
            PrivateKey Key)
            throws Exception
    {
        Signature signature
                = Signature.getInstance(
                SIGNING_ALGORITHM);
        signature.initSign(Key);
        signature.update(input);
        return signature.sign();
    }

    // Generating the asymmetric key pair
    // using SecureRandom class
    // functions and RSA algorithm.
    public static KeyPair Generate_RSA_KeyPair()
            throws Exception
    {
        SecureRandom secureRandom
                = new SecureRandom();
        KeyPairGenerator keyPairGenerator
                = KeyPairGenerator
                .getInstance(RSA);
        keyPairGenerator
                .initialize(
                        2048, secureRandom);
        return keyPairGenerator
                .generateKeyPair();
    }

    // Function for Verification of the
    // digital signature by using the public key
    public static boolean
    Verify_Digital_Signature(
            byte[] input,
            byte[] signatureToVerify,
            PublicKey key)
            throws Exception
    {
        Signature signature
                = Signature.getInstance(
                SIGNING_ALGORITHM);
        signature.initVerify(key);
        signature.update(input);
        return signature
                .verify(signatureToVerify);
    }
    @Override
    public Result run() {
        Result result = new Result();

        long startTime = System.nanoTime();

        String input = toEncrypt.getMessage();
        KeyPair keyPair
                = null;
        try {
            keyPair = Generate_RSA_KeyPair();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Function Call
        byte[] signature
                = new byte[0];
        try {
            signature = Create_Digital_Signature(
            input.getBytes(),
            keyPair.getPrivate());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        String signatureValue = DatatypeConverter
                .printHexBinary(signature);
        long endTime = System.nanoTime();
        String runningTime = String.valueOf((endTime-startTime)/1000) + " microSeconds";


     System.out.println(
                "Signature Value:\n "
                        + DatatypeConverter
                        .printHexBinary(signature));

        result.setAlgorithm(toEncrypt.getAlgorithm());
        System.out.println(toEncrypt.getMessage());
        result.setCiphertext(signatureValue);
        result.setRunningTime(runningTime);
        result.setSecurity(security);
        result.setPopularity(popularity);
        return result;
    }
}
