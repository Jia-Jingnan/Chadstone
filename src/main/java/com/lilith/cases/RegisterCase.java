package com.lilith.cases;

import com.lilith.util.RegisterUtil;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @Author:JiaJingnan
 * @Date: 上午11:48 2021/5/19
 * 注册页面测试用例
 */
public class RegisterCase extends BaseCase {

    @Test(dataProvider = "datas")
    public void test(String username, String password, String pwdconfirm, String exceptedtips){
        // 访问注册页面
        driver.get("http://localhost/youtest/html/register.html");
        // 用户名
        driver.findElement(By.id("username")).sendKeys();
        // 密码
        driver.findElement(By.id("password")).sendKeys();
        // 确认密码
        driver.findElement(By.id("pwdconfirm")).sendKeys();
        // 立即注册按钮
        driver.findElement(By.className("submit_btn")).click();

        // tips
        driver.findElement(By.className("tips")).getText();
    }


    @DataProvider
    public Object[][] datas(){
        String[] cellNames = {"Username", "Password", "PasswordConfirm", "ExpectedTips"};
        Object[][] datas = RegisterUtil.getNegativeDatas(cellNames);
        return datas;
    }
}
