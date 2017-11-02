package fr.elvynia.tool.forme.service;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.elvynia.tool.forme.entity.Account;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenAuthenticationService {

	private final long EXPIRATIONTIME = 864_000_000; // 10 days
	private final String HEADER_AUTH = "Authorization";
	private final String SECRET = "formesecret";
	private final String TOKEN_PREFIX = "Bearer";

	public void addAuthentication(HttpServletResponse res, Account account) {
		String JWT = Jwts.builder().setSubject(account.getUsername())
				.setExpiration(new Date(System.currentTimeMillis() + this.EXPIRATIONTIME))
				.signWith(SignatureAlgorithm.HS512, this.SECRET).compact();
		account.setToken(JWT);
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(res.getOutputStream(), account);
			res.flushBuffer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader(this.HEADER_AUTH);
		if (token != null) {
			// parse the token.
			String user = Jwts.parser().setSigningKey(this.SECRET).parseClaimsJws(token.replace(this.TOKEN_PREFIX, ""))
					.getBody().getSubject();

			return user != null ? new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList()) : null;
		}
		return null;
	}
}
