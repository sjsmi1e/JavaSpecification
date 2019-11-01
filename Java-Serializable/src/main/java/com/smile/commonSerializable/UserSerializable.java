package com.smile.commonSerializable;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;

import java.io.*;

/**
 * @author smi1e
 * Date 2019/11/1 11:54
 * Description
 */
@Data
@Log4j2
public class UserSerializable implements Serializable, Cloneable {
    private Integer id;
    private String name;
    private String passWord;

    private void writeObj(UserSerializable user) throws IOException {
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\JavaSpecification\\Java-Serializable\\src\\main\\java\\Serialize\\user");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(user);
        oos.close();
        fos.close();
    }

    private UserSerializable readObj() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Desktop\\JavaSpecification\\Java-Serializable\\src\\main\\java\\Serialize\\user");
        ObjectInputStream ois = new ObjectInputStream(fis);
        UserSerializable o = (UserSerializable) ois.readObject();
        fis.close();
        ois.close();
        return o;
    }

    public UserSerializable deepClone() {
        UserSerializable user = null;
        try {
            writeObj(this);
            user = readObj();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        UserSerializable user = new UserSerializable();
        user.setId(10000);
        user.setName("zhangSan");
        user.setPassWord("123456");
        log.printf(Level.INFO, user.getId() + ":" + user.getId().hashCode());
        log.printf(Level.INFO, "{}:{}", user.getName(), user.getName().hashCode());
        log.printf(Level.INFO, "{}:{}", user.getPassWord(), user.getPassWord().hashCode());
        log.printf(Level.INFO, "-----------开始序列化------------");
        UserSerializable cloneUser = user.deepClone();
        log.printf(Level.INFO, "-------克隆后---------");
        log.printf(Level.INFO, cloneUser.getId() + ":" + cloneUser.getId().hashCode());
        log.printf(Level.INFO, "{}:{}", cloneUser.getName(), cloneUser.getName().hashCode());
        log.printf(Level.INFO, "{}:{}", cloneUser.getPassWord(), cloneUser.getPassWord().hashCode());
        log.printf(Level.INFO, "-----------地址对比---------");
        log.printf(Level.INFO, "{}", cloneUser.getId() == user.getId());
        //以为字符串会直接缓存在方法区中，所以是true
        log.printf(Level.INFO, "{}", cloneUser.getName() == cloneUser.getName());
        log.printf(Level.INFO, "{}", cloneUser.getPassWord() == cloneUser.getPassWord());
    }
}
