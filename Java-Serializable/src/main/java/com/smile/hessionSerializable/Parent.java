package com.smile.hessionSerializable;

import lombok.Data;

import java.io.Serializable;

/**
 * @author smi1e
 * Date 2019/11/1 13:41
 * Description
 */
@Data
public class Parent implements Serializable {
    private Integer id;
    private String name;
}
