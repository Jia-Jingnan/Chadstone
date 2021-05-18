package com.lilith.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @Author:JiaJingnan
 * @Date: 上午11:22 2021/5/18
 */
public class SelectCase extends BaseCase {

    @Test
    public void test(){
        driver.navigate().to("file:///Users/jingnan/code/01-Github/webauto/src/main/resources/demo.html");

        WebElement selectEle = driver.findElement(By.tagName("select"));
        Select select = new Select(selectEle);
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            String tagName = option.getTagName();
            String text = option.getText();
            System.out.println(tagName + "," + text);
            select.selectByIndex(2);
//            if ("Audi".equals(text)){
//                select.selectByVisibleText(text);
//            }
        }
    }
}
