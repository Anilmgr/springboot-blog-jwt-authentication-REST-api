package com.anilcodes.springbootblogjwtauthenticationRESTapi.security.filter;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.anilcodes.springbootblogjwtauthenticationRESTapi.security.user.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
	private static final Logger LOGGER = LoggerFactory.getLogger(JWTAuthorizationFilter.class);
	
	
	private String prefix;
	
	private String header;
	
	private String secret;
	
	private UserService userService;	

	public JWTAuthorizationFilter(AuthenticationManager authenticationManager,
			UserService userService, String header, String prefix, String secret) {
		super(authenticationManager);
		this.header = header;
		this.prefix = prefix;
		this.secret = secret;
		this.userService = userService;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String header = request.getHeader(this.header);
		if(Objects.isNull(header) || !header.startsWith(this.prefix)) {
			chain.doFilter(request, response);
			return;
		}
		UsernamePasswordAuthenticationToken authenticationToken = getAuthenticationToken(request);
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		chain.doFilter(request, response);
	}
	
	private UsernamePasswordAuthenticationToken getAuthenticationToken(HttpServletRequest request) {
		String token = request.getHeader(this.header);
		if(token!=null) {
			token =  token.replace(this.prefix,"");
			String user = null;
			try {
				user = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody().getSubject();
			} catch (SignatureException e) {
				LOGGER.error(e.getMessage());
			}
			
			if(Objects.nonNull(user)) {
				UserDetails userDetails = userService.loadUserByUsername(user);
				return new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
			}
		}
		return null;
	}

}
