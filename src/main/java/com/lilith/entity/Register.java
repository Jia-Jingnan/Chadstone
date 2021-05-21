package com.lilith.entity;

import lombok.Data;

/**
 * @Author:JiaJingnan
 * @Date: 下午1:00 2021/5/19
 * 注册数据实体类
 */
@Data
public class Register {

    private String isPostive;
    private String desc;
    private String username;
    private String password;
    private String passwordConfirm;
    private String expectedTips;
}
