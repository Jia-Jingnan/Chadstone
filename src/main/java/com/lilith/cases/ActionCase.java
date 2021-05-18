package com.lilith.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.SortedMap;

/**
 * @Author:JiaJingnan
 * @Date: 下午11:18 2021/5/18
 */
public class ActionCase extends BaseCase {

    @Test
    public void test(){

        driver.get("");
        WebElement source = driver.findElement(By.id(""));
        WebElement target = driver.findElement(By.id(""));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source,target).build().perform();
    }
}
