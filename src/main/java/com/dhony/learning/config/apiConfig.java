package com.dhony.learning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@Configuration
public class apiConfig implements WebMvcConfigurer  {
	@Override
	   public void addCorsMappings(CorsRegistry registry) {
	       registry.addMapping("/**").allowCredentials(true).allowedMethods("GET","PUT","POST","HEAD","DELETE","OPTIONS");
	   }
	//Object mapper
	
	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
	
	//Object writter , will print json in human readable format
	
	@Bean
	public ObjectWriter objectWritter(ObjectMapper objectMapper) {
		return objectMapper.writerWithDefaultPrettyPrinter();
	}
	
	
}
