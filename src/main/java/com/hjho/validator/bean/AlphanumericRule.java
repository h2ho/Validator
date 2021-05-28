package com.hjho.validator.bean;

import org.apache.commons.lang3.StringUtils;

public class AlphanumericRule implements IRule{

	@Override
	public boolean isValid(String input) {
		
		if(input == null)
			return false;
		
		return StringUtils.isAlphanumeric(input) 
				&& !input.chars().anyMatch(Character::isUpperCase)
				&& input.chars().anyMatch(Character::isDigit);
	}

}
