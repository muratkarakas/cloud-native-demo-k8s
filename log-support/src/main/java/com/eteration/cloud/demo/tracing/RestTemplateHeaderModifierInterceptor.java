package com.eteration.cloud.demo.tracing;

import java.io.IOException;
import java.util.Set;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

public class RestTemplateHeaderModifierInterceptor implements ClientHttpRequestInterceptor {

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {

		
		
		Set<String> names = RequestContext.getContext().getHeaders().keySet();
		
		for (String name : names) {
			request.getHeaders().add(name, RequestContext.getContext().getHeaders().get(name));

		}
		
		return execution.execute(request, body);

	}
}