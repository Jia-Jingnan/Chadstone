package com.lilith.cases;

import com.lilith.util.UILibraryUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

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
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDown() throws Exception{
        Thread.sleep(5000);
        // 关闭驱动实例以及所有有自动化打开的实例窗口
        driver.quit();
    }

    // 以下为行为的封装

    /**
     * 访问页面
     * @param url
     */
    public void to (String url){
        driver.get(url);
    }

    /**
     *
     * @param pageKeyword 元素定位信息
     * @param eleKeyword 元素定位信息
     * @param content 要输入的内容
     */
    public void sendKeys(String pageKeyword, String eleKeyword, String content){
        UILibraryUtil.getElementByKeyword(pageKeyword,eleKeyword).sendKeys(content);
    }

    /**
     * 点击元素
     * @param pageKeyword 元素定位信息
     * @param eleKeyword 元素定位信息
     */
    public void click(String pageKeyword, String eleKeyword){
        UILibraryUtil.getElementByKeyword(pageKeyword,eleKeyword).click();
    }
}
