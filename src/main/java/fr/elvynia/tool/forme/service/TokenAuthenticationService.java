package fr.elvynia.tool.forme.service;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenAuthenticationService {

	private final long EXPIRATIONTIME = 864_000_000; // 10 days
	private final String HEADER_STRING = "Authorization";
	private final String SECRET = "formesecret";
	private final String TOKEN_PREFIX = "Bearer";

	public void addAuthentication(HttpServletResponse res, String username) {
		String JWT = Jwts.builder().setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + this.EXPIRATIONTIME))
				.signWith(SignatureAlgorithm.HS512, this.SECRET).compact();
		try {
			res.getWriter().append("{\"token\":\"" + JWT + "\"}").flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader(this.HEADER_STRING);
		if (token != null) {
			// parse the token.
			String user = Jwts.parser().setSigningKey(this.SECRET).parseClaimsJws(token.replace(this.TOKEN_PREFIX, ""))
					.getBody().getSubject();

			return user != null ? new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList()) : null;
		}
		return null;
	}
}
