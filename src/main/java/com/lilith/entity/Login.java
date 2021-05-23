package com.lilith.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:JiaJingnan
 * @Date: 上午2:09 2021/5/24
 * login.xlsx数据源封装的实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Login {

    private String isPostive;
    private String desc;
    private String username;
    private String password;
    private String expectedTips;
}
