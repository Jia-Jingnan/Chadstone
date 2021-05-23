package com.lilith.asserts;

import com.lilith.cases.BaseCase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * @Author:JiaJingnan
 * @Date: 下午11:49 2021/5/23
 * 支持多种场景的断言工具
 */
public class LilithAss {

    public static WebDriverWait wait = new WebDriverWait(BaseCase.driver,30);

    public static void assertUrlContains(String urlContains){

        boolean isContainUrl = true;
        try {
            wait.until(ExpectedConditions.urlContains(urlContains));
        } catch (Exception e){
            isContainUrl = false;
        }
        Assert.assertTrue(isContainUrl);
    }

    public static void assertTextPresent(WebElement element, String text){
        boolean textToBePresentElement = true;
        try {
            textToBePresentElement = wait.until(ExpectedConditions.textToBePresentInElement(element, text));
        } catch (Exception e){
            textToBePresentElement = false;
        }
        Assert.assertTrue(textToBePresentElement);


    }


}
