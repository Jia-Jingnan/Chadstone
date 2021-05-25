package com.lilith.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:JiaJingnan
 * @Date: 上午1:01 2021/5/26
 * 添加项目Excel对应的实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProject {

    private String isPositive;
    private String desc;
    private String projectName;
    private String projectAdd;
    private String projectDesc;
    private String expectedTips;
}
