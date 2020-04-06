package de.swankeymonkey.production.animalcrossing_checker.ui.main.fragments;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

import de.swankeymonkey.production.animalcrossing_checker.ui.main.adapters.AnimalRecyclerViewAdapter;
import de.swankeymonkey.production.animalcrossing_checker.ui.main.adapters.FishRecyclerViewAdapter;
import de.swankeymonkey.production.animalcrossing_checker.backend.models.Fish;
import de.swankeymonkey.production.animalcrossing_checker.backend.viewmodels.FishViewModel;

public class FishCatchedFragment extends BaseFishFragment {
    private FishViewModel mViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FishViewModel.class);
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
