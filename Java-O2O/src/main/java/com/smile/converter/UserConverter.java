package com.smile.converter;

import com.smile.UserDO;
import com.smile.UserVO;

/**
 * @author smi1e
 * Date 2019/11/1 14:32
 * Description getter/setter方法（推荐使用）
 */
public class UserConverter {
    public static UserVO DO2VO(UserDO userDO) {
        if (userDO == null) {
            return null;
        }
        UserVO userVO = new UserVO();
        userVO.setName(userDO.getName());
        return userVO;
    }

    public static UserDO VO2DO(UserVO userVO) {
        if (userVO == null) {
            return null;
        }
        UserDO userDO = new UserDO();
        userDO.setName(userVO.getName());
        return userDO;
    }
}
