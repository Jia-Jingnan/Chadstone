package com.lilith.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * @Author:JiaJingnan
 * @Date: 下午11:06 2021/5/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page {

    private String keyword;
    private List<Ele> eles;
}

