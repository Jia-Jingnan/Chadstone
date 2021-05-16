package com.lilith.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @Author:JiaJingnan
 * @Date: 上午2:58 2021/5/16
 */
public class MultiBrowserCase {

    @Parameters(value = {"browser"})
    @Test
    public void test(String browser) throws Exception{

        WebDriver driver = null;

        System.out.println("浏览器：" + browser);
        if ("firefox".equalsIgnoreCase(browser)){
            System.setProperty("webdriver.gecko.driver", "src/main/java/com/lilith/driver/geckodriver");
            driver = new FirefoxDriver();
        } else if ("chrome".equalsIgnoreCase(browser)){
            System.setProperty("webdriver.chrome.driver", "src/main/java/com/lilith/driver/chromedriver");
            driver = new ChromeDriver();
        } else {
            System.out.println("暂不支持该浏览器类型");
            return;
        }


        driver.findElement(By.name("username")).sendKeys("002@qq.com");
        driver.findElement(By.name("password")).sendKeys("123123");
        driver.findElement(By.id("login")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 关闭浏览器
        driver.quit();
    }
}
