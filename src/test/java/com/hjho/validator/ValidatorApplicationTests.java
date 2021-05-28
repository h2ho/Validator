package com.hjho.validator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ValidatorApplicationTests {

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ValidatorApplicationTests.class);
	
	@Test
	void contextLoads() {
		try {
			ValidatorApplication.main(new String[0]);
		}catch(Exception ex) {
			log.error("Failed to initiliazw spring app, cause {}", ex.getMessage());
		}
		
	}

}
