package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
//@Dev
@Production
@PropertySource(ignoreResourceNotFound=true,value="classpath:${spring.profiles.active}.properties")
public class SimpleBeanPropTest {
	
	@Value("${hello.name}")
	private String authLink;

	@Bean(name = "gg")
	public String gg() {
		System.out.println(authLink);
		return authLink;
	}
}
