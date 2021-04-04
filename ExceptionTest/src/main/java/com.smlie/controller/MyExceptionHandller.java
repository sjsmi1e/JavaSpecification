package com.smlie.controller;

import com.smlie.error.ErrorType;
import com.smlie.error.UserException;
import com.smlie.responcse.CommonResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class MyExceptionHandller {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CommonResponse exceptionHandller(Exception e){
//        Map<String,Object> map = new HashMap<>();
//        map.put("respCode", "9999");
//        map.put("respMsg", e.getMessage());
        //正常开发中，可创建一个统一响应实体，如CommonResp

        return CommonResponse.createRrsponse(9999,e.getMessage());
    }
    @ExceptionHandler(UserException.class)
    @ResponseBody
    public CommonResponse pageErrorHandller(Exception e){
        return CommonResponse.createRrsponse(ErrorType.USER_ERROR_NOTEXIT.getErrCode(),e.getMessage());
    }

}
