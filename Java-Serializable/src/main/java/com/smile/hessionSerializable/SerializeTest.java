package com.smile.hessionSerializable;

import lombok.extern.log4j.Log4j2;

import java.io.IOException;

/**
 * @author smi1e
 * Date 2019/11/1 13:43
 * Description
 */
@Log4j2
public class SerializeTest {
    public static void main(String[] args) throws IOException {
        Child child = new Child();
        child.setId(1000);
        child.setName("child");
        String path = "C:\\Users\\Administrator\\Desktop\\JavaSpecification\\Java-Serializable\\src\\main\\java\\Serialize\\hessian";
        HessianSerializeUtil.writeObj(child, path);
        Child o = (Child) HessianSerializeUtil.readObj(path);
        //hessian先序列子类，再序列父类，所以产生问题，出现null
        log.info("{}", o.getId());
        log.info("{}", o.getName());
    }
}
