package com.hjho.validator.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ValidateControllerTests {

	@Autowired
	private MockMvc mockMvc;
	
	String VERSION = "/api/v1";
	
	//String Based
	// delimiter
	// mixed case
	// length
	// white space

	@Test
	public void validateStringTest() throws Exception {		
		
	    mockMvc.perform(post(VERSION + "/validate").contentType(MediaType.APPLICATION_FORM_URLENCODED).param("password", "abcdQ234"))
	    	.andDo(print())
	    	.andExpect(status().isOk());	  
	    
	    mockMvc.perform(post(VERSION + "/validate").contentType(MediaType.APPLICATION_FORM_URLENCODED).param("password", "aatre123"))
    	.andDo(print())
    	.andExpect(status().isOk());	   
	    
	}
	
	@Test
	public void validateStringCaseTest() throws Exception {		
		
	    mockMvc.perform(post(VERSION + "/validate").contentType(MediaType.APPLICATION_FORM_URLENCODED).param("password", "ABCAAA"))
	    	.andDo(print())
	    	.andExpect(status().isOk());	    
	    
	}
	
	@Test
	public void validateStringLengthTest() throws Exception {		
		
	    mockMvc.perform(post(VERSION + "/validate").contentType(MediaType.APPLICATION_FORM_URLENCODED).param("password", "abc"))
	    	.andDo(print())
	    	.andExpect(status().isOk());	  
	    
	    mockMvc.perform(post(VERSION + "/validate").contentType(MediaType.APPLICATION_FORM_URLENCODED).param("password", "abcd5462tg"))
    	.andDo(print())
    	.andExpect(status().isOk());	  
	    
	}
	
	@Test
	public void validateStringDelimiterTest() throws Exception {		
		
	    mockMvc.perform(post(VERSION + "/validate").contentType(MediaType.APPLICATION_FORM_URLENCODED).param("password", "abc f434"))
	    	.andDo(print())
	    	.andExpect(status().isOk());	  
	    
	    mockMvc.perform(post(VERSION + "/validate").contentType(MediaType.APPLICATION_FORM_URLENCODED).param("password", "abc\nwe5we"))
    	.andDo(print())
    	.andExpect(status().isOk());	  
	    
	    
	}
	
	@Test
	public void validateString415Test() throws Exception {		
		
	    mockMvc.perform(post(VERSION + "/validate").contentType(MediaType.APPLICATION_FORM_URLENCODED).queryParam("pass", "abcer1231"))
	    	.andDo(print())
	    	.andExpect(status().isBadRequest());    	    
	    
	}
	
	
	
	

}
