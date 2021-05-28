package com.hjho.validator.bean;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.hjho.validator.constant.Status;
import com.hjho.validator.model.ApiResult;

@RestControllerAdvice
public class ControllerExceptionHandler implements ResponseBodyAdvice<Object> {

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ControllerExceptionHandler.class);
	
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResult<String> unknownException(Exception e) {
        log.error("ControllerExceptionHandler|UnknownException|{}|{}", e.getClass(), e.getMessage());
        return ApiResult.fromStatus(Status.FAIL);
    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return returnType.getContainingClass() == ApiResult.class;
    }

    @Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		log.trace("ControllerExceptionHandler|BeforeBodyWrite|{}", body);
        
		return body;
	}

}