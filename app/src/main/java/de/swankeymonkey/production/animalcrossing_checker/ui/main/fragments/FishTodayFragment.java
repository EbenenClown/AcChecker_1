package de.swankeymonkey.production.animalcrossing_checker.ui.main.fragments;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.List;

import de.swankeymonkey.production.animalcrossing_checker.ui.main.adapters.AnimalRecyclerViewAdapter;
import de.swankeymonkey.production.animalcrossing_checker.ui.main.adapters.FishRecyclerViewAdapter;
import de.swankeymonkey.production.animalcrossing_checker.backend.models.Fish;
import de.swankeymonkey.production.animalcrossing_checker.backend.viewmodels.FishViewModel;
import de.swankeymonkey.production.animalcrossing_checker.utils.DateUtils;

public class FishTodayFragment extends BaseFishFragment {
    private FishViewModel mViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FishViewModel.class);
    }

    @Override
    protected void init(View view) {
        mViewModel.getAllFish().observe(this, new Observer<List<Fish>>() {
            @Override
            public void onChanged(List<Fish> fish) {
                List<Fish> filteredList = new ArrayList<>();
                for(Fish f : fish) {
                    if(DateUtils.isInDate(f.getMonths())) {
                       filteredList.add(f);
                    }
                }
                mAdapter.setData(filteredList);
            }
        });
    }

    @Override
    protected FishRecyclerViewAdapter.CheckboxClicker<Fish> setOnItemCheckListener() {
        return new AnimalRecyclerViewAdapter.CheckboxClicker<Fish>() {
            @Override
            public void onClicked(Fish data) {
                if(data.isCatched()) {
                    data.setCatched(false);
                } else {
                    data.setCatched(true);
                }
                mViewModel.updateFish(data, null);
            }
        };
    }

    public static FishTodayFragment newInstance() {
        Bundle args = new Bundle();
        FishTodayFragment fragment = new FishTodayFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
