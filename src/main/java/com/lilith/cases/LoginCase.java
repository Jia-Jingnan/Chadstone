package com.lilith.cases;

import com.lilith.asserts.LilithAss;
import com.lilith.util.LoginUtil;
import com.lilith.util.PropertiesUtil;
import com.lilith.util.UILibraryUtil;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @Author:JiaJingnan
 * @Date: 上午2:07 2021/5/24
 */
@Slf4j
public class LoginCase extends BaseCase {

    @Test(dataProvider = "negativeDatas")
    public void testNegative(String username, String password, String expectedTips, String desc){

        // 访问登陆页面
        to(PropertiesUtil.getPageUrl("login.url"));
        // 用户名
        sendKeys("登陆页面","用户名",username);
        // 密码
        sendKeys("登陆页面","密码",password);
        // 立即登陆
        click("登陆页面","登陆");

        // tips
        WebElement tipElement = UILibraryUtil.getElementByKeyword("登陆页面","错误提示");

        LilithAss.assertTextPresent(tipElement,expectedTips);
    }

    @Test(dataProvider = "positiveDatas")
    public void testPositive(String username, String password){

        // 访问登陆页面
        to(PropertiesUtil.getPageUrl("login.url"));
        // 用户名
        sendKeys("登陆页面","用户名", username);
        // 密码
        sendKeys("登陆页面","密码", password);
        // 立即登陆
        click("登陆页面","登陆");

        String urlContains = "project.html";
        LilithAss.assertUrlContains(urlContains);
    }

    @DataProvider
    public Object[][]  negativeDatas(){
        String[] cellNames = {"Username", "Password", "ExpectedTips","Desc"};
        Object[][] datas = LoginUtil.getDatas("0",cellNames);
        return datas;
    }

    @DataProvider
    public Object[][]  positiveDatas(){
        String[] cellNames = {"Username", "Password", "Desc"};
        Object[][] datas = LoginUtil.getDatas("1", cellNames);
        return datas;
    }
}
