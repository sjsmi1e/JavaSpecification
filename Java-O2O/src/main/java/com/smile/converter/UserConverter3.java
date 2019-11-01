package com.smile.converter;

import com.smile.UserDO;
import com.smile.UserVO;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * @author smi1e
 * Date 2019/11/1 14:42
 * Description
 */
@Log4j2
public class UserConverter3 {
    public static UserVO DO2VO(UserDO userDO) throws InvocationTargetException, IllegalAccessException {
        if (userDO == null) {
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userVO, userDO);
        return userVO;
    }

    public static UserDO VO2DO(UserVO userVO) throws InvocationTargetException, IllegalAccessException {
        if (userVO == null) {
            return null;
        }
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userDO, userVO);
        return userDO;
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
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
