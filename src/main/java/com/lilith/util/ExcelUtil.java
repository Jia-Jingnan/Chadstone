package com.lilith.util;

import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:JiaJingnan
 * @Date: 上午1:09 2021/5/8
 * 使用poi解析Excel的工具类
 */
public class ExcelUtil {

    /**
     * 获取指定Excel表中指定sheetName中的数据，封装为对象
     * @param excelPath
     * @param sheetName
     * 缺点：只能取出case对象数据，其他对象无法取出，应使用泛型
     */
    // 解决耦合问题,返回一个类型集合
    // 返回集合中的类型取决于 传入的类型
    public static <T> List<T> load(String excelPath, String sheetName, Class<T> class1) {
        List<T> list = new ArrayList<T>();
        try {
            // 创建workBook对象
            Workbook workbook = WorkbookFactory.create((new File(excelPath)));
            // 获取sheet对象
            Sheet sheet = workbook.getSheet(sheetName);
            // 获取第一行
            Row titleRow = sheet.getRow(0);
            //获取最后一列的列号
            int lastCellNum = titleRow.getLastCellNum();
            String[] fields = new String[lastCellNum];
            // 循环处理每一列,取出每一列里面的字段名，保存到数组
            for (int i = 0; i <= lastCellNum - 1; i++) {
                // 根据列索引获取对应的列
                Cell cell = titleRow.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                // 设置列的类型为字符串
                cell.setCellType(CellType.STRING);
                String title = cell.getStringCellValue(); // 带有中文的标题
                title = title.substring(0, title.indexOf("("));// 去除中文
                fields[i] = title; // 存入数组
//                String methodName = "set" + title; //构造Case类的属性
//                Method method = clazz.getMethod(methodName, String.class);
//                method.invoke()
            }
            int lastRowIndex = sheet.getLastRowNum();
            // 循环处理每一个数据行,每一行数据都是一个对象
            for (int i = 1; i <= lastRowIndex; i++) {
                // 创建一个对象
                T obj = class1.newInstance();
                //拿到一个数据行
                Row dataRow = sheet.getRow(i);
                if (dataRow == null || isEmptyRow(dataRow)) {
                    continue;
                }
                // 拿到此数据行上面的每一列, 将数据封装到cs对象中
                for (int j = 0; j < lastCellNum; j++) {
                    Cell cell = dataRow.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    cell.setCellType(CellType.STRING);
                    String value = cell.getStringCellValue();
                    // 获取要反射的方法名
                    String methodName = "set" + fields[j]; //构造Case类的属性
                    // 获取要反射的方法对象
                    Method method = class1.getMethod(methodName, String.class);
                    // 完成反射调用
                    method.invoke(obj, value);
                }
                // 往list集合中添加
                list.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    private static boolean isEmptyRow(Row dataRow) {
        short lastCellNum = dataRow.getLastCellNum();
        for (int i = 0; i < lastCellNum; i++){
            Cell cell = dataRow.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            cell.setCellType(CellType.STRING);
            String value = cell.getStringCellValue();
            if (value != null && value.trim().length() > 0){

                return false;
            }

        }
        return true;
    }
}
