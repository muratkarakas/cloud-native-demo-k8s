package com.eteration.cloud.demo;

import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TraceSampler {
	
	@Bean
	public AlwaysSampler sample() {
		return new AlwaysSampler();
	}

}
