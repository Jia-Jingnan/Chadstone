package com.lilith.util;



import com.lilith.entity.Login;

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
        List<Login> list = ExcelUtil.load(PropertiesUtil.getProperty("login.excel.path"), "用例", Login.class);
        loginList.addAll(list);
        /*for (Login register : list) {
            System.out.println(register);
        }*/
    }

    // 获取所有用例的数据，通过flag为0或1，确定是反向或正向用例从loginList列表中筛选
    public static Object[][] getDatas(String flag, String[] cellNames) {
        //
        List<Object> satisfied = new ArrayList<>();
        for (Login login : loginList) {
            if (flag.equals(login.getIsPostive())){
                //System.out.println(register);
                satisfied.add(login);
            }
        }
        Object[][] datas = BaseUtil.assembleDatas(cellNames, satisfied, Login.class);
        return datas;
    }

    public static void main(String[] args) {
        String[] cellNames = {"Username", "Password", "ExpectedTips"};
        Object[][] negativeDatas = getDatas("1",cellNames);
        for (Object[] negativeData : negativeDatas){
            for (Object neg : negativeData){
                System.out.print("{" + neg + "}");
            }
            System.out.println();
        }
    }
}
