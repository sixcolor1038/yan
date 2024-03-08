package com.yan.demo.infra.utils;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: sixcolor
 * @Date: 2024-03-07 16:43
 * @Description:
 */
public class DateUtil {


    public static String getDateTimeStr(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date currentDate = new Date();
        return sdf.format(currentDate);
    }

    //获取当前时间并转为时间戳
    public static long getCurrentTimestampMillis() {
        return Instant.now().toEpochMilli();
    }

    //获取周六 日期列表
    public static List<LocalDate> getSaturdays(LocalDate startDate, LocalDate endDate) {
        List<LocalDate> saturdays = new ArrayList<>();
        LocalDate currentDate = startDate;
        while (!currentDate.isAfter(endDate)) {
            if (isSaturday(currentDate)) {
                saturdays.add(currentDate);
            }
            currentDate = currentDate.plusDays(1);
        }
        return saturdays;
    }

    //判断当前日期是否为周六
    public static boolean isSaturday(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SATURDAY;
    }

    //获取周日 日期列表
    public static List<LocalDate> getSundays(LocalDate startDate, LocalDate endDate) {
        List<LocalDate> sundays = new ArrayList<>();
        LocalDate currentDate = startDate;
        while (!currentDate.isAfter(endDate)) {
            if (isSunday(currentDate)) {
                sundays.add(currentDate);
            }
            currentDate = currentDate.plusDays(1);
        }
        return sundays;
    }

    //判断当前日期是否为周日
    public static boolean isSunday(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }

    //获取工作日 日期列表
    public static List<LocalDate> getWorkdays(LocalDate startDate, LocalDate endDate) {
        List<LocalDate> workdays = new ArrayList<>();
        LocalDate currentDate = startDate;
        while (!currentDate.isAfter(endDate)) {
            if (isWorkday(currentDate)) {
                workdays.add(currentDate);
            }
            currentDate = currentDate.plusDays(1);
        }
        return workdays;
    }

    //判断当前日期是否为工作日
    public static boolean isWorkday(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY;
    }

    //获取休息日(周六、周日) 日期列表
    public static List<LocalDate> getRestDay(LocalDate startDate, LocalDate endDate) {
        List<LocalDate> restDays = new ArrayList<>();
        LocalDate currentDate = startDate;
        while (!currentDate.isAfter(endDate)) {
            if (isRestDay(currentDate)) {
                restDays.add(currentDate);
            }
            currentDate = currentDate.plusDays(1);
        }
        return restDays;
    }

    //判断当前日期是否为(周六、周日)
    public static boolean isRestDay(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }
}
