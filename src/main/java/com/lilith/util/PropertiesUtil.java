package com.lilith.util;

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

    public static String getExcelPath(){
        return properties.getProperty("excel.path");
    }

    public static String getToken(){
        return properties.getProperty("token");
    }

    public static String getReportName() {
        return properties.getProperty("reportName");
    }

    public static String getSheetName(){
        return properties.getProperty("sheet.name");
    }
}
