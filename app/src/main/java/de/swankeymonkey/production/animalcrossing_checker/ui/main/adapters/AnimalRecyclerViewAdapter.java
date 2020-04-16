package de.swankeymonkey.production.animalcrossing_checker.ui.main.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.swankeymonkey.production.animalcrossing_checker.MainActivity;
import de.swankeymonkey.production.animalcrossing_checker.R;
import de.swankeymonkey.production.animalcrossing_checker.backend.models.Animal;
import de.swankeymonkey.production.animalcrossing_checker.utils.AppSharedPreferences;
import static de.swankeymonkey.production.animalcrossing_checker.utils.Constants.*;

public abstract class AnimalRecyclerViewAdapter<T> extends RecyclerView.Adapter<AnimalRecyclerViewAdapter.AnimalViewHolder> {
    protected List<T> mData;
    protected Context mContext;
    protected CheckboxClicker<T> mListener;
    private MainActivity mParentActivity;
    protected abstract AnimalViewHolder setViewHolder(View view);

    private List<Integer> mPositionSaves;

    AnimalRecyclerViewAdapter(Context context, MainActivity parentActivity, CheckboxClicker<T> listener) {
        mContext = context;
        mListener = listener;
        mData = new ArrayList<>();
        mPositionSaves = new ArrayList<>();
        mParentActivity = parentActivity;
    }

    public void setData(List<T> data) {
        mData = data;
        notifyDataSetChanged();
    }

    public List<T> getData() {
        return mData;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.listitem_animal, parent, false);
        return setViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalRecyclerViewAdapter.AnimalViewHolder holder,final int position) {
        mParentActivity.showProgressbar(true);
        final boolean isExpanded = mPositionSaves.indexOf(position) != -1;
        if(AppSharedPreferences.isAlwaysExpanded(mContext)) {
            holder.mDetails.setVisibility(View.VISIBLE);
            holder.mExpander.setVisibility(View.GONE);
            holder.mLocationText.setVisibility(View.VISIBLE);
        } else {
            holder.itemView.setActivated(isExpanded);
            holder.mDetails.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
            holder.mLocationText.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
            holder.itemView.setOnClickListener(v -> {
                if(isExpanded) {
                    mPositionSaves.remove((Integer)position);
                } else {
                    mPositionSaves.add(position);
                }
                notifyDataSetChanged();
            });
        }
        final T data = mData.get(position);
        holder.mIsCatched.setOnClickListener(v -> mListener.onClicked(data));

        holder.bind((Animal) data);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public abstract class AnimalViewHolder extends RecyclerView.ViewHolder {
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
        @BindView(R.id.tvLocationText)
        TextView mLocationText;

        protected abstract void setImage(Animal animal);
        protected abstract void setLocation(Animal animal);
        protected abstract void setTime(Animal animal);

        AnimalViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(Animal animal) {
            mName.setText(animal.getName());
            mPrice.setText(mContext.getString(R.string.bells_string, String.valueOf(animal.getPrice())));
            mIsCatched.setChecked(animal.isCatched());
            if(animal.isCatched()) {
                itemView.setBackground(mContext.getResources().getDrawable(R.drawable.custom_listitem_background_checked));
            } else {
                itemView.setBackground(mContext.getResources().getDrawable(R.drawable.custom_listitem_background));
            }
            setMonths(animal.getMonths());
            setImage(animal);
            setLocation(animal);
            setTime(animal);
            mParentActivity.showProgressbar(false);
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
            if (!months.get(0).equals(ALL_DATE)) {
                if (AppSharedPreferences.getAppHemisphere(mContext) == 0) {
                    for (String month : months) {
                        switch (month) {
                            case JANUARY:
                                mJanButton.setEnabled(true);
                                break;
                            case FEBRUARY:
                                mFebButton.setEnabled(true);
                                break;
                            case MARCH:
                                mMarButton.setEnabled(true);
                                break;
                            case APRIL:
                                mAprButton.setEnabled(true);
                                break;
                            case MAY:
                                mMayButton.setEnabled(true);
                                break;
                            case JUNE:
                                mJunButton.setEnabled(true);
                                break;
                            case JULY:
                                mJulButton.setEnabled(true);
                                break;
                            case AUGUST:
                                mAugButton.setEnabled(true);
                                break;
                            case SEPTEMBER:
                                mSepButton.setEnabled(true);
                                break;
                            case OCTOBER:
                                mOctButton.setEnabled(true);
                                break;
                            case NOVEMBER:
                                mNovButton.setEnabled(true);
                                break;
                            case DECEMBER:
                                mDecButton.setEnabled(true);
                                break;
                        }
                    }
                } else {
                    for (String month : months) {
                        switch (month) {
                            case JANUARY:
                                mJulButton.setEnabled(true);
                                break;
                            case FEBRUARY:
                                mAugButton.setEnabled(true);
                                break;
                            case MARCH:
                                mSepButton.setEnabled(true);
                                break;
                            case APRIL:
                                mOctButton.setEnabled(true);
                                break;
                            case MAY:
                                mNovButton.setEnabled(true);
                                break;
                            case JUNE:
                                mDecButton.setEnabled(true);
                                break;
                            case JULY:
                                mJanButton.setEnabled(true);
                                break;
                            case AUGUST:
                                mFebButton.setEnabled(true);
                                break;
                            case SEPTEMBER:
                                mMarButton.setEnabled(true);
                                break;
                            case OCTOBER:
                                mAprButton.setEnabled(true);
                                break;
                            case NOVEMBER:
                                mMayButton.setEnabled(true);
                                break;
                            case DECEMBER:
                                mJunButton.setEnabled(true);
                                break;

                        }
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



    public interface CheckboxClicker<T> {
        void onClicked(T data);
    }

}
