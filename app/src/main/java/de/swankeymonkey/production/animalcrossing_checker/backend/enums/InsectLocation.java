package de.swankeymonkey.production.animalcrossing_checker.backend.enums;

import android.content.Context;

import de.swankeymonkey.production.animalcrossing_checker.R;

public enum InsectLocation {
    FLYING(0),
    TREES(1),
    GROUND(2),
    FLOWERS(3),
    TREES_SHAKING(4),
    UNDERGROUND(5),
    WATER(6),
    TREE_STUMPS(7),
    ROTTEN_FOOD(8),
    BEACH(9),
    TRASH(10),
    ROCKS(11),
    ROCKS_HITTING(12),
    VILLAGERS(13),
    ROCKS_RAINING(14),
    UNKNOWN(15);

    private int id;

    InsectLocation(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static InsectLocation getLocation(int id) {
        switch(id) {
            case 0:
                    return FLYING;
            case 1:
                   return TREES;
            case 2:
                   return GROUND;
            case 3:
                   return FLOWERS;
            case 4:
                   return TREES_SHAKING;
            case 5:
                   return UNDERGROUND;
            case 6:
                   return WATER;
            case 7:
                   return TREE_STUMPS;
            case 8:
                   return ROTTEN_FOOD;
            case 9:
                   return BEACH;
            case 10:
                    return TRASH;
            case 11:
                    return ROCKS;
            case 12:
                    return ROCKS_HITTING;
            case 13:
                return VILLAGERS;
            case 14:
                return ROCKS_RAINING;
            default:
                    return UNKNOWN;
        }
    }

    public static String getString(InsectLocation location, Context context) {
        switch(location) {
            case FLYING:
                return context.getString(R.string.Flying);
            case TREES:
                return context.getString(R.string.Trees);
            case GROUND:
                return context.getString(R.string.Ground);
            case FLOWERS:
                return context.getString(R.string.Flowers);
            case TREES_SHAKING:
                return context.getString(R.string.Trees_Shaking);
            case UNDERGROUND:
                return context.getString(R.string.UnderGround);
            case WATER:
                return context.getString(R.string.Water);
            case TREE_STUMPS:
                return context.getString(R.string.Tree_Stumps);
            case ROTTEN_FOOD:
                return context.getString(R.string.Rotten_Food);
            case BEACH:
                return context.getString(R.string.Beach);
            case TRASH:
                return context.getString(R.string.Trash);
            case ROCKS:
                return context.getString(R.string.Rocks);
            case ROCKS_HITTING:
                return context.getString(R.string.Rocks_Hitting);
            case VILLAGERS:
                return context.getString(R.string.Villagers);
            case ROCKS_RAINING:
                return context.getString(R.string.Rocks_Raining);
            default:
                return context.getString(R.string.Unknown);
        }
    }
}
