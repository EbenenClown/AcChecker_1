package de.swankeymonkey.production.animalcrossing_checker.ui.main.adapters;

import android.content.Context;
import android.view.View;

import de.swankeymonkey.production.animalcrossing_checker.R;
import de.swankeymonkey.production.animalcrossing_checker.backend.enums.FishLocation;
import de.swankeymonkey.production.animalcrossing_checker.backend.enums.InsectLocation;
import de.swankeymonkey.production.animalcrossing_checker.backend.enums.InsectTime;
import de.swankeymonkey.production.animalcrossing_checker.backend.models.Animal;
import de.swankeymonkey.production.animalcrossing_checker.backend.models.Insect;

public class InsectRecyclerViewAdapter extends AnimalRecyclerViewAdapter<Insect> {

    public InsectRecyclerViewAdapter(Context context, CheckboxClicker<Insect> listener) {
        super(context, listener);
    }

    @Override
    protected AnimalViewHolder setViewHolder(View view) {
        return new InsectViewHolder(view);
    }

    public class InsectViewHolder extends AnimalViewHolder {
        public InsectViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void setImage(Animal animal) {
            switch (animal.getId()) {
                case 1:
                    mImage.setImageResource(R.drawable.commonbutterfly);
                    break;
                case 2:
                    mImage.setImageResource(R.drawable.yellowbutterfly);
                    break;
                case 3:
                    mImage.setImageResource(R.drawable.tigerbutterfly);
                    break;
                case 4:
                    mImage.setImageResource(R.drawable.peacockbutterfly);
                    break;
                case 5:
                    mImage.setImageResource(R.drawable.commonbluebottle);
                    break;
                case 6:
                    mImage.setImageResource(R.drawable.paperkitebutterfly);
                    break;
                case 7:
                    mImage.setImageResource(R.drawable.greatpurpleemperor);
                    break;
                case 8:
                    mImage.setImageResource(R.drawable.monarchbutterfly);
                    break;
                case 9:
                    mImage.setImageResource(R.drawable.emperorbutterfly);
                    break;
                case 10:
                    mImage.setImageResource(R.drawable.agriasbutterfly);
                    break;
                case 11:
                    mImage.setImageResource(R.drawable.rajahbrookesbirdwing);
                    break;
                case 12:
                    mImage.setImageResource(R.drawable.queenalexandrasbirdwing);
                    break;
                case 13:
                    mImage.setImageResource(R.drawable.moth);
                    break;
                case 14:
                    mImage.setImageResource(R.drawable.atlasmoth);
                    break;
                case 15:
                    mImage.setImageResource(R.drawable.madagascansunsetmoth);
                    break;
                case 16:
                    mImage.setImageResource(R.drawable.longlocust);
                    break;
                case 17:
                    mImage.setImageResource(R.drawable.migratorylocust);
                    break;
                case 18:
                    mImage.setImageResource(R.drawable.ricegrasshopper);
                    break;
                case 19:
                    mImage.setImageResource(R.drawable.grasshopper);
                    break;
                case 20:
                    mImage.setImageResource(R.drawable.cricket);
                    break;
                case 21:
                    mImage.setImageResource(R.drawable.bellcricket);
                    break;
                case 22:
                    mImage.setImageResource(R.drawable.mantis);
                    break;
                case 23:
                    mImage.setImageResource(R.drawable.orchidmantis);
                    break;
                case 24:
                    mImage.setImageResource(R.drawable.honeybee);
                    break;
                case 25:
                    mImage.setImageResource(R.drawable.wasp);
                    break;
                case 26:
                    mImage.setImageResource(R.drawable.browncicada);
                    break;
                case 27:
                    mImage.setImageResource(R.drawable.robustcicada);
                    break;
                case 28:
                    mImage.setImageResource(R.drawable.giantcicada);
                    break;
                case 29:
                    mImage.setImageResource(R.drawable.walkercicada);
                    break;
                case 30:
                    mImage.setImageResource(R.drawable.eveningcicada);
                    break;
                case 31:
                    mImage.setImageResource(R.drawable.cicadashell);
                    break;
                case 32:
                    mImage.setImageResource(R.drawable.reddragonfly);
                    break;
                case 33:
                    mImage.setImageResource(R.drawable.darnerdragonfly);
                    break;
                case 34:
                    mImage.setImageResource(R.drawable.bandeddragonfly);
                    break;
                case 35:
                    mImage.setImageResource(R.drawable.damselfly);
                    break;
                case 36:
                    mImage.setImageResource(R.drawable.firefly);
                    break;
                case 37:
                    mImage.setImageResource(R.drawable.molecricket);
                    break;
                case 38:
                    mImage.setImageResource(R.drawable.pondskater);
                    break;
                case 39:
                    mImage.setImageResource(R.drawable.divingbeetle);
                    break;
                case 40:
                    mImage.setImageResource(R.drawable.giantwaterbug);
                    break;
                case 41:
                    mImage.setImageResource(R.drawable.stinkbug);
                    break;
                case 42:
                    mImage.setImageResource(R.drawable.manfacedstinkbug);
                    break;
                case 43:
                    mImage.setImageResource(R.drawable.ladybug);
                    break;
                case 44:
                    mImage.setImageResource(R.drawable.tigerbeetle);
                    break;
                case 45:
                    mImage.setImageResource(R.drawable.jewelbeetle);
                    break;
                case 46:
                    mImage.setImageResource(R.drawable.violinbeetle);
                    break;
                case 47:
                    mImage.setImageResource(R.drawable.citruslonghornedbeetle);
                    break;
                case 48:
                    mImage.setImageResource(R.drawable.rosaliabatesibeetle);
                    break;
                case 49:
                    mImage.setImageResource(R.drawable.blueweevilbeetle);
                    break;
                case 50:
                    mImage.setImageResource(R.drawable.dungbeetle);
                    break;
                case 51:
                    mImage.setImageResource(R.drawable.earthboringdungbeetle);
                    break;
                case 52:
                    mImage.setImageResource(R.drawable.scarabbeetle);
                    break;
                case 53:
                    mImage.setImageResource(R.drawable.dronebeetle);
                    break;
                case 54:
                    mImage.setImageResource(R.drawable.goliathbeetle);
                    break;
                case 55:
                    mImage.setImageResource(R.drawable.sawstag);
                    break;
                case 56:
                    mImage.setImageResource(R.drawable.miyamastag);
                    break;
                case 57:
                    mImage.setImageResource(R.drawable.giantstag);
                    break;
                case 58:
                    mImage.setImageResource(R.drawable.rainbowstag);
                    break;
                case 59:
                    mImage.setImageResource(R.drawable.cyclommatusstag);
                    break;
                case 60:
                    mImage.setImageResource(R.drawable.goldenstag);
                    break;
                case 61:
                    mImage.setImageResource(R.drawable.giraffestag);
                    break;
                case 62:
                    mImage.setImageResource(R.drawable.horneddynastid);
                    break;
                case 63:
                    mImage.setImageResource(R.drawable.hornedatlas);
                    break;
                case 64:
                    mImage.setImageResource(R.drawable.hornedelephant);
                    break;
                case 65:
                    mImage.setImageResource(R.drawable.hornedhercules);
                    break;
                case 66:
                    mImage.setImageResource(R.drawable.walkingstick);
                    break;
                case 67:
                    mImage.setImageResource(R.drawable.walkingleaf);
                    break;
                case 68:
                    mImage.setImageResource(R.drawable.bagworm);
                    break;
                case 69:
                    mImage.setImageResource(R.drawable.ant);
                    break;
                case 70:
                    mImage.setImageResource(R.drawable.hermitcrab);
                    break;
                case 71:
                    mImage.setImageResource(R.drawable.wharfroach);
                    break;
                case 72:
                    mImage.setImageResource(R.drawable.fly);
                    break;
                case 73:
                    mImage.setImageResource(R.drawable.mosquito);
                    break;
                case 74:
                    mImage.setImageResource(R.drawable.flea);
                    break;
                case 75:
                    mImage.setImageResource(R.drawable.snail);
                    break;
                case 76:
                    mImage.setImageResource(R.drawable.pillbug);
                    break;
                case 77:
                    mImage.setImageResource(R.drawable.centipede);
                    break;
                case 78:
                    mImage.setImageResource(R.drawable.spider);
                    break;
                case 79:
                    mImage.setImageResource(R.drawable.tarantula);
                    break;
                case 80:
                    mImage.setImageResource(R.drawable.scorpion);
                    break;
            }
        }

        @Override
        protected void setLocation(Animal animal) {
            mLocationText.setText(InsectLocation.getString(((Insect)animal).getLocation(), mContext));
            switch (((Insect)animal).getLocation()) {
                case TREES:
                    mLocation.setImageResource(R.drawable.i_location_tree);
                    break;
                case WATER:
                    mLocation.setImageResource(R.drawable.f_location_pond);
                    break;
                case GROUND:
                    mLocation.setImageResource(R.drawable.i_location_ground);
                    break;
                case FLOWERS:
                    mLocation.setImageResource(R.drawable.i_location_flowers);
                    break;
                case TREE_STUMPS:
                    mLocation.setImageResource(R.drawable.i_location_tree_stump);
                    break;
                case FLYING:
                    mLocation.setImageResource(R.drawable.i_location_flying);
                    break;
                case BEACH:
                    mLocation.setImageResource(R.drawable.f_location_sea);
                    break;
                case ROCKS:
                    mLocation.setImageResource(R.drawable.i_location_rock);
                    break;
                case TRASH:
                    mLocation.setImageResource(R.drawable.i_location_trash);
                    break;
                case ROCKS_HITTING:
                    mLocation.setImageResource(R.drawable.i_location_rock);
                    break;
                case ROTTEN_FOOD:
                    mLocation.setImageResource(R.drawable.i_lcoation_rotten_food);
                    break;
                case UNDERGROUND:
                    mLocation.setImageResource(R.drawable.i_location_underground);
                    break;
                case TREES_SHAKING:
                    mLocation.setImageResource(R.drawable.i_location_tree);
                    break;
            }
        }

        @Override
        protected void setTime(Animal animal) {
            mTime.setText(InsectTime.getString(((Insect)animal).getTime(), mContext));
        }
    }
}
