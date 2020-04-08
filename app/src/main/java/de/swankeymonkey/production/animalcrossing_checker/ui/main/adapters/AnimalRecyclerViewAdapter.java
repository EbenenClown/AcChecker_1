package de.swankeymonkey.production.animalcrossing_checker.ui.main.adapters;

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
import de.swankeymonkey.production.animalcrossing_checker.R;
import de.swankeymonkey.production.animalcrossing_checker.backend.models.Animal;
import de.swankeymonkey.production.animalcrossing_checker.utils.AppSharedPreferences;

public abstract class AnimalRecyclerViewAdapter<T> extends RecyclerView.Adapter<AnimalRecyclerViewAdapter.AnimalViewHolder> {
    protected List<T> mData;
    protected Context mContext;
    protected CheckboxClicker<T> mListener;
    protected  abstract AnimalViewHolder setViewHolder(View view);

    private List<Integer> mPositionSaves;

    AnimalRecyclerViewAdapter(Context context, CheckboxClicker<T> listener) {
        mContext = context;
        mListener = listener;
        mData = new ArrayList<>();
        mPositionSaves = new ArrayList<>();
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
        View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_fish_listitem, parent, false);
        return setViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalRecyclerViewAdapter.AnimalViewHolder holder,final int position) {
        final boolean isExpanded = mPositionSaves.indexOf(position) != -1;
        if(AppSharedPreferences.isAlwaysExpanded(mContext)) {
            holder.mDetails.setVisibility(View.VISIBLE);
            holder.mExpander.setVisibility(View.GONE);
        } else {
            holder.itemView.setActivated(isExpanded);
            holder.mDetails.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(isExpanded) {
                        mPositionSaves.remove((Integer)position);
                    } else {
                        mPositionSaves.add(position);
                    }
                    notifyDataSetChanged();
                }
            });
        }
        final T data = mData.get(position);
        holder.mIsCatched.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClicked(data);
            }
        });

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

        protected abstract void setImage(Animal animal);
        protected abstract void setLocation(Animal animal);
        protected abstract void setTime(Animal animal);

        AnimalViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(Animal animal) {
            mName.setText(animal.getName());
            mPrice.setText(animal.getPrice() + " " + mContext.getString(R.string.bells_string));
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
            if (!months.get(0).equals("all")) {
                if (AppSharedPreferences.getAppHemisphere(mContext) == 0) {
                    for (String month : months) {
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
                    for (String month : months) {
                        switch (month) {
                            case "January":
                                mJulButton.setEnabled(true);
                                break;
                            case "February":
                                mAugButton.setEnabled(true);
                                break;
                            case "March":
                                mSepButton.setEnabled(true);
                                break;
                            case "April":
                                mOctButton.setEnabled(true);
                                break;
                            case "May":
                                mNovButton.setEnabled(true);
                                break;
                            case "June":
                                mDecButton.setEnabled(true);
                                break;
                            case "July":
                                mJanButton.setEnabled(true);
                                break;
                            case "August":
                                mFebButton.setEnabled(true);
                                break;
                            case "September":
                                mMarButton.setEnabled(true);
                                break;
                            case "October":
                                mAprButton.setEnabled(true);
                                break;
                            case "November":
                                mMayButton.setEnabled(true);
                                break;
                            case "December":
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
