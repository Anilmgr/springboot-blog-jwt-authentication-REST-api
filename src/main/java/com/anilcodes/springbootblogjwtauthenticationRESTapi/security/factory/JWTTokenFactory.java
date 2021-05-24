package com.anilcodes.springbootblogjwtauthenticationRESTapi.security.factory;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTTokenFactory implements Serializable{

	private static final long serialVersionUID = -1316017042557999698L;
	
	@Value("${jwt.secret}")
	private String tokenSecret;
	
	@Value("${jwt.expires-in}")
	private long expirationTime;
	
	public String createToken(String email) {
		return Jwts.builder().setSubject(email).setExpiration(new Date(System.currentTimeMillis()+expirationTime))
				.signWith(SignatureAlgorithm.HS512, tokenSecret).compact();
	}
	
	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(tokenSecret).parseClaimsJws(token).getBody().getSubject();
	}

}
