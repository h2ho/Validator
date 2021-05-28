package com.hjho.validator.util;

import org.apache.commons.lang3.StringUtils;

public class ValidationUtil {
	
	
	
	/**
	 * Check if any duplicate pattern
	 * @param input
	 * @return boolean
	 */
	public static boolean checkRepeat(String input) {
		
		if(input == null)
			return false;
		
		if(input.length() == 0)
			return true;
		
		for(int i = 1; i <= input.length()/2; i++) {
			for(int j = 0; j < input.length(); j++) {
				if(j + 2 * i <= input.length()) {
					if(isRepeat(input, input.substring(j, j+i), j))
						return true;
				}				
			}
		}
		
		return false;
	} 
	
	static boolean isRepeat(String input, String pattern, int startIndex) {
		
		input = input.substring(startIndex + pattern.length());
	    int currIndex = input.indexOf(pattern);
	    if(currIndex == 0)
	    	return true;
	    else
	    	return false;
		
	}
	
	public static boolean checkLength(String input, int min, int max) {
		
		if(input == null)
			return false;
		
		return (input.length() >= min && input.length() <= max);
	}
	
	
	public static boolean checkLowerCaseAlphanumeric(String input) {
		
		if(input == null)
			return false;
		
		return StringUtils.isAlphanumeric(input) 
				&& !input.chars().anyMatch(Character::isUpperCase)
				&& input.chars().anyMatch(Character::isDigit);
	}
	
	
}
