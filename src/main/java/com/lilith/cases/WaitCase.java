package com.lilith.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * @Author:JiaJingnan
 * @Date: 上午2:33 2021/5/19
 * 显示等待
 */
public class WaitCase extends BaseCase {

    @Test
    public void test(){

        WebDriverWait webDriverWait = new WebDriverWait(driver,30,500);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("name")));

    }
}
