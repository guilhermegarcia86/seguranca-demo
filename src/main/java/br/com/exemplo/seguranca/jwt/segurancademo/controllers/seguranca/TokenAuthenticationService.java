package br.com.exemplo.seguranca.jwt.segurancademo.controllers.seguranca;

import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenAuthenticationService {

	private static String secret = "MySecret";

	private static Long expiration = (long) 860_000_000;
	
	private static String tokenHeader = "Authorization";
	
 	private static String tokenPrefix = "Bearer";
	
	static void addAuthentication(HttpServletResponse response, String username) {
		String JWT = Jwts.builder()
				.setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + expiration))
				.signWith(SignatureAlgorithm.HS512, secret)
				.compact();
		
		response.addHeader(tokenHeader, tokenPrefix + " " + JWT);
	}
	
	static Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader(tokenHeader);
		
		if (token != null) {
			// faz parse do token
			String user = Jwts.parser()
					.setSigningKey(secret)
					.parseClaimsJws(token.replace(tokenPrefix, ""))
					.getBody()
					.getSubject();
			
			if (user != null) {
				return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
			}
		}
		return null;
	}
}
