package com.query_executor.encryption;

import lombok.extern.log4j.*;
import org.springframework.stereotype.*;

import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.security.spec.*;
import java.util.*;

/**
 * Service for encrypting and decrypting string values using AES encryption with a key derived from PBKDF2.
 * <p>
 * <b>Features:</b>
 * <ul>
 *     <li>Encrypts plain text strings to Base64-encoded AES-encrypted strings.</li>
 *     <li>Decrypts Base64-encoded AES-encrypted strings back to plain text.</li>
 *     <li>Uses PBKDF2WithHmacSHA256 for key derivation with a static key and salt.</li>
 * </ul>
 * <b>Security Note:</b> For production use, consider storing the key and salt securely and not hardcoding them.
 */
@Log4j2
@Service
public class EncryptionService {
    private static final String ENCRYPTION_KEY = "x7WaYrSrdp2Jko4gEfEFHtC1EUpR0ieW3Zzlxe1EUpR0ieW";

    private static final String ENCRYPTION_SALT = "1EUpR0ieW3Zzlxx7WaYrSrdp2Jko4gEfEFHtCe";
    private static final String ENCRYPTION_ALGO = "AES";


    /**
     * Encrypts the given plain text string using AES encryption.
     *
     * @param value the plain text string to encrypt
     * @return the Base64-encoded AES-encrypted string, or null if encryption fails
     */
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

    /**
     * Decrypts the given Base64-encoded AES-encrypted string back to plain text.
     *
     * @param value the Base64-encoded AES-encrypted string
     * @return the decrypted plain text string, or null if decryption fails
     */
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

    /**
     * Generates a secret AES key using PBKDF2 with the configured key and salt.
     *
     * @return the generated AES secret key
     * @throws NoSuchAlgorithmException if the PBKDF2 algorithm is not available
     * @throws InvalidKeySpecException if the key specification is invalid
     */
    private SecretKey generateSecretKey() throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        char[] keyBytes = ENCRYPTION_KEY.toCharArray();
        byte[] saltBytes = ENCRYPTION_SALT.getBytes();
        PBEKeySpec spec = new PBEKeySpec(keyBytes, saltBytes, 65536, 256);
        SecretKey secretKey = secretKeyFactory.generateSecret(spec);
        return new SecretKeySpec(secretKey.getEncoded(), "AES");
    }
}
