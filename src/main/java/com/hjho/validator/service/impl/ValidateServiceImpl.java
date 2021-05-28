package com.hjho.validator.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hjho.validator.service.ValidateService;


@Service
public class ValidateServiceImpl implements ValidateService{
	
	@Autowired
	@Qualifier("rules")
	public List<String> rules;
	

	public boolean validate(String passowrd) {
		

		return true;
	}

}
