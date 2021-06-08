package com.lilith.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import java.io.*;
import java.util.Properties;

/**
 * @Author:JiaJingnan
 * @Date: 16:50 2020/4/13
 */
@Slf4j
public class PropertiesUtil {

    private static Properties props;

    static {
        String fileName = "config.properties";
        props = new Properties();
        try {
            props.load(new InputStreamReader(PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName),"UTF-8"));
        } catch (IOException e) {
            log.error("配置文件读取异常",e);
        }
    }


    public static String getProperty(String key){
        String value = props.getProperty(key.trim());
        if(StringUtils.isBlank(value)){
            return null;
        }
        return value.trim();
    }

    public static String getProperty(String key,String defaultValue){

        String value = props.getProperty(key.trim());
        if(StringUtils.isBlank(value)){
            value = defaultValue;
        }
        return value.trim();
    }


    public static void main(String[] args) {
        String sheetName = getProperty("sheet.name");
        System.out.println(sheetName);
    }
}
