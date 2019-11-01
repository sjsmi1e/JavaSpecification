package com.smile.hessionSerializable;

import com.caucho.hessian.io.Hessian2Output;
import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author smi1e
 * Date 2019/11/1 13:45
 * Description
 */
public class HessianSerializeUtil {
    public static <T> void writeObj(T obj, String path) throws IOException {
        FileOutputStream fos = new FileOutputStream(path);
        HessianOutput hessianOutput = new HessianOutput(fos);
        hessianOutput.writeObject(obj);
        hessianOutput.close();
    }

    public static <T> T readObj(String path) throws IOException {
        FileInputStream fis = new FileInputStream(path);
        HessianInput hessianInput = new HessianInput(fis);
        Object o = hessianInput.readObject();
        hessianInput.close();
        return (T) o;
    }
}
