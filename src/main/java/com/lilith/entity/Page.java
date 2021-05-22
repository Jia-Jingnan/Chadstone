package com.lilith.entity;

import lombok.Data;

import java.util.List;


/**
 * @Author:JiaJingnan
 * @Date: 下午11:06 2021/5/22
 */
@Data
public class Page {

    private String keyword;
    private List<Element> elements;
}

