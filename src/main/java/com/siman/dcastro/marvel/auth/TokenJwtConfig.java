package com.siman.dcastro.marvel.auth;

import java.security.Key;

import io.jsonwebtoken.security.Keys;

public class TokenJwtConfig {
    
    
    public final static Key SECRET_KEY = Keys.hmacShaKeyFor("Ap1M@rv3LDEVADFEWR234298923sfzzzerer".getBytes());
    public final static String PREFIX_TOKEN = "Bearer ";
    public final static String HEADER_AUTHORIZATION = "Authorization";

}
