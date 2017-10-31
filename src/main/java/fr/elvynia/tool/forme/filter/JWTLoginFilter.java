package fr.elvynia.tool.forme.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.elvynia.tool.forme.entity.Account;
import fr.elvynia.tool.forme.service.TokenAuthenticationService;

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(JWTLoginFilter.class);

	private final TokenAuthenticationService tokenService;

	public JWTLoginFilter(String url, AuthenticationManager authManager) {
		super(new AntPathRequestMatcher(url));
		this.setAuthenticationManager(authManager);
		this.tokenService = new TokenAuthenticationService();
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException, IOException, ServletException {
		Account creds = new ObjectMapper().readValue(req.getInputStream(), Account.class);
		return this.getAuthenticationManager()
				.authenticate(new UsernamePasswordAuthenticationToken(creds.getUsername(), creds.getPassword()));
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		this.tokenService.addAuthentication(res, auth.getName());
	}
}
