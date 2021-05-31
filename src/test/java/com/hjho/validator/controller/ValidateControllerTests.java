package com.hjho.validator.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.hjho.validator.constant.Status;


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
	    	.andExpect(status().isOk())
	    	.andExpect(content().contentType(MediaType.APPLICATION_JSON))
	    	.andExpect(jsonPath("$.status").value(Status.INVALID.getCode()));;	  
	    
	    mockMvc.perform(post(VERSION + "/validate").contentType(MediaType.APPLICATION_FORM_URLENCODED).param("password", ""))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
    	.andExpect(jsonPath("$.status").value(Status.INVALID.getCode()));
	    
	    mockMvc.perform(post(VERSION + "/validate").contentType(MediaType.APPLICATION_FORM_URLENCODED).param("password", "aatre123"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
    	.andExpect(jsonPath("$.status").value(Status.INVALID.getCode()));
	    
	}
	
	@Test
	public void validateStringCaseTest() throws Exception {		
		
	    mockMvc.perform(post(VERSION + "/validate").contentType(MediaType.APPLICATION_FORM_URLENCODED).param("password", "ABCAAA"))
	    	.andExpect(status().isOk())
	    	.andExpect(content().contentType(MediaType.APPLICATION_JSON))
	    	.andExpect(jsonPath("$.status").value(Status.INVALID.getCode()));
	    
	}
	
	@Test
	public void validateStringLengthTest() throws Exception {		
		
	    mockMvc.perform(post(VERSION + "/validate").contentType(MediaType.APPLICATION_FORM_URLENCODED).param("password", "abc"))
	    	.andExpect(status().isOk())
	    	.andExpect(content().contentType(MediaType.APPLICATION_JSON))
	    	.andExpect(jsonPath("$.status").value(Status.INVALID.getCode()));
	    		  
	    
	    mockMvc.perform(post(VERSION + "/validate").contentType(MediaType.APPLICATION_FORM_URLENCODED).param("password", "abcd5462tg"))
    		.andDo(print())
    		.andExpect(status().isOk())
    		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
	    	.andExpect(jsonPath("$.status").value(Status.SUCCESS.getCode()));
	    
	}
	
	@Test
	public void validateStringDelimiterTest() throws Exception {		
		
	    mockMvc.perform(post(VERSION + "/validate").contentType(MediaType.APPLICATION_FORM_URLENCODED).param("password", "abc f434"))
	    	.andExpect(status().isOk())
	    	.andExpect(content().contentType(MediaType.APPLICATION_JSON))
	    	.andExpect(jsonPath("$.status").value(Status.INVALID.getCode()));	  
	    
	    mockMvc.perform(post(VERSION + "/validate").contentType(MediaType.APPLICATION_FORM_URLENCODED).param("password", "abc\nwe5we"))
    		.andExpect(status().isOk())
    		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
	    	.andExpect(jsonPath("$.status").value(Status.INVALID.getCode()));;	  
	    
	    
	}
	
	@Test
	public void validateString415Test() throws Exception {		
		
	    mockMvc.perform(post(VERSION + "/validate").contentType(MediaType.APPLICATION_FORM_URLENCODED).queryParam("pass", "abcer1231"))
	    	.andDo(print())
	    	.andExpect(status().isBadRequest());    	    
	    
	}

}
