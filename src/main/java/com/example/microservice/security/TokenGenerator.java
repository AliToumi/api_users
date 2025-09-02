package com.example.microservice.security;

import io.smallrye.jwt.build.Jwt;

import java.util.Arrays;

public class TokenGenerator {

    public static String generateUserToken() {
        return Jwt.issuer("https://example-issuer.com")
                .upn("jean.dupont@example.com")
                .groups(new java.util.HashSet<>(Arrays.asList("user")))
                .sign();
    }

    public static String generateAdminToken() {
        return Jwt.issuer("https://example-issuer.com")
                .upn("admin@example.com")
                .groups(new java.util.HashSet<>(Arrays.asList("admin")))
                .sign();
    }

    public static void main(String[] args) {
        System.out.println("User token: " + generateUserToken());
        System.out.println("Admin token: " + generateAdminToken());
    }
}
