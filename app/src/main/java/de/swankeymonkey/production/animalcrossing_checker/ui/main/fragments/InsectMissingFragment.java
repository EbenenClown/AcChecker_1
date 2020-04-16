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

public class InsectMissingFragment extends BaseInsectFragment {
    private static final String SELECTED_MENU = "selectedMenuFish" + InsectMissingFragment.class.getSimpleName();
    private static final String SORTED_PRICE = "isSortedPriceFish" + InsectMissingFragment.class.getSimpleName();
    private static final String SORTED_NAME = "isSortedNameFish" + InsectMissingFragment.class.getSimpleName();
    
    private InsectViewModel mViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(InsectViewModel.class);
    }

    @Override
    protected void init(View view) {
        mViewModel.getMissingInsects().observe(this, insects -> mAdapter.setData(insects));
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

    public static InsectMissingFragment newInstance() {
        return new InsectMissingFragment();
    }
}
