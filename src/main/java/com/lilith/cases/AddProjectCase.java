package com.lilith.cases;

import com.lilith.asserts.LilithAss;
import com.lilith.util.AddProjectUtil;
import com.lilith.util.LoginUtil;
import com.lilith.util.PropertiesUtil;
import com.lilith.util.UILibraryUtil;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @Author:JiaJingnan
 * @Date: 上午2:07 2021/5/24
 */
@Slf4j
public class AddProjectCase extends BaseCase {

    @BeforeTest
    public void beforeTest(){
        // 访问登陆页面
        to(PropertiesUtil.getProperty("login.url"));
        // 用户名
        sendKeys("登陆页面","用户名","002@qq.com");
        // 密码
        sendKeys("登陆页面","密码","123123");
        // 立即登陆
        click("登陆页面","登陆");
    }

    @Test(dataProvider = "negativeDatas")
    public void testNegative(String projectName, String projectAdd, String projectDesc, String expectedTips) throws Exception{

        // 访问页面
        to(PropertiesUtil.getProperty("add_project.url"));
        setCookie(PropertiesUtil.getProperty("cookie.name"),PropertiesUtil.getProperty("cookie.value"));
        refresh();
        // 点击添加项目按钮
        click("项目列表页面","添加项目按钮");
        // 输入项目名称
        JavascriptExecutor js = (JavascriptExecutor) driver;

        Thread.sleep(1000);

        String nameScript = "document.getElementsByName(\"name\")[1].value=\"" + projectName + "\"";
        js.executeScript(nameScript);
        // 输入项目地址
        Thread.sleep(1000);
        String addScript = "document.getElementsByName(\"host\")[1].value=\"" + projectAdd + "\"";
        js.executeScript(addScript);
        // 输入项目描述
        Thread.sleep(1000);
        String descScript = "document.getElementsByName(\"description\")[2].value=\"" + projectDesc + "\"";
        Object o = js.executeScript(descScript);
        // 点击确认按钮
        Thread.sleep(1000);
        click("项目列表页面","确认按钮");
        
        // tips断言
        
        
        WebElement tipElement = UILibraryUtil.getElementByKeyword("项目列表页面","错误提示");

        LilithAss.assertTextPresent(tipElement,expectedTips);
    }

    @Test(dataProvider = "positiveDatas")
    public void testPositive(String projectName, String projectAdd, String projectDesc) throws Exception{

        // 访问页面
        to(PropertiesUtil.getProperty("add_project.url"));

        // 点击添加项目按钮
        click("项目列表页面","添加项目按钮");
        // 输入项目名称
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String nameScript = "document.getElementsByName(\"name\")[1].value=\"" + projectName + "\"";
        js.executeScript(nameScript);
        // 输入项目地址
        Thread.sleep(1000);
        String addScript = "document.getElementsByName(\"host\")[1].value=\"" + projectAdd + "\"";
        js.executeScript(addScript);
        // 输入项目描述
        Thread.sleep(1000);
        String descScript = "document.getElementsByName(\"description\")[2].value=\"" + projectDesc + "\"";
        js.executeScript(descScript);
        // 点击确认按钮
        Thread.sleep(1000);
        click("项目列表页面","确认按钮");
    }

    @DataProvider
    public Object[][]  negativeDatas(){
        String[] cellNames = {"ProjectName", "ProjectAdd", "ProjectDesc","ExceptedTips"};
        Object[][] datas = AddProjectUtil.getDatas("0",cellNames);
        return datas;
    }

    @DataProvider
    public Object[][]  positiveDatas(){
        String[] cellNames = {"ProjectName", "ProjectAdd", "ProjectDesc"};
        Object[][] datas = AddProjectUtil.getDatas("1", cellNames);
        return datas;
    }
}
