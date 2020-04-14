package de.swankeymonkey.production.animalcrossing_checker.utils;

import android.content.Context;

import org.joda.time.DateTime;

import java.util.ArrayList;

import de.swankeymonkey.production.animalcrossing_checker.R;

public class DateUtils {

    public static boolean isInDate(Context context, int currentMonth, ArrayList<String> monthList) {
        boolean isInDate = false;
        if (monthList.get(0).equals("all")) {
            isInDate = true;
        } else {
            if(AppSharedPreferences.getAppHemisphere(context) == Constants.NORTHERN_HEMISPHERE) {
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
            } else {
                for (String month : monthList) {
                    if (isInDate) {
                        break;
                    }
                    switch (month) {
                        case "January":
                            isInDate = currentMonth == 7;
                            break;
                        case "February":
                            isInDate = currentMonth == 8;
                            break;
                        case "March":
                            isInDate = currentMonth == 9;
                            break;
                        case "April":
                            isInDate = currentMonth == 10;
                            break;
                        case "May":
                            isInDate = currentMonth == 11;
                            break;
                        case "June":
                            isInDate = currentMonth == 12;
                            break;
                        case "July":
                            isInDate = currentMonth == 1;
                            break;
                        case "August":
                            isInDate = currentMonth == 2;
                            break;
                        case "September":
                            isInDate = currentMonth == 3;
                            break;
                        case "October":
                            isInDate = currentMonth == 4;
                            break;
                        case "November":
                            isInDate = currentMonth == 5;
                            break;
                        case "December":
                            isInDate = currentMonth == 6;
                            break;
                    }
                }
            }

        }
        return isInDate;
    }
}
