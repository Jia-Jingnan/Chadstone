package com.lilith.cases;


import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @Author:JiaJingnan
 * @Date: 下午6:25 2021/5/16
 */
public class ElementLocatorCase extends BaseCase {

    @Test
    public void testElement() throws Exception{
        driver.navigate().to("http://localhost/youtest/html/register.html");
        driver.findElement(By.id("username")).sendKeys("002@qq.com");

        driver.navigate().to("http://localhost/youtest/html/login.html");
        driver.findElement(By.name("username")).sendKeys("002@qq.com");

        // 根据超文本连接定位元素
        driver.get("http://www.baidu.com");
        driver.findElement(By.linkText("新闻")).click();

        driver.findElement(By.partialLinkText("图")).click();

        // 通过样式选择器定位
        driver.findElement(By.cssSelector("#username")).sendKeys("002@qq.com");


        Thread.sleep(1000);

        driver.quit();
    }
}
