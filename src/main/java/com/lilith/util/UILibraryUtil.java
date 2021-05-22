package com.lilith.util;

import com.lilith.entity.Page;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:JiaJingnan
 * @Date: 下午10:53 2021/5/22
 */
public class UILibraryUtil {

    public static List<Page> pageList = new ArrayList<>();

    static{
        // 解析xml
        loadPages(PropertiesUtil.properties.getProperty("uilibrary.path"));
    }

    // 解析UILibrary.xml
    private static void loadPages(String s) {
    }

    public static WebElement getElementByKeyword(String pageKeyword, String uiElementkeyword){

        return null;
    }
}
