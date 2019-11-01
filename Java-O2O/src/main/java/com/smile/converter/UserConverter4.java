package com.smile.converter;

import com.smile.UserDO;
import com.smile.UserVO;
import lombok.extern.log4j.Log4j2;
import net.sf.cglib.beans.BeanCopier;
import org.junit.Assert;
import org.junit.Test;


import java.lang.reflect.InvocationTargetException;

/**
 * @author smi1e
 * Date 2019/11/1 14:51
 * Description
 */
@Log4j2
public class UserConverter4 {

    private static BeanCopier do2voCopier = BeanCopier.create(UserDO.class, UserVO.class, false);
    private static BeanCopier vo2doCopier = BeanCopier.create(UserDO.class, UserVO.class, false);

    public static UserVO DO2VO(UserDO userDO) throws InvocationTargetException, IllegalAccessException {
        if (userDO == null) {
            return null;
        }
        UserVO userVO = new UserVO();
        do2voCopier.copy(userDO, userVO, null);
        return userVO;
    }

    public static UserDO VO2DO(UserVO userVO) throws InvocationTargetException, IllegalAccessException {
        if (userVO == null) {
            return null;
        }
        UserDO userDO = new UserDO();
        vo2doCopier.copy(userVO, userDO, null);
        return userDO;
    }

    @Test
    public void test() throws InvocationTargetException, IllegalAccessException {
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
