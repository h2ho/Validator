package com.hjho.validator.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	@Bean (name = "rules")
    @ConfigurationProperties ( prefix = "rules" )
    public List<String> rules(){
        return new ArrayList<String>();
    }
}
