package com.lilith.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 * @Author:JiaJingnan
 * @Date: 上午9:42 2021/5/18
 */
public class IFrameCase extends BaseCase{

    @Test
    public void test(){
        driver.get("https://mail.163.com/");
        WebElement iframe = driver.findElement(By.xpath("//div/iframe"));
        System.out.println(iframe.getTagName());
        driver.switchTo().frame(iframe);
        driver.findElement(By.name("email")).sendKeys("Knowit123@163.com");

        // 还可以通过索引定位iframe，name或id

        // 回到iframe上一级页面
        driver.switchTo().parentFrame();


    }
}
