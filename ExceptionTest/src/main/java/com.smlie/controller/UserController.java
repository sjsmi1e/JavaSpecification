package com.smlie.controller;

import com.smlie.error.ErrorType;
import com.smlie.error.UserException;
import com.smlie.pojo.UserPojo;
import com.smlie.responcse.CommonResponse;
import com.smlie.util.GetDefaultErrorMessage;
import com.smlie.util.HttpRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserController {

    //private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UserController.class);


    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public CommonResponse getUser(){
        Map<String,Object> map = new HashMap<>();
        UserPojo userPojo = new UserPojo();
        userPojo.setId(1);
        userPojo.setAge(21);
        map.put("user",userPojo);
        log.info("正在新增一条用户信息");
        //int a = 1/0;
        log.info("新增成功");
        return CommonResponse.createRrsponse(200,map);
    }


    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public CommonResponse get(@Valid UserPojo userPojo, BindingResult bindingResult) throws UserException {
        if (bindingResult.hasErrors()){
            //List<ObjectError> errorList = bindingResult.getAllErrors();
            //map.put("data",errorList);
            List<String> errorMes = GetDefaultErrorMessage.getDefaultErrorMessage(bindingResult);
            return CommonResponse.createRrsponse(ErrorType.USER_ERROR_MESSAGE.getErrCode(),errorMes);
        }else {
            //Map<String,Object> map = new HashMap<>();
            //map.put("data",userPojo);
            if (userPojo.getName().equals("aaaa")){
                //ErrorType.USER_ERROR_NOTEXIT.setErrMsg("noexit");
                throw new UserException(ErrorType.USER_ERROR_NOTEXIT);
            }
            return CommonResponse.createRrsponse(200,userPojo);
        }
    }

    @RequestMapping("/getInfo")
    public void getInfo(String code){
        log.info("code:"+code);
        String s= HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", "appid=wx7d4470f4608cf56f&secret=5c7b23e4e1078a1f38f5494b003c06cb&js_code="+code+"&grant_type=authorization_code");
        log.info(s);
    }

}
