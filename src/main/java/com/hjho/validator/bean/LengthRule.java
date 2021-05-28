package com.hjho.validator.bean;

import org.springframework.beans.factory.BeanCreationException;

public class LengthRule implements IRule {

	int min = 0, max = 0;
	
	public LengthRule(int min, int max) {
		
		if(min < 0 || min > max) {
			throw new BeanCreationException("Invalid min, max value");
		}
		
		this.min = min;
		this.max = max;
	}
	
	public LengthRule() {}
	
	@Override
	public boolean isValid(String input) {
		
		if(input == null)
			return false;
		
		return (input.length() >= min && input.length() <= max);
	}
	
	public int getMin() {
		return min;
	}
	
	public void setMin(int min) {
		
		if( min < 0) {
			min = 0;
			return;
		}			
		
		this.min = min;
	}
	
	public int getMax() {
		return max;
	}
	
	public void setMax(int max) {
		
		if(max < min) {
			max = min;
			return;
		}			
		
		this.max = max;
	}
}
