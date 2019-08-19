package com.example;

import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Profile("dev")
//@PropertySource(ignoreResourceNotFound=true,value="classpath:dev.properties")
public @interface Dev {

}