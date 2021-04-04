package com.smlie.controller;

import com.smlie.responcse.CommonResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.util.ErrorHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 404请求错误controller
 */
@RestController
public class RequestExceptionHandler implements ErrorController {
    @Override
    public String getErrorPath() {
        return "/error";
    }


    @RequestMapping("/error")
    public CommonResponse errorJsonPage(){
        return CommonResponse.createRrsponse(404,"url不存在");
    }
}
