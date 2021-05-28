package com.hjho.validator.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hjho.validator.model.ApiResult;
import com.hjho.validator.service.ValidateService;

@RequestMapping("/api/v1")
@Controller
public class ValidateController {

	@Autowired
	ValidateService validateService;
	
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ValidateController.class);
	
	
	/**
	 * POST Method, It expects encoded input in header "password"
	 * @param password
	 * @return Validation result  
	 */
	@PostMapping(path = "/validate", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	public ResponseEntity<ApiResult<String>>validateString(@RequestParam MultiValueMap<String,String> paramMap,
			HttpServletRequest request) {
		
		log.info("Validate Request from {}", request.getRemoteAddr());
		if(paramMap.get("password") == null) {
			log.warn("Validate Request from {}, missing required field", request.getRemoteAddr());
			return ResponseEntity.badRequest().build();
		}
		validateService.validate(paramMap.get("password").get(0));
		return ResponseEntity.ok(new ApiResult<>());
	}
}
