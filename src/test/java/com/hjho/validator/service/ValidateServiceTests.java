package com.hjho.validator.service;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Map;

import org.hamcrest.collection.IsMapContaining;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidateServiceTests {

	@Autowired 
	ValidateService validateService;
	
	@Test
	public void validateTest() {
		Map<String, Boolean> result = validateService.validate("abc");
		assertThat(result, IsMapContaining.hasEntry("com.hjho.validator.bean.LengthRule", Boolean.FALSE));
		assertThat(result, IsMapContaining.hasEntry("com.hjho.validator.bean.NonRepeatingRule", Boolean.TRUE));
		assertThat(result, IsMapContaining.hasEntry("com.hjho.validator.bean.AlphanumericRule", Boolean.FALSE));
		
	}
}
