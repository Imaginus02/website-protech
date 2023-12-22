package com.proj.tech.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class StringToDateConverter {

    public Date convertStringToDate(String dateString) {
        try {
            // Parse the input string
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(dateString);

            // Set the time to midnight
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);

            // Return the Date object with time set to midnight
            return calendar.getTime();
        } catch (ParseException e) {
            e.printStackTrace(); // Handle the exception according to your needs
            return null;
        }
    }
}
