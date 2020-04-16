package de.swankeymonkey.production.animalcrossing_checker.ui.main.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

import de.swankeymonkey.production.animalcrossing_checker.ui.main.adapters.AnimalRecyclerViewAdapter;
import de.swankeymonkey.production.animalcrossing_checker.ui.main.adapters.FishRecyclerViewAdapter;
import de.swankeymonkey.production.animalcrossing_checker.backend.models.Fish;
import de.swankeymonkey.production.animalcrossing_checker.backend.viewmodels.FishViewModel;

public class FishMissingFragment extends BaseFishFragment {
    private FishViewModel mViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FishViewModel.class);
    }

    @Override
    protected FishRecyclerViewAdapter.CheckboxClicker<Fish> setOnItemCheckListener() {
        return data -> {
            if(data.isCatched()) {
                data.setCatched(false);
            } else {
                data.setCatched(true);
            }
            mViewModel.updateFish(data, null);
        };
    }

    @Override
    protected void init(View view) {
        mViewModel.getMissingFish().observe(this, fish -> mAdapter.setData(fish));
    }

    @Override
    protected TextWatcher addTextListener() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mViewModel.searchFishAfterString(s.toString()).observe(FishMissingFragment.this, fishList -> mAdapter.setData(fishList));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
    }

    public static FishMissingFragment newInstance() {
        return new FishMissingFragment();
    }
}
