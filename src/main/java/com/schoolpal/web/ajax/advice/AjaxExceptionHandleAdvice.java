package com.schoolpal.web.ajax.advice;

import com.schoolpal.web.ajax.exception.AjaxException;
import com.schoolpal.web.ajax.model.AjaxResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice(basePackages = {"com.schoolpal.web.ajax.controller"})
public class AjaxExceptionHandleAdvice {
//    public class AjaxControllerResponseBodyAdvice implements ResponseBodyAdvice {

    private Logger logger = LoggerFactory.getLogger(getClass());

/*
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }
*/

/*
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        logger.debug("###MyResponseBodyAdvice - beforeBodyWrite()");
        return o;
    }
*/

/*
    @ModelAttribute
    public User newUser() {
        System.out.println("============应用到所有@RequestMapping注解方法，在其执行之前把返回值放入Model");
        return new User();
    }
*/

/*    @InitBinder
    public void initBinder(WebDataBinder binder) {
        System.out.println("============应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器");
    }*/

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object handleException(Exception e){
        logger.debug("###MyControllerAdvice - handleException()");
        AjaxResponse response = new AjaxResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
        return response;
    }

    //For wrongly submitting form data to a @RequestBody controller
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e){
        logger.debug("###MyControllerAdvice - handleHttpMediaTypeNotSupportedException()");
        AjaxResponse response = new AjaxResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return response;
    }

    @ExceptionHandler(AjaxException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object handleAjaxException(AjaxException e){
        logger.debug("###MyControllerAdvice - handleException()");
        AjaxResponse response = new AjaxResponse(e.getCode(), e.getMessage());
        return response;
    }

    //For
    // 1. Wrongly submitting serialized (json/xml) data
    // 2. Submitting invalid form data
    // to a non-@RequestBody controller
    @ExceptionHandler(BindException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object handleBindException(BindException e){
        logger.debug("###MyControllerAdvice - handleBindException()");
        AjaxResponse response = new AjaxResponse(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), e.getBindingResult().getAllErrors());
        return response;
    }

    //For submitting invalid (json/xml) data to a controller
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        logger.debug("###MyControllerAdvice - handleMethodArgumentNotValidException()");
        AjaxResponse response = new AjaxResponse(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), e.getBindingResult().getAllErrors());
        return response;
    }

}
