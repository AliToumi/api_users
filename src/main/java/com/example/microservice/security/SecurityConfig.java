package com.example.microservice.security;


import jakarta.annotation.security.DeclareRoles;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/")
@DeclareRoles({"admin", "user"})
public class SecurityConfig extends Application {
}
