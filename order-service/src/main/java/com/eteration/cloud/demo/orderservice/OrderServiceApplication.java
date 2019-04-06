package com.eteration.cloud.demo.orderservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import com.eteration.cloud.demo.tracing.RequestFilter;
import com.eteration.cloud.demo.tracing.RestTemplateHeaderModifierInterceptor;

@SpringBootApplication(scanBasePackages = "com.eteration.cloud.demo")

public class OrderServiceApplication {

	@Bean
	public FilterRegistrationBean getPeticionFilter() {

		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new RequestFilter());
		registration.addUrlPatterns("/*");
		registration.setName("requestFilter");

		return registration;
	}

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();

		List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
		if (CollectionUtils.isEmpty(interceptors)) {
			interceptors = new ArrayList<>();
		}
		interceptors.add(new RestTemplateHeaderModifierInterceptor());
		restTemplate.setInterceptors(interceptors);
		return restTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}
}
