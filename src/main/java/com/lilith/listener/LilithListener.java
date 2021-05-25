package com.lilith.listener;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author:JiaJingnan
 * @Date: 上午1:51 2021/3/10
 */
public class LilithListener {

    public long currentTime = System.currentTimeMillis();
    public SimpleDateFormat formatter = new SimpleDateFormat ("yyyy年MM月dd日-HH时mm分ss秒");
    public Date date = new Date(currentTime);
    public String reportdate = formatter.format(date);
}
