package de.swankeymonkey.production.animalcrossing_checker.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;

public class AppSharedPreferences {
    private static final String FILE_NAME = "SpAcCh";
    private static final String IS_FISH_POPULATED = "isFishPopulatedSP";

    public static void setFishDbPopulated(Context context, boolean value) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putBoolean(IS_FISH_POPULATED, value);
        editor.apply();
    }

    public static boolean isFishDbPopulated(Context context) {
        return getPreferences(context).getBoolean(IS_FISH_POPULATED, false);
    }


    private static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
    }
}
