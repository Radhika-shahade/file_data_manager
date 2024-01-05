package com.file.system.utils;

import com.file.system.bank.exception.InvalidDateException;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static Date convertToDate(String dateStr) throws Exception {

        System.out.println("Input: " + dateStr);
        if(StringUtils.isEmpty(dateStr) || StringUtils.containsIgnoreCase(dateStr, "nan")){
            throw new InvalidDateException("Date is invalid!");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        Date date = sdf.parse(dateStr);
        System.out.println(date);
        return date;
    }

//    public static void main(String[] args) throws Exception{
//        String d = "31/03/97 12:12:12"; // mm/dd/yy
//        convertToDate(d);
//    }
}
