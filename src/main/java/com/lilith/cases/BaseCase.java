package com.lilith.cases;

import com.lilith.listener.LilithListenerScreen;
import com.lilith.util.UILibraryUtil;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * @Author:JiaJingnan
 * @Date: 下午5:24 2021/5/16
 */
@Listeners(LilithListenerScreen.class)
@Slf4j
public class BaseCase {

    public static WebDriver driver;

    @Parameters(value = {"browser"})
    @BeforeSuite
    public void init(String browser) throws Exception{

        // System.out.println("浏览器：" + browser);
        log.info("浏览器：" + browser);
        if ("firefox".equalsIgnoreCase(browser)){
            System.setProperty("webdriver.gecko.driver", "src/main/java/com/lilith/driver/geckodriver");
            driver = new FirefoxDriver();
        } else if ("chrome".equalsIgnoreCase(browser)){
            System.setProperty("webdriver.chrome.driver", "src/main/java/com/lilith/driver/chromedriver");
            driver = new ChromeDriver();
        } else {
            // System.out.println("暂不支持该浏览器类型");
            log.error("暂不支持该浏览器类型");
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
        log.info("进入" + url);
        driver.get(url);
    }

    /**
     *
     * @param pageKeyword 元素定位信息
     * @param eleKeyword 元素定位信息
     * @param content 要输入的内容
     */
    public void sendKeys(String pageKeyword, String eleKeyword, String content){
        log.info("在" + pageKeyword + "页面的" + eleKeyword + "输入" + content);
        UILibraryUtil.getElementByKeyword(pageKeyword,eleKeyword).sendKeys(content);
    }

    /**
     * 点击元素
     * @param pageKeyword 元素定位信息
     * @param eleKeyword 元素定位信息
     */
    public void click(String pageKeyword, String eleKeyword){
        log.info("点击" + pageKeyword + "页面的" + eleKeyword);
        UILibraryUtil.getElementByKeyword(pageKeyword,eleKeyword).click();
    }

    /**
     * 刷新页面操作
     */
    public void refresh(){
        driver.navigate().refresh();
    }

    /**
     * 给页面设置cookie
     * @param cookieName
     * @param cookieValue
     */
    public void setCookie(String cookieName, String cookieValue){
        Cookie cookie = new Cookie(cookieName, cookieValue);
        driver.manage().addCookie(cookie);
    }


}
