package com.smile.jsonSerializable;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;

/**
 * @author smi1e
 * Date 2019/11/1 14:10
 * Description
 */
@Data
@Log4j2
public class User implements Serializable {
    private Integer id;
    private String name;
    private String passWord;

    public static void main(String[] args) {
        User user = new User();
        user.setId(1000);
        user.setName("user");
        user.setPassWord("123456");

        String objJsonStr = JSON.toJSONString(user);
        User jsonObject = JSON.parseObject(objJsonStr, User.class);

        log.info("{}", user.getId() == jsonObject.getId());
        log.info("{}", jsonObject.getId());
        log.info("{}", jsonObject.getName());
        log.info("{}", jsonObject.getPassWord());


    }
}
