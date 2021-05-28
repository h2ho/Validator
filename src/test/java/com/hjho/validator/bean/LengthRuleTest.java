package com.hjho.validator.bean;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LengthRuleTest {
	
	@Autowired
	LengthRule lengthRule;

	@Test
	public void lengthRuleTest() {
		
		Assert.assertFalse(lengthRule.isValid(null));
		Assert.assertTrue(lengthRule.isValid("abcde"));
		Assert.assertTrue(lengthRule.isValid("abcdef"));
		Assert.assertFalse(lengthRule.isValid("ab"));		
		
	}
}
