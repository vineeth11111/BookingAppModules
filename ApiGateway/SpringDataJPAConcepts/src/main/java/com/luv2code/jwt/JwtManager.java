package com.luv2code.jwt;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtManager {

	public String createToken(String userId) {

		return Jwts.builder().setSubject(userId).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 5 * 60 *1000))
				.signWith(SignatureAlgorithm.HS256, "ABCDEFGH").compact();
	}
	
	public String getUser(String token) {

		return Jwts.parser().setSigningKey("ABCDEFGH").parseClaimsJws(token).getBody().getSubject();
	}

	public boolean isValidUser(String loginUserName, String token) {

		String tokenUserName = Jwts.parser().setSigningKey("ABCDEFGH").parseClaimsJws(token).getBody().getSubject();
		return tokenUserName.equals(loginUserName);
	}

	public boolean isTokenExpired(String token) {

		Date tokenExpirationDate = Jwts.parser().setSigningKey("ABCDEFGH").parseClaimsJws(token).getBody()
				.getExpiration();
		return tokenExpirationDate.after(new Date());
	}

	public boolean isValidToken(String loginUserName, String token) {
		return isValidUser(loginUserName, token) && isTokenExpired(token);
	}
}
