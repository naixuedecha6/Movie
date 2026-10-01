package com.zrkworld.cinema.utils;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author zrk
 * @version 1.0
 * @date 2020/5/1 0001 11:45
 */
public class DateManageSystem {

    public String[] getLastWeek()  {
        Calendar cal = Calendar.getInstance();
        String[] week = new String[7];
        //n为推迟的周数，1本周，-1向前推迟一周，2下周，依次类推
        int n = -1;
        cal.add(Calendar.DATE, n * 7);
        //想周几，这里就传几Calendar.MONDAY（TUESDAY...）
        for (int i = 0; i < 7; i++) {
            cal.set(Calendar.DAY_OF_WEEK, 2 + i);
            //时分秒毫秒域清零
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            week[i] = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime());
        }
        return week;
    }

}
