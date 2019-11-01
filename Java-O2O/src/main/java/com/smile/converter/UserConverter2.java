package com.smile.converter;

import com.smile.UserDO;
import com.smile.UserVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;

/**
 * @author smi1e
 * Date 2019/11/1 14:37
 * Description springframework BeanUtils copyProperties
 */
@Log4j2
public class UserConverter2 {
    public static UserVO DO2VO(UserDO userDO) {
        if (userDO == null) {
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userDO, userVO);
        return userVO;
    }

    public static UserDO VO2DO(UserVO userVO) {
        if (userVO == null) {
            return null;
        }
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userVO, userDO);
        return userDO;
    }

    public static void main(String[] args) {
        UserDO userDO = new UserDO();
        userDO.setId(1000);
        userDO.setName("user");
        userDO.setPassWord("123456");
        UserVO userVO = DO2VO(userDO);
        log.info(userVO);
        UserDO userDO1 = VO2DO(userVO);
        log.info(userDO1);
    }
}
