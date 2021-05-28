package com.hjho.validator.bean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	@Bean
	@Qualifier("CollectionRules")
    public LengthRule getLengthRule() {
        return new LengthRule(5,12);
    }

    @Bean
    @Qualifier("CollectionRules")
    public NonRepeatingRule getNonRepeatingRule() {
        return new NonRepeatingRule();
    }

    @Bean
    @Qualifier("CollectionRules")
    public AlphanumericRule getAlphanumericRule() {
        return new AlphanumericRule();
    }
	
}
