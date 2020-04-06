package de.swankeymonkey.production.animalcrossing_checker.ui.main.fragments;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

import de.swankeymonkey.production.animalcrossing_checker.ui.main.adapters.FishRecyclerViewAdapter;
import de.swankeymonkey.production.animalcrossing_checker.backend.models.Fish;
import de.swankeymonkey.production.animalcrossing_checker.backend.viewmodels.FishViewModel;

public class FishCatchedFragment extends BaseListFragment {
    private FishViewModel mViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FishViewModel.class);
    }

    @Override
    protected FishRecyclerViewAdapter.CheckboxClicker setOnItemCheckListener() {
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

    @Override
    protected void init(View view) {
        mViewModel.getCatchedFish().observe(this, new Observer<List<Fish>>() {
            @Override
            public void onChanged(List<Fish> fish) {
                mAdapter.setData(fish);
            }
        });
    }

    public static FishCatchedFragment newInstance() {
        Bundle args = new Bundle();
        FishCatchedFragment fragment = new FishCatchedFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
