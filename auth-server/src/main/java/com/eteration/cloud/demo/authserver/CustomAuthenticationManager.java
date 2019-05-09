package com.eteration.cloud.demo.authserver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.common.exceptions.BadClientCredentialsException;
import org.springframework.stereotype.Component;


@Component
public class CustomAuthenticationManager implements AuthenticationManager{

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	    String username = authentication.getPrincipal() + "";
	    String password = authentication.getCredentials() + "";
	    

	    if(!"murat".equals(username) || !"123".equals(password)) {
	    	throw new BadClientCredentialsException();
	    }
	    
	    
	    List<String> userRights = new ArrayList<>();
	    userRights.add("USER");
	    return new UsernamePasswordAuthenticationToken(username, password, userRights.stream().map(x -> new SimpleGrantedAuthority(x)).collect(Collectors.toList()));
	}
}