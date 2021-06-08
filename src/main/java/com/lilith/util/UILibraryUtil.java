package com.lilith.util;

import com.lilith.cases.BaseCase;
import com.lilith.entity.Ele;
import com.lilith.entity.Page;
import com.sun.xml.internal.rngom.parse.host.Base;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:JiaJingnan
 * @Date: 下午10:53 2021/5/22
 */
public class UILibraryUtil {

    // 保存Page对象的集合
    public static List<Page> pageList = new ArrayList<>();

    static{
        // 解析xml
        loadPages(PropertiesUtil.getProperty("uilibrary.path"));
    }

    // 解析UILibrary.xml
    private static void loadPages(String uiLibraryPath) {
        // 解析xml
        // 获取解析器
        SAXReader reader = new SAXReader();
        InputStream in = null;
        try {
            in = new FileInputStream(new File(uiLibraryPath));
            // 拿到Document对象
            Document document = reader.read(in);
            // 获取根元素
            Element rootElement = document.getRootElement();
            List<Element> pages = rootElement.elements("page");
            for (Element pageElement : pages) {
                String pageKeyword = pageElement.attributeValue("keyword");
                // 包含多个元素，获取page子节点的集合,dom4j的Element对象的集合
                List<Element> elements = pageElement.elements("ele");
                // 保存页面元素Ele对象的集合，自定义的页面元素的集合，用来封装Page对象
                List<Ele> eles = new ArrayList<>();
                for (Element element : elements) {
                    String eleKeyword = element.attributeValue("keyword");
                    String eleBy = element.attributeValue("by");
                    String eleValue = element.attributeValue("value");
                    // 封装Ele类
                    Ele ele = new Ele(eleKeyword,eleBy,eleValue);
                    eles.add(ele);
                }

                // 封装Page对象
                Page page = new Page(pageKeyword, eles);
                pageList.add(page);
            }
            // 遍历子元素 完成对象封装

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (in != null){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static WebElement getElementByKeyword(String pageKeyword, String eleKeyword){

        WebElement element = null;
        for (Page page : pageList){
            if (pageKeyword.equals(page.getKeyword())){
                List<Ele> eles = page.getEles();
                for (Ele ele : eles) {
                    // 比较ele标签的keyword是否与传入的eleKeyword一致，一致则为要找的元素，可以获的定位信息
                    if (eleKeyword.equals(ele.getKeyword())){
                        String by = ele.getBy();
                        String value = ele.getValue();
                        // 定位元素
                        element = getElementWithBy(by,value);
                    }
                }
            }
        }
        return element;
    }

    private static WebElement getElementWithBy(String by, String value) {

        WebDriver driver = BaseCase.driver;
        WebElement element = null;
        // 添加显示等待
        WebDriverWait wait = new WebDriverWait(driver,20);
        By locator = null;
        if ("id".equalsIgnoreCase(by)){
            locator = By.id(value);
        } else if ("name".equalsIgnoreCase(by)){
            locator = By.name(value);
        } else if ("className".equalsIgnoreCase(by)){
            locator = By.className(value);
        } else if ("tagName".equalsIgnoreCase(by)){
            locator = By.tagName(value);
        } else if ("linkText".equalsIgnoreCase(by)){
            locator = By.linkText(value);
        } else if ("partialLinkText".equalsIgnoreCase(by)){
            locator = By.partialLinkText(value);
        } else if ("cssSelector".equalsIgnoreCase(by)){
            locator = By.cssSelector(value);
        } else if ("xpath".equalsIgnoreCase(by)){
            locator = By.xpath(value);
        } else {
            System.out.println("暂不支持" + by + "类型定位元素");
        }

        try {
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            if(e instanceof TimeoutException){
                System.out.println("根据信息" + by + "和" + value + "定位元素超时");
            }
            e.printStackTrace();
        }

        return element;

    }
}
