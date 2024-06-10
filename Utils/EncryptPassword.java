package utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class EncryptPassword {

    public static String toSHA1(String password) {
        String salt = "nhibeodangiu";
        String passwordWithSalt = password + salt;
        String result = null;

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            byte[] encodedHash = digest.digest(passwordWithSalt.getBytes(StandardCharsets.UTF_8));
            result = Base64.getEncoder().encodeToString(encodedHash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return result;
    }
}