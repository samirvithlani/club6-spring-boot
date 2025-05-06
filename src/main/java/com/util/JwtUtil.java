package com.util;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

//@service @componnet @Repository
@Component
public class JwtUtil {

	
	String SECRET_KEY = "hithisissamirvithlaniandiambestinanythingokokokokokokoskokoskokdokcjndjnijqwom";
	SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());	
	public String generateToken(String username) {
		
		return Jwts.builder()
				.setSubject(username)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 *60 *10))
				.signWith(SignatureAlgorithm.HS256,SECRET_KEY).compact();
	}
	
	public String getUsername(String token) {
		
		return Jwts.parser().setSigningKey(SECRET_KEY)
				.parseClaimsJws(token)
				.getBody().getSubject();
	}
	
	public boolean validatToken(String token,UserDetails userDetails) {
		
		return getUsername(token).equals(userDetails.getUsername());
	}
	
}
