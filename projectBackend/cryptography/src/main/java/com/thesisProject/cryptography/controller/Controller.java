package com.thesisProject.cryptography.controller;

import com.thesisProject.cryptography.domain.jsonWrappers.*;
import com.thesisProject.cryptography.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class Controller {
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    @Autowired
    Service service;

    @PostMapping("/encrypt/encryptMessage")
    public ResponseEntity<Result> encryptMessage(@RequestBody ToEncrypt toEncrypt) {
        logger.info("Received the following message to encrypt: {}", toEncrypt.getMessage());
        logger.info("Algorithm: {}", toEncrypt.getAlgorithm());
        return ResponseEntity.ok(service.encrypt(toEncrypt));
    }

    @PostMapping("/encrypt/encryptMessageDouble")
    public ResponseEntity<ResultDouble> encryptMessageDouble(@RequestBody ToEncryptDouble toEncryptDouble) {
        logger.info("Received the following message to encrypt: {}", toEncryptDouble.getMessage());
        logger.info("Algorithm1: {}", toEncryptDouble.getAlgorithm1());
        logger.info("Algorithm2: {}", toEncryptDouble.getAlgorithm2());
        return ResponseEntity.ok(service.encryptDouble(toEncryptDouble));
    }

    @PostMapping("/implement/getCode")
    public ResponseEntity<List<CodeSnippet>> getCode(@RequestBody FileLocation fileName) {
        logger.info("Received file location: {}", fileName.getFileName());
        try {
            return ResponseEntity.ok(service.getAlgorithm(fileName));
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(null);
    }

    @PostMapping("/learn/getTheory")
    public ResponseEntity<List<Theory>> getTheory(@RequestBody FileLocation fileName) {
        logger.info("Received file location: {}", fileName.getFileName());
        try {
            return ResponseEntity.ok(service.getTheory(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(null);
    }

   /* @PostMapping("/learn/getTheoryList")
    public ResponseEntity<List<Theory>> getTheoryList(@RequestBody FileLocation fileName) {
        logger.info("Received file location: {}", fileName);
        try {
            return ResponseEntity.ok(service.getTheoryList(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(null);
    }*/
}
