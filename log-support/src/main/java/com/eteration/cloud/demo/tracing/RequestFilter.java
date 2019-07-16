package com.eteration.cloud.demo.tracing;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class RequestFilter implements Filter{



    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        Enumeration<String> headerNames =  httpServletRequest.getHeaderNames();
        RequestContext.getContext().getHeaders().clear();

        while (headerNames.hasMoreElements()) {
			String name =  headerNames.nextElement();
			if(true || name.startsWith("x-") || name.startsWith("uber")) {
		        RequestContext.getContext().getHeaders().put(name, httpServletRequest.getHeader(name));

			}
			
		}
        
        chain.doFilter(request, response);

    }

    @Override
    public void destroy() { }

    @Override
    public void init(FilterConfig arg0) throws ServletException {}


}