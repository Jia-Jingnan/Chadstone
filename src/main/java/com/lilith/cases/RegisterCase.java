package com.lilith.cases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * @Author:JiaJingnan
 * @Date: 上午10:57 2021/5/19
 */
public class RegisterCase extends BaseCase{

    @Test
    public void testRegister(){

        driver.get("http://localhost/youtest/html/register.html");
        // .....

        // 验证码
        // 从cookie中提取验证码
        String verifyCode = driver.manage().getCookieNamed("verifycode").getValue();
        driver.findElement(By.id("verifycode")).sendKeys(verifyCode);

    }
}
