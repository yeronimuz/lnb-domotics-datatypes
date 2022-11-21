package com.lankheet.iot.crypto;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

/**
 * Encrypt and decrypt data
 * See https://www.thoughts-on-java.org/how-to-use-jpa-type-converter-to/
 */
@Converter
public class CryptoConverter implements AttributeConverter<String, String> {

    private static final String ALGORITHM = "AES/ECB/PKCS5Padding";
    private static final byte[] KEY = "g3H31mH0ud1ng5Pl".getBytes();
    private static final String SECRET_KEY_ALGORITHM = "AES";

    @Override
    public String convertToDatabaseColumn(String password) {
        // do some encryption
        Key key = new SecretKeySpec(KEY, SECRET_KEY_ALGORITHM);
        try {
            Cipher c = Cipher.getInstance(ALGORITHM);
            c.init(Cipher.ENCRYPT_MODE, key);
            return Base64.getEncoder().encodeToString(c.doFinal(password.getBytes()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        // do some decryption
        Key key = new SecretKeySpec(KEY, SECRET_KEY_ALGORITHM);
        try {
            Cipher c = Cipher.getInstance(ALGORITHM);
            c.init(Cipher.DECRYPT_MODE, key);
            return new String(c.doFinal(Base64.getDecoder().decode(dbData)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
