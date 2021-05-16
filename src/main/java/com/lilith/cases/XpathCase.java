package com.lilith.cases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * @Author:JiaJingnan
 * @Date: 上午12:29 2021/5/17
 */
public class XpathCase extends BaseCase{

    @Test
    public void test(){

        driver.get("http://localhost/youtest/html/login.html");
        // 绝对路径定位
        driver.findElement(By.xpath("/html/body/form/dl/dd[1]/input")).sendKeys("002@qq.com");

    }
}
