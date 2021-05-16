package com.lilith.cases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * @Author:JiaJingnan
 * @Date: 上午12:59 2021/5/17
 * 元素操作类
 */
public class ElementOperateCase extends BaseCase{

    @Test
    public void test(){

        driver.get("http://localhost/youtest/html/login.html");
        // 获取tagname
        String tagName = driver.findElement(By.xpath("//input[@name='password']")).getTagName();
        System.out.println(tagName);
        // 判断元素是否可见
        boolean isDisplayed = driver.findElement(By.name("username")).isDisplayed();
        System.out.println(isDisplayed);
        // 判断元素是否可编辑
        boolean isEnabled = driver.findElement(By.name("password")).isEnabled();
        System.out.println(isEnabled);
        // 是否被选中
        
    }
}
