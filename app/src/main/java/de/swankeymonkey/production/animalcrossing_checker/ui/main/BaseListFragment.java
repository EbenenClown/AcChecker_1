package de.swankeymonkey.production.animalcrossing_checker.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.swankeymonkey.production.animalcrossing_checker.R;
import de.swankeymonkey.production.animalcrossing_checker.adapters.FishRecyclerViewAdapter;

public abstract class BaseListFragment extends Fragment {
    protected ViewHolder mViews;
    protected FishRecyclerViewAdapter mAdapter;
    abstract void init(View view);
    abstract FishRecyclerViewAdapter.CheckboxClicker setOnItemCheckListener();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        mViews = new ViewHolder(view);
        mAdapter = new FishRecyclerViewAdapter(getContext(), setOnItemCheckListener());
        mViews.mRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        mViews.mRecyclerview.setAdapter(mAdapter);
        init(view);
        return view;
    }

    public static class ViewHolder {
        @BindView(R.id.recyclerview_main)
        RecyclerView mRecyclerview;
        Unbinder mUnbinder;

        public ViewHolder(View view) {
            mUnbinder = ButterKnife.bind(this, view);
        }
    }
}
