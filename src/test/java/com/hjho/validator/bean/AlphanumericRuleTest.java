package com.hjho.validator.bean;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hjho.validator.util.ValidationUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlphanumericRuleTest {

	@Autowired
	AlphanumericRule alphanumericRule;
	
	@Test
	public void alphaNumericRuleTest() {
		
		Assert.assertFalse(ValidationUtil.checkLowerCaseAlphanumeric(null));
		Assert.assertFalse(ValidationUtil.checkLowerCaseAlphanumeric("abcd"));
		Assert.assertFalse(ValidationUtil.checkLowerCaseAlphanumeric("Abfd"));		
		Assert.assertTrue(ValidationUtil.checkLowerCaseAlphanumeric("abcd12"));
	}
}
