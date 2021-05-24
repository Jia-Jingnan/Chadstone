package com.lilith.util;


import java.lang.reflect.Method;
import java.util.List;

/**
 * @Author:JiaJingnan
 * @Date: 上午10:53 2021/5/24
 */
public class BaseUtil {

    public static Object[][] assembleDatas(String[] cellNames, List<Object> satisfied, Class clazz) {

        // 保存反向用例的数组
        Object[][] datas = new Object[satisfied.size()][cellNames.length];

        // 遍历对象，从satisfied对象中取出要的数据存入datas中
        for (int i = 0; i < satisfied.size(); i++) {
            Object obj = satisfied.get(i);

            // 循环出要取的列号
            for (int j = 0; j < cellNames.length; j++) {
                try {
                    // 使用反射
                    String methodName = "get" + cellNames[j];
                    // 获取到反射的方法对象
                    Method method = clazz.getMethod(methodName);
                    // System.out.println(methodName);
                    String value = (String) method.invoke(obj);
                    datas[i][j] = value;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return datas;
    }
}
