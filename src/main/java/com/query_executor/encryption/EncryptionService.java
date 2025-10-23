package com.query_executor.encryption;

import lombok.extern.log4j.*;
import org.springframework.stereotype.*;

import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.security.spec.*;
import java.util.*;

@Log4j2
@Service
public class EncryptionService {
    private static final String ENCRYPTION_KEY = "x7WaYrSrdp2Jko4gEfEFHtC1EUpR0ieW3Zzlxe1EUpR0ieW";

    private static final String ENCRYPTION_SALT = "1EUpR0ieW3Zzlxx7WaYrSrdp2Jko4gEfEFHtCe";
    private static final String ENCRYPTION_ALGO = "AES";


    public String encrypt(String value) {
        try {
            SecretKey secretKey = generateSecretKey();
            Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGO);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            cipher.doFinal(value.getBytes());
            return Base64.getEncoder().encodeToString(cipher.doFinal(value.getBytes()));
        } catch (Exception e) {
            log.error("Error while encrypting value", e);
        }
        return null;
    }

    public String decrypt(String value) {
        try {
            SecretKey secretKey = generateSecretKey();
            Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGO);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(value));
            return new String(decryptedBytes);
        } catch (Exception e) {
            log.error("Error while decrypting value", e);
        }
        return null;
    }

    private SecretKey generateSecretKey() throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        char[] keyBytes = ENCRYPTION_KEY.toCharArray();
        byte[] saltBytes = ENCRYPTION_SALT.getBytes();
        PBEKeySpec spec = new PBEKeySpec(keyBytes, saltBytes, 65536, 256);
        SecretKey secretKey = secretKeyFactory.generateSecret(spec);
        return new SecretKeySpec(secretKey.getEncoded(), "AES");
    }
}
