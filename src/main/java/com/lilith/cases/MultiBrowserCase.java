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

        // 操作浏览器窗口
        // WebDriver.Window window = driver.manage().window();
        // 设置窗口位置
        // window.setPosition(new Point(100,200));
        // 设置窗口大小
        // window.setSize(new Dimension(600,600));
        // window.maximize();
        // 输出窗口大小
        // System.out.println(window.getSize().height + "," +  window.getSize().width);

        driver.get("http://127.0.0.1/youtest/html/login.html");
        // 导航栏相关操作
        driver.get("http://www.baidu.com");
        Thread.sleep(1000);
        // 后退
        driver.navigate().back();
        Thread.sleep(1000);
        // 前进
        driver.navigate().forward();
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);
        driver.navigate().refresh();
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
