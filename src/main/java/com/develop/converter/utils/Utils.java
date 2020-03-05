package com.develop.converter.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    private static String DATE_PATTERN = "dd.MM.yyyy";

    public static Date convertStringToDate(String sDate) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN);
        return simpleDateFormat.parse(sDate);
    }

    public static String convertDateToString(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN);
        return simpleDateFormat.format(date);
    }
}
