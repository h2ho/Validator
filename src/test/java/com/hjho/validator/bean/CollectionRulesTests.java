package com.hjho.validator.bean;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CollectionRulesTests {

	@Autowired(required = false)
	@Qualifier("CollectionRules")
	List<IRule> rules;
	
	@Test
	public void rulesTest() {
		Assert.assertFalse(rules.isEmpty());
	}
}
