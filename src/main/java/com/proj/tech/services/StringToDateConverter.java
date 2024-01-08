package com.proj.tech.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Utility class for converting a string representation of a date to a {@code Date} object.
 * This class provides a method to convert a string with the format "yyyy-MM-dd" to a {@code Date} object
 * with the time set to midnight.
 */
public class StringToDateConverter {

    /**
     * Converts a string representation of a date to a {@code Date} object with the time set to midnight.
     *
     * @param dateString The string representation of the date in the format "yyyy-MM-dd".
     * @return The {@code Date} object with the time set to midnight, or {@code null} if the conversion fails.
     */
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
