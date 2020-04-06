package de.swankeymonkey.production.animalcrossing_checker.ui.main.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.swankeymonkey.production.animalcrossing_checker.R;
import de.swankeymonkey.production.animalcrossing_checker.backend.models.Fish;
import de.swankeymonkey.production.animalcrossing_checker.ui.main.adapters.FishRecyclerViewAdapter;

public abstract class BaseListFragment extends Fragment {
    protected ViewHolder mViews;
    protected FishRecyclerViewAdapter mAdapter;
    protected abstract void init(View view);
    protected abstract FishRecyclerViewAdapter.CheckboxClicker setOnItemCheckListener();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_filter, menu);

    }

    @Override
    public void onPrepareOptionsMenu(@NonNull Menu menu) {
        super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuOrderByName:
                mAdapter.setData(orderByName(mAdapter.getData()));
                break;
            case R.id.menuOrderByPrice:
                mAdapter.setData(orderByPrice(mAdapter.getData()));
                break;
            case R.id.menuDefaultOrder:
                mAdapter.setData(orderByDefault(mAdapter.getData()));
                break;
        }
        return super.onOptionsItemSelected(item);
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

    protected List<Fish> orderByPrice(List<Fish> fishList) {
        Collections.sort(fishList, new Comparator<Fish>() {
            @Override
            public int compare(Fish o1, Fish o2) {
                return Integer.compare(o2.getPrice(), o1.getPrice());
            }
        });
        return fishList;
    }

    protected List<Fish> orderByName(List<Fish> fishList) {
        Collections.sort(fishList, new Comparator<Fish>() {
            @Override
            public int compare(Fish o1, Fish o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        return fishList;
    }

    protected List<Fish> orderByDefault(List<Fish> fishList) {
        Collections.sort(fishList, new Comparator<Fish>() {
            @Override
            public int compare(Fish o1, Fish o2) {
                return Integer.compare(o1.getId(), o2.getId());
            }
        });
        return fishList;
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
