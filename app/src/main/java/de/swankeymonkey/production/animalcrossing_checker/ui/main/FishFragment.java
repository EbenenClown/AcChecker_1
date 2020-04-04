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

/**
 * A placeholder fragment containing a simple view.
 */
public class FishFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
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
        mAdapter = new FishRecyclerViewAdapter(getContext());
        mViews.mRecyclerview.setAdapter(mAdapter);

        mFishViewModel.nukeTable();
        mFishViewModel.getAllFish().observe(getActivity(), new Observer<List<Fish>>() {
            @Override
            public void onChanged(List<Fish> fish) {
                mAdapter.setData(fish);
            }
        });

        new DatabasePopulaterTask(getContext()).execute();


        return view;
    }

    public static FishFragment newInstance() {
        FishFragment fragment = new FishFragment();
        return fragment;
    }

    public static class DatabasePopulaterTask extends AsyncTask<Void, Void, List<Fish>> {
        private Context mContext;

        public DatabasePopulaterTask(Context context) {
            mContext = context;
        }

        @Override
        protected List<Fish> doInBackground(Void... voids) {
            DatabaseCreateHelper dbHelper = new DatabaseCreateHelper(mContext);
            List<Fish> allFish = dbHelper.populateNorthernFishList();
            FishRepository repository = new FishRepository(mContext);
            for(Fish fish : allFish) {
                repository.saveNewFish(fish, null);
            }
            return allFish;
        }

        @Override
        protected void onPostExecute(List<Fish> fish) {
            super.onPostExecute(fish);

        }
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