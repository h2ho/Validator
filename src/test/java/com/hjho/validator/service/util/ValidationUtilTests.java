package com.hjho.validator.service.util;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.hjho.validator.util.ValidationUtil;

@SpringBootTest
public class ValidationUtilTests {
	
	@Test
	public void checkRepeatTest() {
		
			
		Assert.assertTrue(ValidationUtil.checkRepeat("fastast"));		
		Assert.assertFalse(ValidationUtil.checkRepeat(null));
		Assert.assertTrue(ValidationUtil.checkRepeat(""));
		Assert.assertTrue(ValidationUtil.checkRepeat("aa"));	
	}

	@Test
	public void checkLowerCaseAlphanumericTest() {
		
		Assert.assertFalse(ValidationUtil.checkLowerCaseAlphanumeric(null));
		Assert.assertFalse(ValidationUtil.checkLowerCaseAlphanumeric("abcd"));
		Assert.assertFalse(ValidationUtil.checkLowerCaseAlphanumeric("Abfd"));		
		Assert.assertTrue(ValidationUtil.checkLowerCaseAlphanumeric("abcd12"));
	}
	
	@Test
	public void checkLengthTest() {
		
		Assert.assertFalse(ValidationUtil.checkLength(null,1,5));
		Assert.assertTrue(ValidationUtil.checkLength("abcde",1,5));
		Assert.assertFalse(ValidationUtil.checkLength("abcdef",1,5));
		Assert.assertFalse(ValidationUtil.checkLength("ab",3,5));		
		
		
	}
}
