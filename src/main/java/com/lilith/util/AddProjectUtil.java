package com.lilith.util;



import com.lilith.entity.AddProject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:JiaJingnan
 * @Date: 下午12:58 2021/5/19
 */
public class AddProjectUtil {

    // 保存所有注册用例的list列表
    public static List<AddProject> addProjectList = new ArrayList<>();

    // 将所有用例保存到addProjectList列表中
    static {
        List<AddProject> list = ExcelUtil.load(PropertiesUtil.getCasePath("add_project.excel.path"), "用例", AddProject.class);
        addProjectList.addAll(list);
        /*for (AddProject register : list) {
            System.out.println(register);
        }*/
    }

    // 获取所有用例的数据，通过flag为0或1，确定是反向或正向用例从addProjectList列表中筛选
    public static Object[][] getDatas(String flag, String[] cellNames) {
        //
        List<Object> satisfied = new ArrayList<>();
        for (AddProject login : addProjectList) {
            if (flag.equals(login.getIsPositive())){
                //System.out.println(register);
                satisfied.add(login);
            }
        }
        Object[][] datas = BaseUtil.assembleDatas(cellNames, satisfied, AddProject.class);
        return datas;
    }

    public static void main(String[] args) {
        String[] cellNames = {"ProjectName", "ProjectAdd", "ProjectDesc"};
        Object[][] negativeDatas = getDatas("0",cellNames);
        for (Object[] negativeData : negativeDatas){
            for (Object neg : negativeData){
                System.out.print("{" + neg + "}");
            }
            System.out.println();
        }
    }

}
