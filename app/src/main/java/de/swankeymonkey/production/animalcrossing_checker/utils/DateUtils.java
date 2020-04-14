package de.swankeymonkey.production.animalcrossing_checker.utils;

import android.content.Context;

import org.joda.time.DateTime;

import java.util.ArrayList;

import de.swankeymonkey.production.animalcrossing_checker.R;

import static de.swankeymonkey.production.animalcrossing_checker.utils.Constants.*;

public class DateUtils {

    public static boolean isInDate(Context context, int currentMonth, ArrayList<String> monthList) {
        boolean isInDate = false;
        if (monthList.get(0).equals(ALL_DATE)) {
            isInDate = true;
        } else {
            if(AppSharedPreferences.getAppHemisphere(context) == Constants.NORTHERN_HEMISPHERE) {
                for (String month : monthList) {
                    if (isInDate) {
                        break;
                    }
                    switch (month) {
                        case JANUARY:
                            isInDate = currentMonth == 1;
                            break;
                        case FEBRUARY:
                            isInDate = currentMonth == 2;
                            break;
                        case MARCH:
                            isInDate = currentMonth == 3;
                            break;
                        case APRIL:
                            isInDate = currentMonth == 4;
                            break;
                        case MAY:
                            isInDate = currentMonth == 5;
                            break;
                        case JUNE:
                            isInDate = currentMonth == 6;
                            break;
                        case JULY:
                            isInDate = currentMonth == 7;
                            break;
                        case AUGUST:
                            isInDate = currentMonth == 8;
                            break;
                        case SEPTEMBER:
                            isInDate = currentMonth == 9;
                            break;
                        case OCTOBER:
                            isInDate = currentMonth == 10;
                            break;
                        case NOVEMBER:
                            isInDate = currentMonth == 11;
                            break;
                        case DECEMBER:
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
                        case JANUARY:
                            isInDate = currentMonth == 7;
                            break;
                        case FEBRUARY:
                            isInDate = currentMonth == 8;
                            break;
                        case MARCH:
                            isInDate = currentMonth == 9;
                            break;
                        case APRIL:
                            isInDate = currentMonth == 10;
                            break;
                        case MAY:
                            isInDate = currentMonth == 11;
                            break;
                        case JUNE:
                            isInDate = currentMonth == 12;
                            break;
                        case JULY:
                            isInDate = currentMonth == 1;
                            break;
                        case AUGUST:
                            isInDate = currentMonth == 2;
                            break;
                        case SEPTEMBER:
                            isInDate = currentMonth == 3;
                            break;
                        case OCTOBER:
                            isInDate = currentMonth == 4;
                            break;
                        case NOVEMBER:
                            isInDate = currentMonth == 5;
                            break;
                        case DECEMBER:
                            isInDate = currentMonth == 6;
                            break;
                    }
                }
            }

        }
        return isInDate;
    }
}
