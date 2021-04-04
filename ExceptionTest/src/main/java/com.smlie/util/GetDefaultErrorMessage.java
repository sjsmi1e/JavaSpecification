package com.smlie.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取JSR303错误信息工具类
 */
public class GetDefaultErrorMessage {
    public static List<String> getDefaultErrorMessage(BindingResult bindingResult){
        List<ObjectError> errorList = bindingResult.getAllErrors();
        List<String> errorMes = new ArrayList<>();
        for (ObjectError o : errorList){
            errorMes.add(o.getDefaultMessage());
        }
        return errorMes;
    }
}
