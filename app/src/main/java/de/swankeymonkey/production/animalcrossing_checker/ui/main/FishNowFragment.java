package de.swankeymonkey.production.animalcrossing_checker.ui.main;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.List;

import de.swankeymonkey.production.animalcrossing_checker.adapters.FishRecyclerViewAdapter;
import de.swankeymonkey.production.animalcrossing_checker.backend.models.Fish;
import de.swankeymonkey.production.animalcrossing_checker.backend.viewmodels.FishViewModel;
import de.swankeymonkey.production.animalcrossing_checker.utils.DateUtils;

public class FishNowFragment extends BaseListFragment {
    private FishViewModel mViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FishViewModel.class);
    }

    @Override
    void init(View view) {
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
    FishRecyclerViewAdapter.CheckboxClicker setOnItemCheckListener() {
        return new FishRecyclerViewAdapter.CheckboxClicker() {
            @Override
            public void onClicked(Fish fish) {
                if(fish.isCatched()) {
                    fish.setCatched(false);
                } else {
                    fish.setCatched(true);
                }
                mViewModel.updateFish(fish, null);
            }
        };
    }

    public static FishNowFragment newInstance() {
        Bundle args = new Bundle();
        FishNowFragment fragment = new FishNowFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
