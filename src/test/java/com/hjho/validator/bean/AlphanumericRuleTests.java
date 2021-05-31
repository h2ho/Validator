package com.hjho.validator.bean;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlphanumericRuleTests {

	@Autowired
	AlphanumericRule alphanumericRule;
	
	
	
	@Test
	public void alphaNumericRuleTest() {

		Assert.assertFalse(alphanumericRule.isValid(null));		
		Assert.assertFalse(alphanumericRule.isValid("abcd"));
		Assert.assertFalse(alphanumericRule.isValid("Abfd"));				
		Assert.assertFalse(alphanumericRule.isValid("aAcd12"));
		Assert.assertTrue(alphanumericRule.isValid("ab1"));
		Assert.assertTrue(alphanumericRule.isValid("abcd12"));
	}
}
