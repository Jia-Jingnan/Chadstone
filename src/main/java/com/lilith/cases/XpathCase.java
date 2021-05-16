package com.lilith.cases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * @Author:JiaJingnan
 * @Date: 上午12:29 2021/5/17
 */
public class XpathCase extends BaseCase{

    @Test
    public void test(){

        driver.get("http://localhost/youtest/html/login.html");
        // 绝对路径定位
        driver.findElement(By.xpath("/html/body/form/dl/dd[1]/input")).sendKeys("002@qq.com");

        // 相对路径
        // driver.findElement(By.xpath("//body/form[1]/dl[1]/dd[2]/input[1]")).sendKeys("123123");
        //driver.findElement(By.xpath("//input[@placeholder='密码']")).sendKeys("123123");
        //driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123123");
        driver.findElement(By.xpath("//input[contains(@placeholder,'密')]")).sendKeys("123123");

    }
}
