package com.hjho.validator.service;

import java.util.Map;

public interface ValidateService {
	
	public Map<String, Boolean> validate(String password);
}
