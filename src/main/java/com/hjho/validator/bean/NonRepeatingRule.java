package com.hjho.validator.bean;

public class NonRepeatingRule  implements IRule {

	@Override
	public boolean isValid(String input) {		
		
		if(input == null)
			return false;
		
		if(input.length() == 0)
			return true;
		
		for(int i = 1; i <= input.length()/2; i++) {
			for(int j = 0; j < input.length(); j++) {
				if(j + 2 * i <= input.length()) {
					if(isRepeat(input, input.substring(j, j+i), j))
						return false;
				}				
			}
		}
		
		return true;
	}
	
	boolean isRepeat(String input, String pattern, int startIndex) {
		
		input = input.substring(startIndex + pattern.length());
	    int currIndex = input.indexOf(pattern);
	    if(currIndex == 0)
	    	return true;
	    else
	    	return false;
		
	}

}
