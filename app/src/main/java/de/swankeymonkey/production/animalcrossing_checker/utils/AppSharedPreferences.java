package de.swankeymonkey.production.animalcrossing_checker.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class AppSharedPreferences {
    private static final String FILE_NAME = "SpAcCh";
    private static final String IS_DB_POPULATED = "isDbPopulatedSP";
    private static final String APP_MONTH = "appMonthSp";
    private static final String IS_ALWAYS_EXPANDED = "isAlwaysExpandedSP";
    private static final String APP_HEMISPHERE = "appHemisphereSP";
    private static final String FIRST_START = "firstStartSP";

    public static void setDbPopulated(Context context, boolean value) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putBoolean(IS_DB_POPULATED, value);
        editor.apply();
    }

    public static boolean isDbPopulated(Context context) {
        return getPreferences(context).getBoolean(IS_DB_POPULATED, false);
    }

    public static void setAppMonth(Context context, int monthCode) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putInt(APP_MONTH, monthCode);
        editor.apply();
    }

    public static int getAppMonth(Context context) {
        return getPreferences(context).getInt(APP_MONTH, Constants.NO_MONTH_CHOSEN);
    }

    public static void setIsAlwaysExpanded(Context context, boolean isAlwaysExpanded) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putBoolean(IS_ALWAYS_EXPANDED, isAlwaysExpanded);
        editor.apply();
    }

    public static boolean isAlwaysExpanded(Context context) {
        return getPreferences(context).getBoolean(IS_ALWAYS_EXPANDED, false);
    }

    public static void setAppHemisphere(Context context, int hemisphereMode) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putInt(APP_HEMISPHERE, hemisphereMode);
        editor.apply();
    }

    public static int getAppHemisphere(Context context) {
        return getPreferences(context).getInt(APP_HEMISPHERE, Constants.NO_HEMISPHERE_CHOSEN);
    }

    public static void setIsNotFirstTime(Context context) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putBoolean(FIRST_START, false);
        editor.apply();
    }

    public static boolean isFirstStart(Context context) {
        return getPreferences(context).getBoolean(FIRST_START, true);
    }

    private static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
    }
}
