package de.swankeymonkey.production.animalcrossing_checker.ui.main.fragments;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

import de.swankeymonkey.production.animalcrossing_checker.backend.models.Insect;
import de.swankeymonkey.production.animalcrossing_checker.backend.viewmodels.InsectViewModel;
import de.swankeymonkey.production.animalcrossing_checker.ui.main.adapters.AnimalRecyclerViewAdapter;

public class InsectAllFragment extends BaseInsectFragment {
    private static final String SELECTED_MENU = "selectedMenuFish" + InsectAllFragment.class.getSimpleName();
    private static final String SORTED_PRICE = "isSortedPriceFish" + InsectAllFragment.class.getSimpleName();
    private static final String SORTED_NAME = "isSortedNameFish" + InsectAllFragment.class.getSimpleName();
    
    private InsectViewModel mViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(InsectViewModel.class);
    }

    @Override
    protected void init(View view) {
        mViewModel.getAllInsects().observe(this, insects -> mAdapter.setData(insects));
        applyFilter();
    }

    @Override
    protected AnimalRecyclerViewAdapter.CheckboxClicker<Insect> initCheckboxListener() {
        return animal -> {
            if(animal.isCatched()) {
                animal.setCatched(false);
            } else {
                animal.setCatched(true);
            }
            mViewModel.updateInsect(animal, null);
        };
    }

    @Override
    protected String[] generateIds() {
        String[] ids = {SELECTED_MENU, SORTED_NAME, SORTED_PRICE};
        return ids;
    }

    public static InsectAllFragment newInstance() {
        return new InsectAllFragment();
    }
}
