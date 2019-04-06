package com.eteration.cloud.demo.tracing;

import java.util.HashMap;
import java.util.Map;

public class RequestContext {


	private static final ThreadLocal<RequestContext> CONTEXT = new ThreadLocal<>();

	private Map<String, String> headers = new HashMap<>();

	public static RequestContext getContext() {
		RequestContext result = CONTEXT.get();

		if (result == null) {
			result = new RequestContext();
			CONTEXT.set(result);
		}

		return result;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	
}