package de.swankeymonkey.production.animalcrossing_checker.backend.enums;

import android.content.Context;

import de.swankeymonkey.production.animalcrossing_checker.R;

public enum FishLocation {
    RIVER(0),
    RIVER_CLIFFTOP(1),
    RIVER_MOUTH(2),
    SEA(3),
    PIER(4),
    SEA_RAINING(5),
    POND(6);

    private int id;

    FishLocation(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static FishLocation getLocation(int id) {
        switch (id) {
            case 0:
                return RIVER;
            case 1:
                return RIVER_CLIFFTOP;
            case 2:
                return RIVER_MOUTH;
            case 3:
                return SEA;
            case 4:
                return PIER;
            case 5:
                return SEA_RAINING;
            default:
                return POND;
        }
    }

    public static String getString(FishLocation location, Context context) {
        switch(location) {
            case RIVER:
                return context.getString(R.string.River);
            case RIVER_CLIFFTOP:
                return context.getString(R.string.River_Clifftop);
            case RIVER_MOUTH:
                return context.getString(R.string.River_Mouth);
            case SEA:
                return context.getString(R.string.Sea);
            case PIER:
                return context.getString(R.string.Pier);
            case POND:
                return context.getString(R.string.Pond);
            case SEA_RAINING:
                return context.getString(R.string.Sea_Raining);
            default:
                return context.getString(R.string.Unknown);
        }
    }

}
