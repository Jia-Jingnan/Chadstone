package com.lilith.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * @Author:JiaJingnan
 * @Date: 上午2:55 2021/5/16
 */
public class ChromeCase {

    @Test
    public void test(){
        System.setProperty("webdriver.chrome.driver", "src/main/java/com/lilith/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://127.0.0.1/youtest/html/login.html");
        driver.findElement(By.name("username")).sendKeys("002@qq.com");
        driver.findElement(By.name("password")).sendKeys("123123");
        driver.findElement(By.id("login")).click();
    }
}
