package com.hjho.validator.bean;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NonRepeatingRuleTests {

	@Autowired
	NonRepeatingRule nonRepeatingRule;
	
	@Test
	public void nonRepeatingRuleTest() {
		
		Assert.assertFalse(nonRepeatingRule.isValid("fastast"));	
		Assert.assertFalse(nonRepeatingRule.isValid("abcdabcd"));
		Assert.assertFalse(nonRepeatingRule.isValid(null));
		Assert.assertTrue(nonRepeatingRule.isValid(""));
		Assert.assertFalse(nonRepeatingRule.isValid("aa"));
		Assert.assertTrue(nonRepeatingRule.isValid("abcdefg"));
		
	}
}
