package de.swankeymonkey.production.animalcrossing_checker.ui.main.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.swankeymonkey.production.animalcrossing_checker.R;
import de.swankeymonkey.production.animalcrossing_checker.ui.main.adapters.FishRecyclerViewAdapter;
import de.swankeymonkey.production.animalcrossing_checker.backend.models.Fish;
import de.swankeymonkey.production.animalcrossing_checker.backend.viewmodels.FishViewModel;

public class FishAllFragment extends BaseListFragment {
    private FishViewModel mFishViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFishViewModel = new ViewModelProvider(this).get(FishViewModel.class);
    }


    @Override
    protected void init(View view) {
        final ProgressBar progressBar = getActivity().findViewById(R.id.progessBar);
        mFishViewModel.getAllFish().observe(getActivity(), new Observer<List<Fish>>() {
            @Override
            public void onChanged(List<Fish> fish) {
                mAdapter.setData(fish);
                progressBar.setVisibility(View.GONE);
            }
        });

    }

    @Override
    protected FishRecyclerViewAdapter.CheckboxClicker setOnItemCheckListener() {
        return new FishRecyclerViewAdapter.CheckboxClicker() {
            @Override
            public void onClicked(Fish fish) {
                if(fish.isCatched()) {
                    fish.setCatched(false);
                } else {
                    fish.setCatched(true);
                }
                mFishViewModel.updateFish(fish, null);
            }
        };
    }

    public static FishAllFragment newInstance() {
        FishAllFragment fragment = new FishAllFragment();
        return fragment;
    }
}