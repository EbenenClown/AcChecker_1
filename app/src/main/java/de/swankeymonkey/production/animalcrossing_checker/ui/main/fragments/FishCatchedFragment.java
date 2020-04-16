package de.swankeymonkey.production.animalcrossing_checker.ui.main.fragments;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

import de.swankeymonkey.production.animalcrossing_checker.MainActivity;
import de.swankeymonkey.production.animalcrossing_checker.ui.main.adapters.AnimalRecyclerViewAdapter;
import de.swankeymonkey.production.animalcrossing_checker.ui.main.adapters.FishRecyclerViewAdapter;
import de.swankeymonkey.production.animalcrossing_checker.backend.models.Fish;
import de.swankeymonkey.production.animalcrossing_checker.backend.viewmodels.FishViewModel;

public class FishCatchedFragment extends BaseFishFragment {
    private static final String SELECTED_MENU = "selectedMenuFish" + FishCatchedFragment.class.getSimpleName();
    private static final String SORTED_PRICE = "isSortedPriceFish" + FishCatchedFragment.class.getSimpleName();
    private static final String SORTED_NAME = "isSortedNameFish" + FishCatchedFragment.class.getSimpleName();

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
        mViewModel.getCatchedFish().observe(this, fish -> mAdapter.setData(fish));
        applyFilter();
    }

    @Override
    protected String[] generateIds() {
        String[] ids = {SELECTED_MENU, SORTED_NAME, SORTED_PRICE};
        return ids;
    }

    public static FishCatchedFragment newInstance() {
        return new FishCatchedFragment();
    }
}
