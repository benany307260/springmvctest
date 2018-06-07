package com.testcomp.testweb;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice  
@ResponseBody  
public class ExceptionAdvice {  
  
	/** 
     * 400 - Bad Request 
     */  
    @ResponseStatus(HttpStatus.BAD_REQUEST)  
    @ExceptionHandler(MethodArgumentNotValidException.class)  
    public ResponseBean handleValidationException(MethodArgumentNotValidException e) {  
        //logger.error("参数验证失败", e);  
        return new ResponseBean().failure("validation_exception");  
    }
    
    /** 
     * 400 - Bad Request 
     */  
    @ResponseStatus(HttpStatus.BAD_REQUEST)  
    @ExceptionHandler(HttpMessageNotReadableException.class)  
    public ResponseBean handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {  
        //logger.error("参数解析失败", e);  
    	e.printStackTrace();
        return new ResponseBean().failure("could_not_read_json");  
    }
  
    /** 
     * 405 - Method Not Allowed 
     */  
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)  
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)  
    public ResponseBean handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {  
        //logger.error("不支持当前请求方法", e);  
        return new ResponseBean().failure("request_method_not_supported");  
    }  
  
    /** 
     * 415 - Unsupported Media Type 
     */  
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)  
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)  
    public ResponseBean handleHttpMediaTypeNotSupportedException(Exception e) {  
        //logger.error("不支持当前媒体类型", e);  
        return new ResponseBean().failure("content_type_not_supported");  
    }  
  
    /** 
     * 500 - Internal Server Error 
     */  
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)  
    @ExceptionHandler(Exception.class)  
    public ResponseBean handleException(Exception e) {  
        //logger.error("服务运行异常", e);  
        return new ResponseBean().failure(e.getMessage());  
    }  
}