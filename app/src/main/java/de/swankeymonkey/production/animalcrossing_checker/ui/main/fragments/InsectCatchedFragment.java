package de.swankeymonkey.production.animalcrossing_checker.ui.main.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.swankeymonkey.production.animalcrossing_checker.R;
import de.swankeymonkey.production.animalcrossing_checker.backend.models.Insect;
import de.swankeymonkey.production.animalcrossing_checker.backend.viewmodels.InsectViewModel;
import de.swankeymonkey.production.animalcrossing_checker.ui.main.adapters.AnimalRecyclerViewAdapter;

public class InsectCatchedFragment extends BaseInsectFragment {
    private InsectViewModel mViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(InsectViewModel.class);
    }

    @Override
    protected void init(View view) {
        mViewModel.getCatchedInsects().observe(this, new Observer<List<Insect>>() {
            @Override
            public void onChanged(List<Insect> insects) {
                mAdapter.setData(insects);
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

    public static InsectCatchedFragment newInstance() {
        return new InsectCatchedFragment();
    }
}