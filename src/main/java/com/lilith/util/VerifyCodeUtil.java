package com.lilith.util;

import com.lilith.cases.BaseCase;

/**
 * @Author:JiaJingnan
 * @Date: 下午12:21 2021/5/21
 * 从cookie中提取验证码
 */
public class VerifyCodeUtil {

    public static final String COOKIE_NAME = "verifycode";
    public static String getVerifyCode(){
        return BaseCase.driver.manage().getCookieNamed(COOKIE_NAME).getValue();
    }
}
