package com.springSecurity.SpringSecurity2.security;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Base64;

public class KeyGenerator {
    public static void main(String[] args) {
        // Generar una clave secreta
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256); // Utiliza el algoritmo HS256
        String base64Key = Base64.getEncoder().encodeToString(key.getEncoded());

        // Imprimir la clave secreta en base64
        System.out.println("Clave secreta generada (Base64): " + base64Key);
    }
}

