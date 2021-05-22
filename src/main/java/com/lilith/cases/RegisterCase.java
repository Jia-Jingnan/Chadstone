package com.lilith.cases;

import com.lilith.util.RegisterUtil;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @Author:JiaJingnan
 * @Date: 上午11:48 2021/5/19
 * 注册页面测试用例
 */
public class RegisterCase extends BaseCase {

    @Test(dataProvider = "negativeDatas")
    public void testNegative(String username, String password, String pwdconfirm, String expectedTips){
        // 访问注册页面
        driver.get("http://localhost/youtest/html/register.html");
        // 用户名
        driver.findElement(By.id("username")).sendKeys(username);
        // 密码
        driver.findElement(By.id("password")).sendKeys(password);
        // 确认密码
        driver.findElement(By.id("pwdconfirm")).sendKeys(pwdconfirm);
        // 立即注册按钮
        driver.findElement(By.className("submit_btn")).click();

        // tips
        String actualTips = driver.findElement(By.className("tips")).getText();
        Assert.assertEquals(actualTips,expectedTips);
    }

    @Test(dataProvider = "positiveDatas")
    public void testPositive(String username, String password, String pwdconfirm){
        // 访问注册页面
        driver.get("http://localhost/youtest/html/register.html");
        // 用户名
        driver.findElement(By.id("username")).sendKeys(username);
        // 密码
        driver.findElement(By.id("password")).sendKeys(password);
        // 确认密码
        driver.findElement(By.id("pwdconfirm")).sendKeys(pwdconfirm);
        // 立即注册按钮
        driver.findElement(By.className("submit_btn")).click();

        // 获取地址，是否跳转到登陆页面
        String currentUrl = driver.getCurrentUrl();
        boolean contains = currentUrl.contains("login.html");
        Assert.assertTrue(contains);
    }


    @DataProvider
    public Object[][]  negativeDatas(){
        String[] cellNames = {"Username", "Password", "PasswordConfirm", "ExpectedTips"};
        Object[][] datas = RegisterUtil.getDatas("0",cellNames);
        return datas;
    }

    @DataProvider
    public Object[][]  positiveDatas(){
        String[] cellNames = {"Username", "Password", "PasswordConfirm"};
        Object[][] datas = RegisterUtil.getDatas("1", cellNames);
        return datas;
    }

}
