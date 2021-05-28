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
public class NonRepeatingRuleTest {

	@Autowired
	NonRepeatingRule nonRepeatingRule;
	
	@Test
	public void nonRepeatingRuleTest() {
		
		Assert.assertTrue(ValidationUtil.checkRepeat("fastast"));		
		Assert.assertFalse(ValidationUtil.checkRepeat(null));
		Assert.assertTrue(ValidationUtil.checkRepeat(""));
		Assert.assertTrue(ValidationUtil.checkRepeat("aa"));
		
	}
}
