package de.swankeymonkey.production.animalcrossing_checker.ui.main.fragments;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.List;

import de.swankeymonkey.production.animalcrossing_checker.backend.models.Insect;
import de.swankeymonkey.production.animalcrossing_checker.backend.viewmodels.InsectViewModel;
import de.swankeymonkey.production.animalcrossing_checker.ui.main.adapters.AnimalRecyclerViewAdapter;
import de.swankeymonkey.production.animalcrossing_checker.utils.DateUtils;

public class InsectTodayFragment extends BaseInsectFragment {
    private InsectViewModel mViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(InsectViewModel.class);
    }

    @Override
    protected void init(View view) {
        mViewModel.getAllInsects().observe(this, new Observer<List<Insect>>() {
            @Override
            public void onChanged(List<Insect> insects) {
                List<Insect> filteredList = new ArrayList<>();
                for(Insect f : insects) {
                    if(DateUtils.isInDate(f.getMonths())) {
                        filteredList.add(f);
                    }
                }
                mAdapter.setData(filteredList);
            }
        });
    }

    @Override
    protected AnimalRecyclerViewAdapter.CheckboxClicker<Insect> initCheckboxListener() {
        return new AnimalRecyclerViewAdapter.CheckboxClicker<Insect>() {
            @Override
            public void onClicked(Insect animal) {
                if(animal.isCatched()) {
                    animal.setCatched(false);
                } else {
                    animal.setCatched(true);
                }
                mViewModel.updateInsect(animal, null);
            }
        };
    }

    public static InsectTodayFragment newInstance() {
       return new InsectTodayFragment();
    }
}
