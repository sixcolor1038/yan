package com.yan.demo.demo02;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WorkdayListGenerator {

    public static void main(String[] args) {
        String startDateString = "2024-01-24";
        String endDateString = "2024-02-28";

        LocalDate startDate = LocalDate.parse(startDateString);
        LocalDate endDate = LocalDate.parse(endDateString);

        List<LocalDate> workdays = getRestDay(startDate, endDate);

        System.out.println("周日列表：" + workdays);
    }

    private static List<LocalDate> getRestDay(LocalDate startDate, LocalDate endDate) {
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

    private static boolean isRestDay(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }

    //获取周六日期列表
    private static List<LocalDate> getSaturdays(LocalDate startDate, LocalDate endDate) {
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

    private static boolean isSaturday(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SATURDAY;
    }

    //获取周日日期列表
    private static List<LocalDate> getSundays(LocalDate startDate, LocalDate endDate) {
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

    private static boolean isSunday(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }

    //获取工作日日期列表
    private static List<LocalDate> getWorkdays(LocalDate startDate, LocalDate endDate) {
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

    private static boolean isWorkday(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY;
    }


}

