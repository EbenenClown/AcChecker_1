package de.swankeymonkey.production.animalcrossing_checker.ui.main;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
import de.swankeymonkey.production.animalcrossing_checker.adapters.FishRecyclerViewAdapter;
import de.swankeymonkey.production.animalcrossing_checker.backend.database.DatabaseCreateHelper;
import de.swankeymonkey.production.animalcrossing_checker.backend.enums.FishLocation;
import de.swankeymonkey.production.animalcrossing_checker.backend.models.Fish;
import de.swankeymonkey.production.animalcrossing_checker.backend.repositories.FishRepository;
import de.swankeymonkey.production.animalcrossing_checker.backend.viewmodels.FishViewModel;

public class FishFragment extends Fragment {
    private FishViewModel mFishViewModel;
    private ViewHolder mViews;
    private FishRecyclerViewAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFishViewModel = new ViewModelProvider(this).get(FishViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fish, container, false);
        mViews = new ViewHolder(view);
        mViews.mRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new FishRecyclerViewAdapter(getContext(), new FishRecyclerViewAdapter.CheckboxClicker() {
            @Override
            public void onClicked(Fish fish) {
                if(fish.isCatched()) {
                    fish.setCatched(false);
                } else {
                    fish.setCatched(true);
                }
                mFishViewModel.updateFish(fish, null);
            }
        });
        mViews.mRecyclerview.setAdapter(mAdapter);

        mFishViewModel.getAllFish().observe(getActivity(), new Observer<List<Fish>>() {
            @Override
            public void onChanged(List<Fish> fish) {
                mAdapter.setData(fish);
            }
        });

        return view;
    }

    public static FishFragment newInstance() {
        FishFragment fragment = new FishFragment();
        return fragment;
    }



    public class ViewHolder {
        @BindView(R.id.recyclerview_main)
        RecyclerView mRecyclerview;
        Unbinder mUnbinder;

        public ViewHolder(View view) {
            mUnbinder = ButterKnife.bind(this, view);
        }
    }

}