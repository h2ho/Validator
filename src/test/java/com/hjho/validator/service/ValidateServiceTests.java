package com.hjho.validator.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ValidateServiceTests {

	@Autowired 
	ValidateService validateService;
	
	@Test
	public void validateTest() {
		
		Assert.assertTrue(validateService.validate("1234QADC"));
		
	}
}
