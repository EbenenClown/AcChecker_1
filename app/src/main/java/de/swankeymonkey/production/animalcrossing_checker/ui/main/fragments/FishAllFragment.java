package de.swankeymonkey.production.animalcrossing_checker.ui.main.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

import de.swankeymonkey.production.animalcrossing_checker.MainActivity;
import de.swankeymonkey.production.animalcrossing_checker.R;
import de.swankeymonkey.production.animalcrossing_checker.ui.main.adapters.AnimalRecyclerViewAdapter;
import de.swankeymonkey.production.animalcrossing_checker.ui.main.adapters.FishRecyclerViewAdapter;
import de.swankeymonkey.production.animalcrossing_checker.backend.models.Fish;
import de.swankeymonkey.production.animalcrossing_checker.backend.viewmodels.FishViewModel;

public class FishAllFragment extends BaseFishFragment {
    private static final String SELECTED_MENU = "selectedMenuFish" + FishAllFragment.class.getSimpleName();
    private static final String SORTED_PRICE = "isSortedPriceFish" + FishAllFragment.class.getSimpleName();
    private static final String SORTED_NAME = "isSortedNameFish" + FishAllFragment.class.getSimpleName();

    private FishViewModel mViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FishViewModel.class);
    }


    @Override
    protected void init(View view) {
        mViewModel.getAllFish().observe(getActivity(), fish -> {
            mAdapter.setData(fish);
            applyFilter();
        });

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
    protected String[] generateIds() {
        String[] ids = {SELECTED_MENU, SORTED_NAME, SORTED_PRICE};
        return ids;
    }

    public static FishAllFragment newInstance() {
        return new FishAllFragment();
    }
}