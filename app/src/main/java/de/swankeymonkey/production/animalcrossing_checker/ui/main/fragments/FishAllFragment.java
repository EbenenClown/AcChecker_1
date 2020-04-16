package de.swankeymonkey.production.animalcrossing_checker.ui.main.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ProgressBar;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

import de.swankeymonkey.production.animalcrossing_checker.R;
import de.swankeymonkey.production.animalcrossing_checker.ui.main.adapters.AnimalRecyclerViewAdapter;
import de.swankeymonkey.production.animalcrossing_checker.ui.main.adapters.FishRecyclerViewAdapter;
import de.swankeymonkey.production.animalcrossing_checker.backend.models.Fish;
import de.swankeymonkey.production.animalcrossing_checker.backend.viewmodels.FishViewModel;

public class FishAllFragment extends BaseFishFragment {
    private FishViewModel mViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FishViewModel.class);
    }


    @Override
    protected void init(View view) {
        final ProgressBar progressBar = getActivity().findViewById(R.id.progessBar);
        mViewModel.getAllFish().observe(getActivity(), fish -> {
            mAdapter.setData(fish);
            progressBar.setVisibility(View.GONE);
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
    protected TextWatcher addTextListener() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String sb = "%" + s + '%';
                mViewModel.searchFishAfterString(sb).observe(FishAllFragment.this, fishList -> mAdapter.setData(fishList));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
    }

    public static FishAllFragment newInstance() {
        return new FishAllFragment();
    }
}