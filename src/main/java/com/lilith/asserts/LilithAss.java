package com.lilith.asserts;

import com.lilith.cases.BaseCase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * @Author:JiaJingnan
 * @Date: 下午11:49 2021/5/23
 * 支持多种场景的断言工具
 */
public class LilithAss {

    public static void assertUrlContains(String urlContains){

        WebDriverWait wait = new WebDriverWait(BaseCase.driver,30);
        boolean isContainPage = true;
        try {
            wait.until(ExpectedConditions.urlContains(urlContains));
        } catch (Exception e){
            isContainPage = false;
        }
        Assert.assertTrue(isContainPage);
    }


}
