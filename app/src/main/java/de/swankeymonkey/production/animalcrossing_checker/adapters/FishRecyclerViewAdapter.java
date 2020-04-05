package de.swankeymonkey.production.animalcrossing_checker.adapters;

import android.content.Context;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.swankeymonkey.production.animalcrossing_checker.R;
import de.swankeymonkey.production.animalcrossing_checker.backend.enums.FishLocation;
import de.swankeymonkey.production.animalcrossing_checker.backend.enums.FishTime;
import de.swankeymonkey.production.animalcrossing_checker.backend.models.Fish;

public class FishRecyclerViewAdapter extends RecyclerView.Adapter<FishRecyclerViewAdapter.FishViewHolder> {
    private List<Fish> mFishList;
    private Context mContext;
    private List<Integer> mPositionSaves;
    private CheckboxClicker mCallback;

    public FishRecyclerViewAdapter(Context context, CheckboxClicker clicker) {
        mFishList = new ArrayList<>();
        mContext = context;
        mPositionSaves = new ArrayList<>();
        mCallback = clicker;

    }

    public void setData(List<Fish> list) {
        mFishList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FishViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_fish_listitem, parent, false);
        return new FishViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FishViewHolder holder, final int position) {
        final boolean isExpanded = mPositionSaves.indexOf(position) != -1;
        holder.mDetails.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.itemView.setActivated(isExpanded);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isExpanded) {
                    mPositionSaves.remove((Object)position);
                } else {
                    mPositionSaves.add(position);
                }
                notifyDataSetChanged();
            }
        });
        final Fish fish = mFishList.get(position);
        holder.mIsCatched.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onClicked(fish);
            }
        });

        holder.bind(fish);
    }

    @Override
    public int getItemCount() {
        return mFishList.size();
    }

    public class FishViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ivImage)
        ImageView mImage;
        @BindView(R.id.tvName)
        TextView mName;
        @BindView(R.id.ivLocation)
        ImageView mLocation;
        @BindView(R.id.cbCatched)
        CheckBox mIsCatched;
        @BindView(R.id.tvPrice)
        TextView mPrice;
        @BindView(R.id.tvTime)
        TextView mTime;
        @BindView(R.id.details)
        ConstraintLayout mDetails;
        @BindView(R.id.bJan)
        Button mJanButton;
        @BindView(R.id.bFeb)
        Button mFebButton;
        @BindView(R.id.bMarch)
        Button mMarButton;
        @BindView(R.id.bApr)
        Button mAprButton;
        @BindView(R.id.bMay)
        Button mMayButton;
        @BindView(R.id.bJune)
        Button mJunButton;
        @BindView(R.id.bJul)
        Button mJulButton;
        @BindView(R.id.bAug)
        Button mAugButton;
        @BindView(R.id.bSep)
        Button mSepButton;
        @BindView(R.id.bOct)
        Button mOctButton;
        @BindView(R.id.bNov)
        Button mNovButton;
        @BindView(R.id.bDec)
        Button mDecButton;
        @BindView(R.id.expander)
        ImageView mExpander;


        public FishViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(Fish fish) {
            mName.setText(fish.getName());
            mPrice.setText(fish.getPrice() + " bells");
            mTime.setText(FishTime.getTimeString(fish.getTime(), mContext));
            mIsCatched.setChecked(fish.isCatched());
            if(fish.isCatched()) {
                itemView.setBackground(mContext.getResources().getDrawable(R.drawable.custom_listitem_background_checked));
            } else {
                itemView.setBackground(mContext.getResources().getDrawable(R.drawable.custom_listitem_background));
            }
            setFishPicture(fish.getId());
            setMonths(fish.getMonths());
            setLocationPicture(fish.getLocation());
        }

        private void setLocationPicture(FishLocation location) {
            switch (location) {
                case RIVER:
                    mLocation.setImageResource(R.drawable.f_location_river);
                    break;
                case RIVER_MOUTH:
                    mLocation.setImageResource(R.drawable.f_location_river_mouth);
                    break;
                case RIVER_CLIFFTOP:
                    mLocation.setImageResource(R.drawable.f_location_waterfall);
                    break;
                case SEA:
                    mLocation.setImageResource(R.drawable.f_location_sea);
                    break;
                case PIER:
                    mLocation.setImageResource(R.drawable.f_location_pier);
                    break;
                case POND:
                    mLocation.setImageResource(R.drawable.f_location_pond);
                    break;
            }
        }

        private void setFishPicture(int FishId) {
            switch (FishId) {
                case 1:
                    mImage.setImageResource(R.drawable.bitterling);
                    break;
                case 2:
                    mImage.setImageResource(R.drawable.palechub);
                    break;
                case 3:
                    mImage.setImageResource(R.drawable.cruciancarp);
                    break;
                case 4:
                    mImage.setImageResource(R.drawable.dace);
                    break;
                case 5:
                    mImage.setImageResource(R.drawable.carp);
                    break;
                case 6:
                    mImage.setImageResource(R.drawable.koi);
                    break;
                case 7:
                    mImage.setImageResource(R.drawable.goldfish);
                    break;
                case 8:
                    mImage.setImageResource(R.drawable.popeyedgoldfish);
                    break;
                case 9:
                    mImage.setImageResource(R.drawable.ranchugoldfish);
                    break;
                case 10:
                    mImage.setImageResource(R.drawable.killifish);
                    break;
                case 11:
                    mImage.setImageResource(R.drawable.crawfish);
                    break;
                case 12:
                    mImage.setImageResource(R.drawable.softshelledturtle);
                    break;
                case 13:
                    mImage.setImageResource(R.drawable.snappingturtle);
                    break;
                case 14:
                    mImage.setImageResource(R.drawable.tadpole);
                    break;
                case 15:
                    mImage.setImageResource(R.drawable.frog);
                    break;
                case 16:
                    mImage.setImageResource(R.drawable.freshwatergoby);
                    break;
                case 17:
                    mImage.setImageResource(R.drawable.loach);
                    break;
                case 18:
                    mImage.setImageResource(R.drawable.catfish);
                    break;
                case 19:
                    mImage.setImageResource(R.drawable.giantsnakehead);
                    break;
                case 20:
                    mImage.setImageResource(R.drawable.bluegill);
                    break;
                case 21:
                    mImage.setImageResource(R.drawable.yellowperch);
                    break;
                case 22:
                    mImage.setImageResource(R.drawable.blackbass);
                    break;
                case 23:
                    mImage.setImageResource(R.drawable.tilapia);
                    break;
                case 24:
                    mImage.setImageResource(R.drawable.pike);
                    break;
                case 25:
                    mImage.setImageResource(R.drawable.pondsmelt);
                    break;
                case 26:
                    mImage.setImageResource(R.drawable.sweetfish);
                    break;
                case 27:
                    mImage.setImageResource(R.drawable.cherrysalmon);
                    break;
                case 28:
                    mImage.setImageResource(R.drawable.char_fish);
                    break;
                case 29:
                    mImage.setImageResource(R.drawable.goldentrout);
                    break;
                case 30:
                    mImage.setImageResource(R.drawable.stringfish);
                    break;
                case 31:
                    mImage.setImageResource(R.drawable.salmon);
                    break;
                case 32:
                    mImage.setImageResource(R.drawable.kingsalmon);
                    break;
                case 33:
                    mImage.setImageResource(R.drawable.mittencrab);
                    break;
                case 34:
                    mImage.setImageResource(R.drawable.guppy);
                    break;
                case 35:
                    mImage.setImageResource(R.drawable.nibblefish);
                    break;
                case 36:
                    mImage.setImageResource(R.drawable.angelfish);
                    break;
                case 37:
                    mImage.setImageResource(R.drawable.betta);
                    break;
                case 38:
                    mImage.setImageResource(R.drawable.neontetra);
                    break;
                case 39:
                    mImage.setImageResource(R.drawable.rainbowfish);
                    break;
                case 40:
                    mImage.setImageResource(R.drawable.piranha);
                    break;
                case 41:
                    mImage.setImageResource(R.drawable.arowana);
                    break;
                case 42:
                    mImage.setImageResource(R.drawable.dorado);
                    break;
                case 43:
                    mImage.setImageResource(R.drawable.gar);
                    break;
                case 44:
                    mImage.setImageResource(R.drawable.arapaima);
                    break;
                case 45:
                    mImage.setImageResource(R.drawable.saddledbichir);
                    break;
                case 46:
                    mImage.setImageResource(R.drawable.sturgeon);
                    break;
                case 47:
                    mImage.setImageResource(R.drawable.seabutterfly);
                    break;
                case 48:
                    mImage.setImageResource(R.drawable.seahorse);
                    break;
                case 49:
                    mImage.setImageResource(R.drawable.clownfish);
                    break;
                case 50:
                    mImage.setImageResource(R.drawable.surgeonfish);
                    break;
                case 51:
                    mImage.setImageResource(R.drawable.butterflyfish);
                    break;
                case 52:
                    mImage.setImageResource(R.drawable.napoleonfish);
                    break;
                case 53:
                    mImage.setImageResource(R.drawable.zebraturkeyfish);
                    break;
                case 54:
                    mImage.setImageResource(R.drawable.blowfish);
                    break;
                case 55:
                    mImage.setImageResource(R.drawable.pufferfish);
                    break;
                case 56:
                    mImage.setImageResource(R.drawable.anchovy);
                    break;
                case 57:
                    mImage.setImageResource(R.drawable.horsemackerel);
                    break;
                case 58:
                    mImage.setImageResource(R.drawable.barredknifejaw);
                    break;
                case 59:
                    mImage.setImageResource(R.drawable.seabass);
                    break;
                case 60:
                    mImage.setImageResource(R.drawable.redsnapper);
                    break;
                case 61:
                    mImage.setImageResource(R.drawable.dab);
                    break;
                case 62:
                    mImage.setImageResource(R.drawable.oliveflounder);
                    break;
                case 63:
                    mImage.setImageResource(R.drawable.squid);
                    break;
                case 64:
                    mImage.setImageResource(R.drawable.morayeel);
                    break;
                case 65:
                    mImage.setImageResource(R.drawable.ribboneel);
                    break;
                case 66:
                    mImage.setImageResource(R.drawable.tuna);
                    break;
                case 67:
                    mImage.setImageResource(R.drawable.bluemarlin);
                    break;
                case 68:
                    mImage.setImageResource(R.drawable.gianttrevally);
                    break;
                case 69:
                    mImage.setImageResource(R.drawable.mahimahi);
                    break;
                case 70:
                    mImage.setImageResource(R.drawable.oceansunfish);
                    break;
                case 71:
                    mImage.setImageResource(R.drawable.ray);
                    break;
                case 72:
                    mImage.setImageResource(R.drawable.sawshark);
                    break;
                case 73:
                    mImage.setImageResource(R.drawable.hammerheadshark);
                    break;
                case 74:
                    mImage.setImageResource(R.drawable.greatwhiteshark);
                    break;
                case 75:
                    mImage.setImageResource(R.drawable.whaleshark);
                    break;
                case 76:
                    mImage.setImageResource(R.drawable.suckerfish);
                    break;
                case 77:
                    mImage.setImageResource(R.drawable.footballfish);
                    break;
                case 78:
                    mImage.setImageResource(R.drawable.oarfish);
                    break;
                case 79:
                    mImage.setImageResource(R.drawable.barreleye);
                    break;
                case 80:
                    mImage.setImageResource(R.drawable.coelacanth);
                    break;

            }
        }

        private void setMonths(ArrayList<String> months) {
            mJanButton.setEnabled(false);
            mFebButton.setEnabled(false);
            mMarButton.setEnabled(false);
            mAprButton.setEnabled(false);
            mMayButton.setEnabled(false);
            mJunButton.setEnabled(false);
            mJulButton.setEnabled(false);
            mAugButton.setEnabled(false);
            mSepButton.setEnabled(false);
            mOctButton.setEnabled(false);
            mNovButton.setEnabled(false);
            mDecButton.setEnabled(false);
            if(!months.get(0).equals("all")){
                for(String month : months) {
                    switch (month) {
                        case "January":
                            mJanButton.setEnabled(true);
                            break;
                        case "February":
                            mFebButton.setEnabled(true);
                            break;
                        case "March":
                            mMarButton.setEnabled(true);
                            break;
                        case "April":
                            mAprButton.setEnabled(true);
                            break;
                        case "May":
                            mMayButton.setEnabled(true);
                            break;
                        case "June":
                            mJunButton.setEnabled(true);
                            break;
                        case "July":
                            mJulButton.setEnabled(true);
                            break;
                        case "August":
                            mAugButton.setEnabled(true);
                            break;
                        case "September":
                            mSepButton.setEnabled(true);
                            break;
                        case "October":
                            mOctButton.setEnabled(true);
                            break;
                        case "November":
                            mNovButton.setEnabled(true);
                            break;
                        case "December":
                            mDecButton.setEnabled(true);
                            break;

                    }
                }
            } else {
                mJanButton.setEnabled(true);
                mFebButton.setEnabled(true);
                mMarButton.setEnabled(true);
                mAprButton.setEnabled(true);
                mMayButton.setEnabled(true);
                mJunButton.setEnabled(true);
                mJulButton.setEnabled(true);
                mAugButton.setEnabled(true);
                mSepButton.setEnabled(true);
                mOctButton.setEnabled(true);
                mNovButton.setEnabled(true);
                mDecButton.setEnabled(true);
            }
        }
    }

    public interface CheckboxClicker {
        void onClicked(Fish fish);
    }
}
