package de.swankeymonkey.production.animalcrossing_checker.backend.enums;

import android.content.Context;

import de.swankeymonkey.production.animalcrossing_checker.R;

public enum InsectTime {
    t4am_8am_4pm_7pm(0),
    t4am_8am_5pm_7pm(1),
    t4am_5pm(2),
    t4am_7pm(3),
    t7am_4pm(4),
    t8am_4pm(5),
    t8am_5pm(6),
    t8am_7pm(7),
    t4pm_11pm(8),
    t5pm_4am(9),
    t5pm_8am(10),
    t7pm_4am(11),
    t7pm_8am(12),
    t11pm_8am(13),
    t11pm_4pm(14),
    UNKNOWN(15);

    private int id;

    InsectTime(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static InsectTime getTime(int id) {
        switch(id) {
            case 0:
                return t4am_8am_4pm_7pm;
            case 1:
                   return t4am_8am_5pm_7pm;
            case 2:
                   return t4am_5pm;
            case 3:
                   return t4am_7pm;
            case 4:
                   return t7am_4pm;
            case 5:
                   return t8am_4pm;
            case 6:
                   return t8am_5pm;
            case 7:
                   return t8am_7pm;
            case 8:
                   return t4pm_11pm;
            case 9:
                   return t5pm_4am;
            case 10:
                    return t5pm_8am;
            case 11:
                    return t7pm_4am;
            case 12:
                    return t7pm_8am;
            case 13:
                    return t11pm_8am;
            case 14:
                    return t11pm_4pm;
            default:
                    return UNKNOWN;
        }
    }

    public static String getString(InsectTime time, Context context) {
        switch (time) {
            case t4am_8am_4pm_7pm:
                return context.getString(R.string.t4am_8am_4pm_7pm);
            case t4am_8am_5pm_7pm:
                return context.getString(R.string.t4am_8am_5pm_7pm);
            case t4am_5pm:
                return context.getString(R.string.t4am_5pm);
            case t4am_7pm:
                return context.getString(R.string.t4am_7pm);
            case t7am_4pm:
                return context.getString(R.string.t7am_4pm);
            case t8am_4pm:
                return context.getString(R.string.t8am_4pm);
            case t8am_5pm:
                return context.getString(R.string.t8am_5pm);
            case t8am_7pm:
                return context.getString(R.string.t8am_7pm);
            case t4pm_11pm:
                return context.getString(R.string.t4pm_11pm);
            case t5pm_4am:
                return context.getString(R.string.t5pm_4am);
            case t5pm_8am:
                return context.getString(R.string.t5pm_8am);
            case t7pm_4am:
                return context.getString(R.string.t7pm_4am);
            case t7pm_8am:
                return context.getString(R.string.t7pm_8am);
            case t11pm_8am:
                return context.getString(R.string.t11pm_8am);
            case t11pm_4pm:
                return context.getString(R.string.t11pm_4pm);
            default:
                return context.getString(R.string.Unknown);
        }
    }
}
