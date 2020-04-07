package de.swankeymonkey.production.animalcrossing_checker.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class AppSharedPreferences {
    private static final String FILE_NAME = "SpAcCh";
    private static final String IS_DB_POPULATED = "isDbPopulatedSP";

    public static void setDbPopulated(Context context, boolean value) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putBoolean(IS_DB_POPULATED, value);
        editor.apply();
    }

    public static boolean isDbPopulated(Context context) {
        return getPreferences(context).getBoolean(IS_DB_POPULATED, false);
    }

    private static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
    }
}
