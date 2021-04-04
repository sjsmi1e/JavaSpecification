package com.smlie.pojo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data

public class UserPojo {
    private Integer id;
    @NotBlank(message="name不能为空")
    private String name;
    private Integer age;
}
