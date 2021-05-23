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

    /**
     * 判断url是否包含字符
     * @param urlContains
     */
    public static void assertUrlContains(String urlContains){

        boolean isContainUrl = true;
        try {
            wait.until(ExpectedConditions.urlContains(urlContains));
        } catch (Exception e){
            isContainUrl = false;
        }
        Assert.assertTrue(isContainUrl);
    }

    /**
     * 断言元素的文本值是否包含传入的文本值
     * @param element
     * @param text
     */
    public static void assertTextPresent(WebElement element, String text){
        boolean textToBePresentElement = true;
        try {
            textToBePresentElement = wait.until(ExpectedConditions.textToBePresentInElement(element, text));
        } catch (Exception e){
            textToBePresentElement = false;
        }
        Assert.assertTrue(textToBePresentElement);
    }

    /**
     * 断言元素是否可点击
     * @param element
     */
    public static void assertClickable(WebElement element){
        boolean elementClickable = true;
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e){
            elementClickable = false;
        }
        Assert.assertTrue(elementClickable);

    }


}
