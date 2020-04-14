package de.swankeymonkey.production.animalcrossing_checker.ui.main.fragments;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

import de.swankeymonkey.production.animalcrossing_checker.backend.models.Insect;
import de.swankeymonkey.production.animalcrossing_checker.backend.viewmodels.InsectViewModel;
import de.swankeymonkey.production.animalcrossing_checker.ui.main.adapters.AnimalRecyclerViewAdapter;
import de.swankeymonkey.production.animalcrossing_checker.utils.AppSharedPreferences;
import de.swankeymonkey.production.animalcrossing_checker.utils.Constants;
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
        mViewModel.getAllInsects().observe(this, insects -> {
            List<Insect> filteredList = new ArrayList<>();
            int currentMonth = AppSharedPreferences.getAppMonth(getContext()) == Constants.NO_MONTH_CHOSEN ? new DateTime().getMonthOfYear() : AppSharedPreferences.getAppMonth(getContext()) + 1;
            for(Insect f : insects) {
                if(DateUtils.isInDate(getContext(), currentMonth, f.getMonths())) {
                    filteredList.add(f);
                }
            }
            mAdapter.setData(filteredList);
        });
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

    public static InsectTodayFragment newInstance() {
       return new InsectTodayFragment();
    }
}
