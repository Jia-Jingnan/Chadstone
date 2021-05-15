package com.lilith.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @Author:JiaJingnan
 * @Date: 上午2:40 2021/5/16
 */
public class FirefoxCase {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "src/main/java/com/lilith/driver/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://127.0.0.1/youtest/html/login.html");
        driver.findElement(By.name("username")).sendKeys("002@qq.com");
        driver.findElement(By.name("password")).sendKeys("123123");
        driver.findElement(By.id("login")).click();
    }
}
