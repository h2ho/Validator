package com.hjho.validator;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hjho.validator.controller.ValidateController;

@SpringBootTest
class ValidatorApplicationTests {

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ValidatorApplicationTests.class);
	
	@Autowired
	ValidateController validataController;
	
	@Test
	void contextLoads() {
		
		Assert.assertNotNull(validataController);
		
		try {
			ValidatorApplication.main(new String[0]);
		}catch(Exception ex) {
			log.error("Failed to initiliazw spring app, cause {}", ex.getMessage());
		}
		
	}

}
