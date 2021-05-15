package com.lilith.cases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @Author:JiaJingnan
 * @Date: 上午2:58 2021/5/16
 */
public class MultiBrowserCase {

    @Parameters(value = {"browser"})
    @Test
    public void test(String browser){
        System.out.println("浏览器：" + browser);
    }
}
