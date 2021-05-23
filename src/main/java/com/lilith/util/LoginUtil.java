package com.lilith.util;



import com.lilith.entity.Login;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:JiaJingnan
 * @Date: 下午12:58 2021/5/19
 */
public class LoginUtil {

    // 保存所有注册用例的list列表
    public static List<Login> loginList = new ArrayList<>();

    // 将所有用例保存到loginList列表中
    static {
        List<Login> list = ExcelUtil.load(PropertiesUtil.getLoginExcelPath(), "用例", Login.class);
        loginList.addAll(list);
        /*for (Login register : list) {
            System.out.println(register);
        }*/
    }

    // 获取所有用例的数据，通过flag为0或1，确定是反向或正向用例从loginList列表中筛选
    public static Object[][] getDatas(String flag, String[] cellNames) {
        //
        List<Login> satisfied = new ArrayList<>();
        for (Login register : loginList) {
            if (flag.equals(register.getIsPostive())){
                //System.out.println(register);
                satisfied.add(register);
            }
        }
        // 保存反向用例的数组
        Object[][] datas = new Object[satisfied.size()][cellNames.length];

        Class<Login> clazz = Login.class;

        // 遍历对象，从satisfied对象中取出要的数据存入datas中
        for (int i = 0; i < satisfied.size(); i++){
            Login reg = satisfied.get(i);
            if (!flag.equals(reg.getIsPostive())){
                continue;
            }

            // 循环出要取的列号
            for (int j = 0; j < cellNames.length; j++){
                try {
                    // 使用反射
                    String methodName = "get" + cellNames[j];
                    // 获取到反射的方法对象
                    Method method = clazz.getMethod(methodName);
                    // System.out.println(methodName);
                    String value = (String) method.invoke(reg);
                    datas[i][j] = value;
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return datas;

    }

    public static void main(String[] args) {
        String[] cellNames = {"Username", "Password", "PasswordConfirm", "ExpectedTips"};
        Object[][] negativeDatas = getDatas("1",cellNames);
        for (Object[] negativeData : negativeDatas){
            for (Object neg : negativeData){
                System.out.print("{" + neg + "}");
            }
            System.out.println();
        }
    }
}
