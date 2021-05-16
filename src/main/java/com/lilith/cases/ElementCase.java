package com.lilith.cases;


import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @Author:JiaJingnan
 * @Date: 下午6:25 2021/5/16
 */
public class ElementCase extends BaseCase {

    @Test
    public void testElement() throws Exception{
        driver.navigate().to("http://localhost/youtest/html/register.html");
        driver.findElement(By.id("username")).sendKeys("002@qq.com");

        driver.navigate().to("http://localhost/youtest/html/login.html");
        driver.findElement(By.name("username")).sendKeys("002@qq.com");

        Thread.sleep(1000);

        driver.quit();
    }
}
