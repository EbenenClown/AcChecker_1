package de.swankeymonkey.production.animalcrossing_checker.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
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

    public FishRecyclerViewAdapter(Context context) {
        mFishList = new ArrayList<>();
        mContext = context;
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
    public void onBindViewHolder(@NonNull FishViewHolder holder, int position) {
        Fish fish = mFishList.get(position);
        holder.bind(fish);
    }

    @Override
    public int getItemCount() {
        return mFishList.size();
    }

    public class FishViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvName)
        TextView mName;
        @BindView(R.id.tvLocation)
        TextView mLocation;
        @BindView(R.id.tvPrice)
        TextView mPrice;
        @BindView(R.id.tvMonths)
        TextView mMonths;
        @BindView(R.id.tvTime)
        TextView mTime;
        @BindView(R.id.tvIsCatched)
        TextView mIsCatched;

        public FishViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(Fish fish) {
            mName.setText(fish.getName());
            mLocation.setText(FishLocation.getString(fish.getLocation(), mContext));
            mPrice.setText(String.valueOf(fish.getPrice()));
            mMonths.setText(fish.getMonths().toString());
            mTime.setText(FishTime.getTimeString(fish.getTime(), mContext));
            mIsCatched.setText(fish.isCatched() ? "catched" : "not catched");
        }
    }
}
