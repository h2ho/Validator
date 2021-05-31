package com.hjho.validator.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hjho.validator.bean.ControllerExceptionHandler;
import com.hjho.validator.bean.IRule;
import com.hjho.validator.service.ValidateService;


@Service
public class ValidateServiceImpl implements ValidateService{
	
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ValidateServiceImpl.class);
	
	@Autowired(required = false)
	@Qualifier("CollectionRules")
	List<IRule> rules;
	
	public Map<String, Boolean> validate(String password) {
		
		Map<String, Boolean>  result = new HashMap<String,Boolean>();
		for(IRule rule: rules) {			
			Boolean valid = rule.isValid(password);
			result.put(rule.getClass().getName(),valid);
			log.debug("Rule: {}, Result: {}", rule.getClass().getName(), valid);
		}
		return result;
	}

}
