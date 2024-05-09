package com.thesisProject.cryptography.domain.jsonWrappers;

public class ToEncrypt {
     private String algorithm;
     private String key;
     private String message;

     public ToEncrypt(String algorithm, String key, String message) {
          this.algorithm = algorithm;
          this.key = key;
          this.message = message;
     }

     public String getAlgorithm() {
          return algorithm;
     }

     public void setAlgorithm(String algorithm) {
          this.algorithm = algorithm;
     }

     public String getKey() {
          return key;
     }

     public void setKey(String key) {
          this.key = key;
     }

     public String getMessage() {
          return message;
     }

     public void setMessage(String message) {
          this.message = message;
     }
}
