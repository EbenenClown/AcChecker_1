package de.swankeymonkey.production.animalcrossing_checker.utils;

import org.joda.time.DateTime;

import java.util.ArrayList;

public class DateUtils {

    public static boolean isInDate(ArrayList<String> monthList) {
        boolean isInDate = false;
        int currentMonth = new DateTime().getMonthOfYear();
        if (monthList.get(0).equals("all")) {
            isInDate = true;
        } else {
            for (String month : monthList) {
                if (isInDate) {
                    break;
                }
                switch (month) {
                    case "January":
                        isInDate = currentMonth == 1;
                        break;
                    case "February":
                        isInDate = currentMonth == 2;
                        break;
                    case "March":
                        isInDate = currentMonth == 3;
                        break;
                    case "April":
                        isInDate = currentMonth == 4;
                        break;
                    case "May":
                        isInDate = currentMonth == 5;
                        break;
                    case "June":
                        isInDate = currentMonth == 6;
                        break;
                    case "July":
                        isInDate = currentMonth == 7;
                        break;
                    case "August":
                        isInDate = currentMonth == 8;
                        break;
                    case "September":
                        isInDate = currentMonth == 9;
                        break;
                    case "October":
                        isInDate = currentMonth == 10;
                        break;
                    case "November":
                        isInDate = currentMonth == 11;
                        break;
                    case "December":
                        isInDate = currentMonth == 12;
                        break;

                }
            }
        }
        return isInDate;
    }
}
