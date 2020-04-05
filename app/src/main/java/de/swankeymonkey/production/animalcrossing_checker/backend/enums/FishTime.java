package de.swankeymonkey.production.animalcrossing_checker.backend.enums;

import android.content.Context;

import de.swankeymonkey.production.animalcrossing_checker.R;

public enum FishTime {
    t4am_9pm(0),
    t9am_4pm(1),
    t9am_4pm_9pm_4am(2),
    t4pm_9am(3),
    t6pm_4am(4),
    t9pm_4am(5),
    ALL_DAY(6),
    UNKNOWN(7);

    private int id;

    FishTime(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static FishTime getFishTimes(int id) {
        switch(id) {
            case 0:
                return t4am_9pm;
            case 1:
                return t9am_4pm;
            case 2:
                return t9am_4pm_9pm_4am;
            case 3:
                return t4pm_9am;
            case 4:
                return t6pm_4am;
            case 5:
                return t9pm_4am;
            case 6:
                return ALL_DAY;
            default:
                return UNKNOWN;
        }
    }

    public static String getTimeString(FishTime times, Context context) {
        switch (times) {
            case t4am_9pm:
                return context.getString(R.string.t4am_9pm);
            case t9am_4pm:
                return context.getString(R.string.t9am_4pm);
            case t9am_4pm_9pm_4am:
                return context.getString(R.string.t9am_4pm_9pm_4am);
            case t4pm_9am:
                return context.getString(R.string.t4pm_9am);
            case t6pm_4am:
                return context.getString(R.string.t6pm_4am);
            case t9pm_4am:
                return context.getString(R.string.t9pm_4am);
            case ALL_DAY:
                return context.getString(R.string.All_Day);
            default:
                return context.getString(R.string.Unknown);
        }
    }


}
