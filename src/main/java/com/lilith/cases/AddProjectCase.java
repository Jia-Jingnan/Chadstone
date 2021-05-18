package com.lilith.cases;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * @Author:JiaJingnan
 * @Date: 下午11:56 2021/5/18
 */
public class AddProjectCase extends BaseCase {

    @Test
    public void test() throws Exception{
        // 打开登陆页
        driver.get("http://localhost/youtest/html/login.html");

        // 登陆
        driver.findElement(By.name("username")).sendKeys("002@qq.com");
        driver.findElement(By.name("password")).sendKeys("123123");
        driver.findElement(By.id("login")).click();

        Thread.sleep(2000);
        // 添加项目
        driver.findElement(By.className("btn-addinter2")).click();

        Thread.sleep(3000);


        // 填写项目信息，执行js脚本赋值
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // 输入项目信息
        js.executeScript("document.getElementsByName(\"name\")[1].value=\"自动化测试\"");
        js.executeScript("document.getElementsByName(\"host\")[1].value=\"localhost:8848\"");
        js.executeScript("document.getElementsByName(\"description\")[2].value=\"自动化测试项目\"");

        // 点击确定
        driver.findElement(By.className("alert-btn-p2")).click();
    }
}
