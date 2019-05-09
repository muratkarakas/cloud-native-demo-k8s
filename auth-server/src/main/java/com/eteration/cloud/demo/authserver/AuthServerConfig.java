package com.eteration.cloud.demo.authserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {
     
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
 
    
    
    @Autowired
    private AuthenticationManager authenticationManager;
    @Override
    public void configure(
      AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.tokenKeyAccess("permitAll()")
          .checkTokenAccess("isAuthenticated()");
    }
 
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

		/* @formatter:off */
		endpoints
				.authenticationManager(authenticationManager);
				//.authorizationCodeServices(authorizationCodeServices)
				//.userDetailsService(userDetailsService)
				//.tokenGranter(tokenGranter());
		/* @formatter:on */



	}
    
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
          .withClient("SampleClientId")
          .secret(passwordEncoder.encode("secret"))
          .authorizedGrantTypes("read","write", "password","authorization_code","refresh_token","implicit")
          .scopes("user_info")
          .autoApprove(true) 
          .redirectUris("http://localhost:8082/ui/login","http://localhost:8083/ui2/login"); 
    }
}