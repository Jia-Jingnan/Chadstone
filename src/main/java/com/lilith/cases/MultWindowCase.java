package com.lilith.cases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.awt.dnd.DragSourceDragEvent;
import java.util.Set;

/**
 * @Author:JiaJingnan
 * @Date: 上午10:22 2021/5/18
 */
public class MultWindowCase extends BaseCase {

    @Test
    public void test() throws Exception{
        driver.navigate().to("file:///Users/jingnan/code/01-Github/webauto/src/main/resources/demo.html");

        //获取窗口句柄
        // 获取的始终都是第一个窗口的句柄,没有做切换操作
        String currentWinHandle = driver.getWindowHandle();

        // System.out.println(currentWinHandle);
        Thread.sleep(3000);


        driver.findElement(By.linkText("Open new window")).click();

        // 获取所有的窗口句柄
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            System.out.println(windowHandle);
            // 如果窗口句柄是现在的，跳过
            if (windowHandle.equals(currentWinHandle)){
                continue;
            }
            // 切换window
            driver.switchTo().window(windowHandle);
        }

        String windowHandle = driver.getWindowHandle();
        // 输出页面标题
        System.out.println(driver.getTitle());
        // 输出url地址
        System.out.println(driver.getCurrentUrl());

        // 回到原页面

    }
}
