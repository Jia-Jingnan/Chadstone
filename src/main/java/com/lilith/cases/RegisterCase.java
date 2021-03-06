package com.lilith.cases;

import com.lilith.asserts.LilithAss;
import com.lilith.util.PropertiesUtil;
import com.lilith.util.RegisterUtil;
import com.lilith.util.UILibraryUtil;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @Author:JiaJingnan
 * @Date: 上午11:48 2021/5/19
 * 注册页面测试用例
 */
@Slf4j
public class RegisterCase extends BaseCase {

    @Test(dataProvider = "negativeDatas", description = "注册反向用例")
    public void testNegative(String username, String password, String pwdconfirm, String expectedTips, String desc){
        log.info("测试用例描述：" + desc);
        // 访问注册页面
        // driver.get(PropertiesUtil.getPageUrl("register.url"));
        to(PropertiesUtil.getProperty("register.url"));
        // 用户名
        // UILibraryUtil.getElementByKeyword("注册页面","用户名").sendKeys(username);
        sendKeys("注册页面","用户名",username);
        // 密码
        // UILibraryUtil.getElementByKeyword("注册页面","密码").sendKeys(password);
        sendKeys("注册页面","密码",password);
        // 确认密码
        // UILibraryUtil.getElementByKeyword("注册页面","重复密码").sendKeys(pwdconfirm);
        sendKeys("注册页面","重复密码",pwdconfirm);
        // 立即注册按钮
        // UILibraryUtil.getElementByKeyword("注册页面","注册").click();
        click("注册页面","注册");

        // tips
        WebElement tipElement = UILibraryUtil.getElementByKeyword("注册页面","错误提示");

        LilithAss.assertTextPresent(tipElement,expectedTips);
    }

    @Test(dataProvider = "positiveDatas", description = "${desc}")
    public void testPositive(String username, String password, String pwdconfirm, String desc) throws Exception{
        log.info("测试用例描述：" + desc);
        // 访问注册页面
        to(PropertiesUtil.getProperty("register.url"));
        // 用户名
        sendKeys("注册页面","用户名",username);
        // 密码
        sendKeys("注册页面","密码",password);
        // 确认密码
        sendKeys("注册页面","重复密码",pwdconfirm);
        // 立即注册按钮
        click("注册页面","注册");

        // 点击注册会跳出alert弹出框显示注册成功，而不是直接跳转到登陆页面，要先点击确定

        // 获取地址，是否跳转到登陆页面
        // Thread.sleep(3000); 使用显示等待跳转到login.html
        String urlContains = "login.html";
        LilithAss.assertUrlContains(urlContains);
    }


    @DataProvider
    public Object[][]  negativeDatas(){
        String[] cellNames = {"Username", "Password", "PasswordConfirm", "ExpectedTips", "Desc"};
        Object[][] datas = RegisterUtil.getDatas("0",cellNames);
        return datas;
    }

    @DataProvider
    public Object[][]  positiveDatas(){
        String[] cellNames = {"Username", "Password", "PasswordConfirm", "Desc"};
        Object[][] datas = RegisterUtil.getDatas("1", cellNames);
        return datas;
    }

}
