package de.swankeymonkey.production.animalcrossing_checker.ui.main;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

import de.swankeymonkey.production.animalcrossing_checker.adapters.FishRecyclerViewAdapter;
import de.swankeymonkey.production.animalcrossing_checker.backend.models.Fish;
import de.swankeymonkey.production.animalcrossing_checker.backend.viewmodels.FishViewModel;

public class FishMissingFragment extends BaseListFragment {
    private FishViewModel mViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FishViewModel.class);
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

    @Override
    void init(View view) {
        mViewModel.getMissingFish().observe(this, new Observer<List<Fish>>() {
            @Override
            public void onChanged(List<Fish> fish) {
                mAdapter.setData(fish);
            }
        });
    }

    public static FishMissingFragment newInstance() {
        Bundle args = new Bundle();
        FishMissingFragment fragment = new FishMissingFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
