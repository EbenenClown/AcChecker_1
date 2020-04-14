package de.swankeymonkey.production.animalcrossing_checker.backend.database;

import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.swankeymonkey.production.animalcrossing_checker.R;
import de.swankeymonkey.production.animalcrossing_checker.backend.enums.FishLocation;
import de.swankeymonkey.production.animalcrossing_checker.backend.enums.FishTime;
import de.swankeymonkey.production.animalcrossing_checker.backend.enums.InsectLocation;
import de.swankeymonkey.production.animalcrossing_checker.backend.enums.InsectTime;
import de.swankeymonkey.production.animalcrossing_checker.backend.models.Fish;
import de.swankeymonkey.production.animalcrossing_checker.backend.models.Insect;


import static de.swankeymonkey.production.animalcrossing_checker.backend.enums.FishTime.ALL_DAY;
import static de.swankeymonkey.production.animalcrossing_checker.backend.enums.InsectTime.*;
import static de.swankeymonkey.production.animalcrossing_checker.backend.enums.InsectLocation.*;

import static de.swankeymonkey.production.animalcrossing_checker.backend.enums.FishTime.*;
import static de.swankeymonkey.production.animalcrossing_checker.backend.enums.FishLocation.*;


public class DatabaseCreateHelper {
    private static final String MONTH_ALL = "all";
    private List<Fish> mAllFish;
    private List<Insect> mAllInsect;
    private Context mContext;

    public DatabaseCreateHelper(Context context) {
        mAllFish = new ArrayList<>();
        mAllInsect = new ArrayList<>();
        mContext = context;
    }

    public List<Fish> populateNorthernFishList() {
            createFish(gs(R.string.Bitterling), 900, RIVER, ALL_DAY, "November, December, January, February, March");
            createFish(gs(R.string.Pale_Chub), 160, RIVER, t9am_4pm, MONTH_ALL);
            createFish(gs(R.string.Crucian_Carp), 160, RIVER, ALL_DAY, MONTH_ALL);
            createFish(gs(R.string.Dace), 240, RIVER, t4pm_9am, MONTH_ALL);
            createFish(gs(R.string.Carp), 300, POND, ALL_DAY, MONTH_ALL);
            createFish(gs(R.string.Koi), 4000, POND, t4pm_9am, MONTH_ALL);
            createFish(gs(R.string.Goldfish), 1300, POND, ALL_DAY, MONTH_ALL);
            createFish(gs(R.string.Pop_eyed_Goldfish), 1300, POND, t9am_4pm, MONTH_ALL);
            createFish(gs(R.string.Ranchu_Goldfish), 4500, POND, t9am_4pm, MONTH_ALL);
            createFish(gs(R.string.Kilifish), 300, POND, ALL_DAY, "April, May, June, July, August");
            createFish(gs(R.string.Crawfish), 200, POND, ALL_DAY, "April, May, June, July, August, September");
            createFish(gs(R.string.Soft_shelled_turtle), 3750, RIVER, t4pm_9am, "August, September");
            createFish(gs(R.string.snapping_turtle), 5000, RIVER, t9pm_4am, "April, May, June, July, August, September, October");
            createFish(gs(R.string.tadpole), 100, POND, ALL_DAY, "March, April, May, June, July");
            createFish(gs(R.string.frog), 120, POND, ALL_DAY, "May, June, July, August");
            createFish(gs(R.string.freshwater_goby), 400, RIVER, t4pm_9am, MONTH_ALL);
            createFish(gs(R.string.Loach), 400, RIVER, ALL_DAY, "March, April, May");
            createFish(gs(R.string.catfish), 800, POND, t4pm_9am, "May, June, July, August, September, October");
            createFish(gs(R.string.giant_snakehead), 5500, POND, t9am_4pm, "June, July, August");
            createFish(gs(R.string.bluegill), 180, RIVER, t9am_4pm, MONTH_ALL);
            createFish(gs(R.string.yellow_perch), 300, RIVER, ALL_DAY, "October, November, December, January, February, March");
            createFish(gs(R.string.black_bass), 400, RIVER, ALL_DAY, MONTH_ALL);
            createFish(gs(R.string.Tilapia), 800, RIVER, ALL_DAY, "June, July, August, September, October");
            createFish(gs(R.string.Pike), 1800, RIVER, ALL_DAY, "September, October, November, December");
            createFish(gs(R.string.pond_smelt), 500, RIVER, ALL_DAY, "December, January, February");
            createFish(gs(R.string.sweetfish), 900, RIVER, ALL_DAY, "July, August, September");
            createFish(gs(R.string.cherry_salmon), 1000, RIVER_CLIFFTOP, t4pm_9am, "March, April, May, June, September, October, November");
            createFish(gs(R.string.Char), 3800, RIVER_CLIFFTOP, t4pm_9am, "March, April, May, June, September, October, November");
            createFish(gs(R.string.golden_trout), 15000, RIVER_CLIFFTOP, t4pm_9am, "March, April, May, September, October, November");
            createFish(gs(R.string.Stringfish), 15000, RIVER_CLIFFTOP, t4pm_9am, "December, January, February, March");
            createFish(gs(R.string.salmon), 700, RIVER_MOUTH, ALL_DAY, "September");
            createFish(gs(R.string.king_salmon), 1800, RIVER_MOUTH, ALL_DAY, "September");
            createFish(gs(R.string.mitten_crab), 2000, RIVER, t4pm_9am, "September, October, November");
            createFish(gs(R.string.guppy), 1300, RIVER, t9am_4pm, "April, May, June, July, August, September, October, November");
            createFish(gs(R.string.nibble_fish), 1500, RIVER, t9am_4pm, "May, June, July, August, September");
            createFish(gs(R.string.angelfish), 3000, RIVER, t4pm_9am, "May, June, July, August, September, October");
            createFish(gs(R.string.betta), 2500, RIVER, t9am_4pm, "May, June, July, August, September, October");
            createFish(gs(R.string.neon_tetra), 500, RIVER, t9am_4pm, "April, May, June, July, August, September, October, November");
            createFish(gs(R.string.rainbowfish), 800, RIVER, t9am_4pm, "May, June, July, August, September, October");
            createFish(gs(R.string.piranha), 2500, RIVER, t9am_4pm_9pm_4am, "June, July, August, September");
            createFish(gs(R.string.arowana), 10000, RIVER, t4pm_9am, "June, July, August, September");
            createFish(gs(R.string.dorado), 15000, RIVER, t4am_9pm, "June, July, August, September");
            createFish(gs(R.string.gar), 6000, POND, t4pm_9am, "June, July, August, September");
            createFish(gs(R.string.arapaima), 10000, RIVER, t4pm_9am, "June, July, August, September");
            createFish(gs(R.string.saddled_bichir), 4000, RIVER, t9pm_4am, "June, July, August, September");
            createFish(gs(R.string.sturgeon), 10000, RIVER_MOUTH, ALL_DAY, "September, October, November, December, January, February, March");
            createFish(gs(R.string.sea_butterfly), 1000, SEA, ALL_DAY, "December, January, February, March");
            createFish(gs(R.string.sea_horse), 1100, SEA, ALL_DAY, "April, May, June, July, August, September, October, November");
            createFish(gs(R.string.clown_fish), 650, SEA, ALL_DAY, "April, May, June, July, August, September");
            createFish(gs(R.string.surgeonfish), 1000, SEA, ALL_DAY, "April, May, June, July, August, September");
            createFish(gs(R.string.butterfly_fish), 1000, SEA, ALL_DAY, "April, May, June, July, August, September");
            createFish(gs(R.string.napoleonfish), 10000, SEA, t4am_9pm, "July, August");
            createFish(gs(R.string.zebra_turkeyfish), 500, SEA, ALL_DAY, "April, May, June, July, August, September, October, November");
            createFish(gs(R.string.blowfish), 5000, SEA, t9pm_4am, "November, December, January, February");
            createFish(gs(R.string.puffer_fish), 250, SEA, ALL_DAY, "July, August, September");
            createFish(gs(R.string.anchovy), 200, SEA, t4am_9pm, MONTH_ALL);
            createFish(gs(R.string.horse_mackerel), 150, SEA, ALL_DAY, MONTH_ALL);
            createFish(gs(R.string.Barred_knifejaw), 5000, SEA, ALL_DAY, "March, April, May, June, July, August, September, October, November");
            createFish(gs(R.string.sea_bass), 400, SEA, ALL_DAY, MONTH_ALL);
            createFish(gs(R.string.red_snapper), 3000, SEA, ALL_DAY, MONTH_ALL);
            createFish(gs(R.string.dab), 300, SEA, ALL_DAY, "October, November, December, January, February, March, April");
            createFish(gs(R.string.olive_flounder), 800, SEA, ALL_DAY, MONTH_ALL);
            createFish(gs(R.string.squid), 500, SEA, ALL_DAY, "December, January, February, March, April, May, June, July, August");
            createFish(gs(R.string.moray_eel), 2000, SEA, ALL_DAY, "August, September, October");
            createFish(gs(R.string.ribbon_eel), 600, SEA, ALL_DAY, "June, July, August, September, October");
            createFish(gs(R.string.tuna), 7000, PIER, ALL_DAY, "November, December, January, February, March, April");
            createFish(gs(R.string.blue_marlin), 10000, PIER, ALL_DAY, "November, December, January, February, March, April, July, August, September");
            createFish(gs(R.string.giant_trevally), 4500, PIER, ALL_DAY, "May, June, July, August, September");
            createFish(gs(R.string.mahi_mahi), 6000, PIER, ALL_DAY, "May, June, July, August, September, October");
            createFish(gs(R.string.ocean_sunfish), 4000, SEA, t4am_9pm, "July, August, September");
            createFish(gs(R.string.ray), 3000, SEA, t4am_9pm, "August, September, October, November");
            createFish(gs(R.string.saw_shark), 12000, SEA, t4pm_9am, "June, July, August, September");
            createFish(gs(R.string.Hammerhead_shark), 8000, SEA, t4pm_9am, "June, July, August, September");
            createFish(gs(R.string.Greate_white_shark), 15000, SEA, t4pm_9am, "June, July, August, September");
            createFish(gs(R.string.whale_shark), 13000, SEA, ALL_DAY, "June, July, August, September");
            createFish(gs(R.string.suckerfish), 1500, SEA, ALL_DAY, "June, July, August, September");
            createFish(gs(R.string.football_fish), 2500, SEA, t4pm_9am, "November, December, January, February, March");
            createFish(gs(R.string.oarfish), 9000, SEA, ALL_DAY, "December, January, February, March, April, May");
            createFish(gs(R.string.Barreleye), 15000, SEA, t9pm_4am, MONTH_ALL);
            createFish(gs(R.string.coelacanth), 15000, SEA_RAINING, ALL_DAY, MONTH_ALL);
            return mAllFish;
    }

    public List<Insect> populateInsectDb() {
        createInsect(gs(R.string.common_butterfly), 160, FLYING, t4am_7pm, "September, October, November, December, January, February, March, April, May, June");
        createInsect(gs(R.string.yellow_butterfly), 160, FLYING, t4am_7pm, "March, April, May, June, September, October");
        createInsect(gs(R.string.tiger_butterfly), 240, FLYING, t4am_7pm, "March, April, May, June, July, August, September");
        createInsect(gs(R.string.peacock_butterfly), 2500, FLYING, t4am_7pm, "March, April, May, June");
        createInsect(gs(R.string.common_bluebottle), 300, FLYING, t4am_7pm, "April, May, June, July, August");
        createInsect(gs(R.string.paper_kite_butterfly), 1000, FLYING, t8am_7pm, MONTH_ALL);
        createInsect(gs(R.string.great_purple_emperor), 3000, FLYING, t4am_7pm, "May, June, July, August");
        createInsect(gs(R.string.monarch_butterfly),  140, FLYING, t4am_5pm, "September, October, November");
        createInsect(gs(R.string.emperor_butterfly), 4000, FLYING, t5pm_8am, "December, January, February, March, June, July, August, September");
        createInsect(gs(R.string.agrias_butterfly), 3000, FLYING, t8am_5pm, "April, May, June, July, August, September");
        createInsect(gs(R.string.rajah_brooke_birdwing), 2500, FLYING, t8am_5pm, "December January, February, April, May, June, July, August, September");
        createInsect(gs(R.string.queen_alexandra_birdwing), 4000, FLYING, t8am_4pm, "May, June, July, August, September");
        createInsect(gs(R.string.moth), 130, FLYING, t7pm_4am, MONTH_ALL);
        createInsect(gs(R.string.atlas_moth), 3000, TREES, t7pm_4am, "April, May, June, July, August, September");
        createInsect(gs(R.string.madagascan_sunset_moth), 2500, FLYING, t8am_4pm, "April, May, June, July, August, September");
        createInsect(gs(R.string.long_locust), 200, GROUND, t8am_7pm, "April, May, June, July, August, September, October, November");
        createInsect(gs(R.string.migratory_locust), 600, GROUND, t8am_7pm, "August, September, October, November");
        createInsect(gs(R.string.rice_grasshopper), 160, GROUND, t8am_7pm, "August, September, October, November");
        createInsect(gs(R.string.grasshoper), 160, GROUND, t8am_5pm, "July, August, September");
        createInsect(gs(R.string.cricket), 130, GROUND, t5pm_8am, "September, October, November");
        createInsect(gs(R.string.bell_cricket), 430, GROUND, t5pm_8am, "September, October");
        createInsect(gs(R.string.mantis), 430, FLOWERS, t8am_5pm, "March, April, May, June, July, August, September, October, November");
        createInsect(gs(R.string.orchid_mantis), 2400, FLOWERS, t8am_5pm, "March, April, May, June, July, August, September, October, November");
        createInsect(gs(R.string.honeybee), 200, FLYING, t8am_5pm, "March, April, May, June, July");
        createInsect(gs(R.string.wasp), 2500, TREES_SHAKING, InsectTime.ALL_DAY, MONTH_ALL);
        createInsect(gs(R.string.brown_cicada), 250, TREES, t8am_5pm, "July, August");
        createInsect(gs(R.string.robust_cicada), 300, TREES, t8am_5pm, "July, August");
        createInsect(gs(R.string.giant_cicada), 500, TREES, t8am_5pm, "July, August");
        createInsect(gs(R.string.walker_cicada), 400, TREES, t4am_8am_4pm_7pm, "August, September");
        createInsect(gs(R.string.evening_cicada), 550, TREES, t4am_8am_4pm_7pm, "July, August");
        createInsect(gs(R.string.cicada_shell), 10, TREES, InsectTime.ALL_DAY, "July, August");
        createInsect(gs(R.string.red_dragonfly), 180, FLYING, t8am_7pm, "September, October");
        createInsect(gs(R.string.darner_dragonfly), 230, FLYING, t8am_5pm, "April, May, June, July, August, September, October");
        createInsect(gs(R.string.banded_dragonfly), 4500, FLYING, t8am_5pm, "May, June, July, August, September, October");
        createInsect(gs(R.string.damselfly), 500, FLYING, InsectTime.ALL_DAY, "November, December, January, February");
        createInsect(gs(R.string.firefly), 300, FLYING, t7pm_4pm, "June");
        createInsect(gs(R.string.mole_cricket), 500, UNDERGROUND, InsectTime.ALL_DAY, "November, December, January, February, March, April, May");
        createInsect(gs(R.string.pondskater), 130, WATER, t8am_7pm, "May, June, July, August, September");
        createInsect(gs(R.string.diving_beetle), 800, WATER, t8am_7pm, "May, June, July, August, September");
        createInsect(gs(R.string.giant_water_bug), 2000, WATER, t7pm_8am, "April, May, June, July, August, September");
        createInsect(gs(R.string.stinkbug), 120, FLOWERS, InsectTime.ALL_DAY, "March, April, May, June, July, August, September, October");
        createInsect(gs(R.string.man_faced_stink_bug), 1000, FLOWERS, t7pm_8am, "March, April, May, June, July, August, September, October");
        createInsect(gs(R.string.ladybug), 200, FLOWERS, t8am_5pm, "March, April, May, June, October");
        createInsect(gs(R.string.tiger_beetle), 1500, FLYING, InsectTime.ALL_DAY, "February, March, April, May, June, July, August, September, October");
        createInsect(gs(R.string.jewel_beetle), 2400, TREE_STUMPS, InsectTime.ALL_DAY, "April, May, June, July, August");
        createInsect(gs(R.string.violin_beetle), 450, TREES, InsectTime.ALL_DAY, "May, June, September, October, November");
        createInsect(gs(R.string.citrus_long_horned_beetle), 350, TREE_STUMPS, InsectTime.ALL_DAY, MONTH_ALL);
        createInsect(gs(R.string.rosalia_batesi_beetle), 3000, TREE_STUMPS, InsectTime.ALL_DAY, "May, June, July, August, September");
        createInsect(gs(R.string.blue_weevil_beetle), 800, TREES, InsectTime.ALL_DAY, "August, July");
        createInsect(gs(R.string.dung_beetle), 3000, GROUND, InsectTime.ALL_DAY,"December, January, February");
        createInsect(gs(R.string.earth_boring_dung_beetle), 300, GROUND, InsectTime.ALL_DAY, "July, August, September");
        createInsect(gs(R.string.scarab_beetle), 10000, TREES, t11pm_8am, "July, August");
        createInsect(gs(R.string.drone_beetle), 200, TREES, InsectTime.ALL_DAY, "July, August, June");
        createInsect(gs(R.string.goliath_beetle), 8000, TREES, t5pm_8am, "June, July, August, September");
        createInsect(gs(R.string.saw_stag), 2000, TREES, InsectTime.ALL_DAY, "July, August");
        createInsect(gs(R.string.miyama_stag), 1000, TREES, InsectTime.ALL_DAY, "July, August");
        createInsect(gs(R.string.giant_stag), 10000, TREES, t11pm_8am, "July, August");
        createInsect(gs(R.string.rainbow_stag), 6000, TREES, t7pm_8am, "June, July, August, September");
        createInsect(gs(R.string.cyclommatus_stag), 8000, TREES, t5pm_8am, "July, August");
        createInsect(gs(R.string.golden_stag), 12000, TREES, t5pm_8am, "July, August");
        createInsect(gs(R.string.giraffe_stag), 12000, TREES, t5pm_8am, "July, August");
        createInsect(gs(R.string.horned_dynastid), 1350, TREES, t5pm_8am, "July, August");
        createInsect(gs(R.string.horned_atlas), 8000, TREES, t5pm_8am, "July, August");
        createInsect(gs(R.string.horned_elephant), 8000, TREES, t5pm_8am, "July, August ");
        createInsect(gs(R.string.horned_hercules), 12000, TREES, t5pm_8am, "July, August");
        createInsect(gs(R.string.walking_stick), 600, TREES, t4am_8am_5pm_7pm, "July, August, September, October, November");
        createInsect(gs(R.string.walking_leaf), 600, GROUND, InsectTime.ALL_DAY, "July, August, September");
        createInsect(gs(R.string.bagworm), 600, TREES, InsectTime.ALL_DAY, MONTH_ALL);
        createInsect(gs(R.string.ant), 80, ROTTEN_FOOD, InsectTime.ALL_DAY, MONTH_ALL);
        createInsect(gs(R.string.hermit_crab), 1000, BEACH, t7pm_8am, MONTH_ALL);
        createInsect(gs(R.string.wharf_roach), 200, BEACH, InsectTime.ALL_DAY, MONTH_ALL);
        createInsect(gs(R.string.fly), 60, TRASH, InsectTime.ALL_DAY, MONTH_ALL);
        createInsect(gs(R.string.mosquito), 130, FLYING, t5pm_4am, "June, July, August, September");
        createInsect(gs(R.string.flea), 70, VILLAGERS, InsectTime.ALL_DAY, "April, May, June, July, August, September, October, November");
        createInsect(gs(R.string.snail), 250, ROCKS_RAINING, InsectTime.ALL_DAY, MONTH_ALL);
        createInsect(gs(R.string.pil_bug), 250, ROCKS_HITTING, t11pm_4pm, "September, October, November, December, January, February, March, April, May, June");
        createInsect(gs(R.string.centipede), 300, ROCKS_HITTING, t5pm_11pm,  "September, October, November, December, January, February, March, April, May, June");
        createInsect(gs(R.string.spider), 400, TREES_SHAKING, t7pm_8am, MONTH_ALL);
        createInsect(gs(R.string.tarantula), 8000, GROUND, t7pm_4am, "November, December, January, February, March, April");
        createInsect(gs(R.string.scorpion), 8000, GROUND, t7pm_4am, "May, June, July, August, September, October");
        return mAllInsect;
    }

    private void createFish(String name, int price, FishLocation location, FishTime time, String month) {
        Fish xyza = new Fish();
        xyza.setName(name);
        xyza.setLocation(location);
        xyza.setPrice(price);
        xyza.setTime(time);
        xyza.setMonths(transformArray(month));
        mAllFish.add(xyza);
    }

    private void createInsect(String name, int price, InsectLocation location, InsectTime time, String month) {
        Insect xyza = new Insect();
        xyza.setName(name);
        xyza.setLocation(location);
        xyza.setPrice(price);
        xyza.setTime(time);
        xyza.setMonths(transformArray(month));
        mAllInsect.add(xyza);
    }

    private String gs(int id) {
       return mContext.getString(id);
    }

    private ArrayList<String> transformArray(String input) {
        return new ArrayList<>(Arrays.asList(input.split(", ")));
    }


}
