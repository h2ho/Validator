package com.hjho.validator.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hjho.validator.bean.IRule;
import com.hjho.validator.service.ValidateService;


@Service
public class ValidateServiceImpl implements ValidateService{
	
	@Autowired(required = false)
	@Qualifier("CollectionRules")
	List<IRule> rules;
	
	public Map<String, Boolean> validate(String password) {
		
		Map<String, Boolean>  result = new HashMap<String,Boolean>();
		for(IRule rule: rules) {
			result.put(rule.getClass().getName(), rule.isValid(password));
		}
		return result;
	}

}
