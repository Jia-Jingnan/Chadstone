package com.lilith.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @Author:JiaJingnan
 * @Date: 下午5:24 2021/5/16
 */
public class BaseCase {

    public static WebDriver driver;

    @Parameters(value = {"browser"})
    @BeforeSuite
    public void init(String browser) throws Exception{

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
    }
}
