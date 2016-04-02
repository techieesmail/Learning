package com.simple.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ CustomerConfig.class, EmployeeConfig.class })
public class AppConfig {

}