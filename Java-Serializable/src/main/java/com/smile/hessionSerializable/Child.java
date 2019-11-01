package com.smile.hessionSerializable;

import lombok.Data;

import java.io.Serializable;

/**
 * @author smi1e
 * Date 2019/11/1 13:42
 * Description
 */
@Data
public class Child extends Parent implements Serializable {
    private Integer id;
}
