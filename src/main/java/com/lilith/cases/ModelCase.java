package com.lilith.cases;

import org.junit.Test;
import org.openqa.selenium.By;

/**
 * @Author:JiaJingnan
 * @Date: 下午10:43 2021/5/17
 * 模态框
 */
public class ModelCase extends BaseCase {

    @Test
    public void testModel() throws Exception{

        driver.get("file:///Users/jingnan/code/01-Github/webauto/src/main/resources/demo.html");
        driver.findElement(By.id("alert"));
        Thread.sleep(3000);
        // 模拟点击确定
        driver.switchTo().alert().accept();
        // 模拟点击取消
        driver.switchTo().alert().dismiss();

    }
}
