package com.lilith.util;

import javax.servlet.http.Cookie;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author:JiaJingnan
 * @Date: 16:50 2020/4/13
 */
public class PropertiesUtil {

    public static Properties properties = new Properties();
    static {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File("src/main/resources/config.properties"));
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // 获取用例路径的通用方法
    public static String getCasePath(String caseName){
        return properties.getProperty(caseName);
    }

    // 获取页面url的通用方法
    public static String getPageUrl(String pageName){
        return properties.getProperty(pageName);
    }
    public static String getCookie(String cookie){
        return properties.getProperty(cookie);
    }

    public static String getReportName() {
        return properties.getProperty("reportName");
    }

    public static String getSheetName(){
        return properties.getProperty("sheet.name");
    }
}
