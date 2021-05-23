package com.lilith.cases;

import com.lilith.asserts.LilithAss;
import com.lilith.util.LoginUtil;
import com.lilith.util.RegisterUtil;
import com.lilith.util.UILibraryUtil;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @Author:JiaJingnan
 * @Date: 上午2:07 2021/5/24
 */
public class LoginCase extends BaseCase {

    @Test(dataProvider = "negativeDatas")
    public void testNegative(String username, String password, String expectedTips){

        // 访问登陆页面
        driver.get("http://localhost/youtest/html/login.html");
        // 用户名
        UILibraryUtil.getElementByKeyword("登陆页面","用户名").sendKeys(username);
        // 密码
        UILibraryUtil.getElementByKeyword("登陆页面","密码").sendKeys(password);
        // 立即登陆
        UILibraryUtil.getElementByKeyword("登陆页面","登陆").click();

        // tips
        WebElement tipElement = UILibraryUtil.getElementByKeyword("登陆页面","错误提示");

        LilithAss.assertTextPresent(tipElement,expectedTips);
    }

    @Test(dataProvider = "positiveDatas")
    public void testPositive(String username, String password){

        // 访问登陆页面
        driver.get("http://localhost/youtest/html/login.html");
        // 用户名
        UILibraryUtil.getElementByKeyword("登陆页面","用户名").sendKeys(username);
        // 密码
        UILibraryUtil.getElementByKeyword("登陆页面","密码").sendKeys(password);
        // 立即登陆
        UILibraryUtil.getElementByKeyword("登陆页面","登陆").click();

        String urlContains = "project.html";
        LilithAss.assertUrlContains(urlContains);
    }

    @DataProvider
    public Object[][]  negativeDatas(){
        String[] cellNames = {"Username", "Password", "ExpectedTips"};
        Object[][] datas = LoginUtil.getDatas("0",cellNames);
        return datas;
    }

    @DataProvider
    public Object[][]  positiveDatas(){
        String[] cellNames = {"Username", "Password"};
        Object[][] datas = LoginUtil.getDatas("1", cellNames);
        return datas;
    }
}
