package de.swankeymonkey.production.animalcrossing_checker.backend.database;

import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.swankeymonkey.production.animalcrossing_checker.R;
import de.swankeymonkey.production.animalcrossing_checker.backend.enums.FishLocation;
import de.swankeymonkey.production.animalcrossing_checker.backend.enums.FishTime;
import de.swankeymonkey.production.animalcrossing_checker.backend.models.Fish;

import static de.swankeymonkey.production.animalcrossing_checker.backend.enums.FishLocation.*;
import static de.swankeymonkey.production.animalcrossing_checker.backend.enums.FishTime.*;

public class DatabaseCreateHelper {
    private static final String MONTH_ALL = "all";
    private List<Fish> mAllFish;
    private Context mContext;

    public DatabaseCreateHelper(Context context) {
        mAllFish = new ArrayList<>();
        mContext = context;
    }

    public List<Fish> populateNorthernFishList() {
            createFish(getRString(R.string.Bitterling), 900, RIVER, ALL_DAY, "November, December, January, February, March");
            createFish(getRString(R.string.Pale_Chub), 160, RIVER, t9am_4pm, MONTH_ALL);
            createFish(getRString(R.string.Crucian_Carp), 160, RIVER, ALL_DAY, MONTH_ALL);
            createFish(getRString(R.string.Dace), 240, RIVER, t4pm_9am, MONTH_ALL);
            createFish(getRString(R.string.Carp), 300, POND, ALL_DAY, MONTH_ALL);
            createFish(getRString(R.string.Koi), 4000, POND, t4pm_9am, MONTH_ALL);
            createFish(getRString(R.string.Goldfish), 1300, POND, ALL_DAY, MONTH_ALL);
            createFish(getRString(R.string.Pop_eyed_Goldfish), 1300, POND, t9am_4pm, MONTH_ALL);
            createFish(getRString(R.string.Ranchu_Goldfish), 4500, POND, t9am_4pm, MONTH_ALL);
            createFish(getRString(R.string.Kilifish), 300, POND, ALL_DAY, "April, May, June, July, August");
            createFish(getRString(R.string.Crawfish), 200, POND, ALL_DAY, "April, May, June, July, August, September");
            createFish(getRString(R.string.Soft_shelled_turtle), 3750, RIVER, t4pm_9am, "August, September");
            createFish(getRString(R.string.snapping_turtle), 5000, RIVER, t9pm_4am, "April, May, June, July, August, September, October");
            createFish(getRString(R.string.tadpole), 100, POND, ALL_DAY, "March, April, May, June, July");
            createFish(getRString(R.string.frog), 120, POND, ALL_DAY, "May, June, July, August");
            createFish(getRString(R.string.freshwater_goby), 400, RIVER, t4pm_9am, MONTH_ALL);
            createFish(getRString(R.string.Loach), 400, RIVER, ALL_DAY, "March, April, May");
            createFish(getRString(R.string.catfish), 800, POND, t4pm_9am, "May, June, July, August, September, October");
            createFish(getRString(R.string.giant_snakehead), 5500, POND, t9am_4pm, "June, July, August");
            createFish(getRString(R.string.bluegill), 180, RIVER, t9am_4pm, MONTH_ALL);
            createFish(getRString(R.string.yellow_perch), 300, RIVER, ALL_DAY, "October, November, December, January, February, March");
            createFish(getRString(R.string.black_bass), 400, RIVER, ALL_DAY, MONTH_ALL);
            createFish(getRString(R.string.Tilapia), 800, RIVER, ALL_DAY, "June, July, August, September, October");
            createFish(getRString(R.string.Pike), 1800, RIVER, ALL_DAY, "September, October, November, December");
            createFish(getRString(R.string.pond_smelt), 500, RIVER, ALL_DAY, "December, January, February");
            createFish(getRString(R.string.sweetfish), 900, RIVER, ALL_DAY, "July, August, September");
            createFish(getRString(R.string.cherry_salmon), 1000, RIVER_CLIFFTOP, t4pm_9am, "March, April, May, June, September, October, November");
            createFish(getRString(R.string.Char), 3800, RIVER_CLIFFTOP, t4pm_9am, "March, April, May, June, September, October, November");
            createFish(getRString(R.string.golden_trout), 15000, RIVER_CLIFFTOP, t4pm_9am, "March, April, May, September, October, November");
            createFish(getRString(R.string.Stringfish), 15000, RIVER_CLIFFTOP, t4pm_9am, "December, January, February, March");
            createFish(getRString(R.string.salmon), 700, RIVER_MOUTH, ALL_DAY, "September");
            createFish(getRString(R.string.king_salmon), 1800, RIVER_MOUTH, ALL_DAY, "September");
            createFish(getRString(R.string.mitten_crab), 2000, RIVER, t4pm_9am, "September, October, November");
            createFish(getRString(R.string.guppy), 1300, RIVER, t9am_4pm, "April, May, June, July, August, September, October, November");
            createFish(getRString(R.string.nibble_fish), 1500, RIVER, t9am_4pm, "May, June, July, August, September");
            createFish(getRString(R.string.angelfish), 3000, RIVER, t4pm_9am, "May, June, July, August, September, October");
            createFish(getRString(R.string.betta), 2500, RIVER, t9am_4pm, "May, June, July, August, September, October");
            createFish(getRString(R.string.neon_tetra), 500, RIVER, t9am_4pm, "April, May, June, July, August, September, October, November");
            createFish(getRString(R.string.rainbowfish), 800, RIVER, t9am_4pm, "May, June, July, August, September, October");
            createFish(getRString(R.string.piranha), 2500, RIVER, t9am_4pm_9pm_4am, "June, July, August, September");
            createFish(getRString(R.string.arowana), 10000, RIVER, t4pm_9am, "June, July, August, September");
            createFish(getRString(R.string.dorado), 15000, RIVER, t4am_9pm, "June, July, August, September");
            createFish(getRString(R.string.gar), 6000, POND, t4pm_9am, "June, July, August, September");
            createFish(getRString(R.string.arapaima), 10000, RIVER, t4pm_9am, "June, July, August, September");
            createFish(getRString(R.string.saddled_bichir), 4000, RIVER, t9pm_4am, "June, July, August, September");
            createFish(getRString(R.string.sturgeon), 10000, RIVER_MOUTH, ALL_DAY, "September, October, November, December, January, February, March");
            createFish(getRString(R.string.sea_butterfly), 1000, SEA, ALL_DAY, "December, January, February, March");
            createFish(getRString(R.string.sea_horse), 1100, SEA, ALL_DAY, "April, May, June, July, August, September, October, November");
            createFish(getRString(R.string.clown_fish), 650, SEA, ALL_DAY, "April, May, June, July, August, September");
            createFish(getRString(R.string.surgeonfish), 1000, SEA, ALL_DAY, "April, May, June, July, August, September");
            createFish(getRString(R.string.butterfly_fish), 1000, SEA, ALL_DAY, "April, May, June, July, August, September");
            createFish(getRString(R.string.napoleonfish), 10000, SEA, t4am_9pm, "July, August");
            createFish(getRString(R.string.zebra_turkeyfish), 500, SEA, ALL_DAY, "April, May, June, July, August, September, October, November");
            createFish(getRString(R.string.blowfish), 5000, SEA, t9pm_4am, "November, December, January, February");
            createFish(getRString(R.string.puffer_fish), 250, SEA, ALL_DAY, "July, August, September");
            createFish(getRString(R.string.anchovy), 200, SEA, t4am_9pm, MONTH_ALL);
            createFish(getRString(R.string.horse_mackerel), 150, SEA, ALL_DAY, MONTH_ALL);
            createFish(getRString(R.string.Barred_knifejaw), 5000, SEA, ALL_DAY, "March, April, May, June, July, August, September, October, November");
            createFish(getRString(R.string.sea_bass), 400, SEA, ALL_DAY, MONTH_ALL);
            createFish(getRString(R.string.red_snapper), 3000, SEA, ALL_DAY, MONTH_ALL);
            createFish(getRString(R.string.dab), 300, SEA, ALL_DAY, "October, November, December, January, February, March, April");
            createFish(getRString(R.string.olive_flounder), 800, SEA, ALL_DAY, MONTH_ALL);
            createFish(getRString(R.string.squid), 500, SEA, ALL_DAY, "December, January, February, March, April, May, June, July, August");
            createFish(getRString(R.string.moray_eel), 2000, SEA, ALL_DAY, "August, September, October");
            createFish(getRString(R.string.ribbon_eel), 600, SEA, ALL_DAY, "June, July, August, September, October");
            createFish(getRString(R.string.tuna), 7000, PIER, ALL_DAY, "November, December, January, February, March, April");
            createFish(getRString(R.string.blue_marlin), 10000, PIER, ALL_DAY, "November, December, January, February, March, April, July, August, September");
            createFish(getRString(R.string.giant_trevally), 4500, PIER, ALL_DAY, "May, June, July, August, September");
            createFish(getRString(R.string.mahi_mahi), 6000, PIER, ALL_DAY, "May, June, July, August, September, October");
            createFish(getRString(R.string.ocean_sunfish), 4000, SEA, t4am_9pm, "July, August, September");
            createFish(getRString(R.string.ray), 3000, SEA, t4am_9pm, "August, September, October, November");
            createFish(getRString(R.string.saw_shark), 12000, SEA, t4pm_9am, "June, July, August, September");
            createFish(getRString(R.string.Hammerhead_shark), 8000, SEA, t4pm_9am, "June, July, August, September");
            createFish(getRString(R.string.Greate_white_shark), 15000, SEA, t4pm_9am, "June, July, August, September");
            createFish(getRString(R.string.whale_shark), 13000, SEA, ALL_DAY, "June, July, August, September");
            createFish(getRString(R.string.suckerfish), 1500, SEA, ALL_DAY, "June, July, August, September");
            createFish(getRString(R.string.football_fish), 2500, SEA, t4pm_9am, "November, December, January, February, March");
            createFish(getRString(R.string.oarfish), 9000, SEA, ALL_DAY, "December, January, February, March, April, May");
            createFish(getRString(R.string.Barreleye), 15000, SEA, t9pm_4am, MONTH_ALL);
            createFish(getRString(R.string.coelacanth), 15000, SEA, ALL_DAY, MONTH_ALL);
            return mAllFish;
    }

    private Fish createFish(String name, int price, FishLocation location, FishTime time, String month) {
        Fish xyza = new Fish();
        xyza.setName(name);
        xyza.setLocation(location);
        xyza.setPrice(price);
        xyza.setTime(time);
        xyza.setMonths(transformArray(month));
        mAllFish.add(xyza);
        return xyza;
    }

    private String getRString(int id) {
       return mContext.getString(id);
    }

    private ArrayList<String> transformArray(String input) {
        return new ArrayList<>(Arrays.asList(input.split(", ")));
    }


}
