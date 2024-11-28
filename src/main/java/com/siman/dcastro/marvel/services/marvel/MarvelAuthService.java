package com.siman.dcastro.marvel.services.marvel;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MarvelAuthService {

    @Value("${marvel.api.public-key}")
    private String publicKey;

    @Value("${marvel.api.private-key}")
    private String privateKey;

    public MarvelAuth generateAuth() {
        String timestamp = String.valueOf(System.currentTimeMillis());
        String toHash = timestamp + privateKey + publicKey;
        String hash = generateMd5Hash(toHash);
       

        return new MarvelAuth(timestamp, publicKey, hash);
    }

    private String generateMd5Hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al generar el hash MD5", e);
        }
    }

    public record MarvelAuth(String timestamp, String apiKey, String hash) {}

}
