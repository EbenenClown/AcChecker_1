package de.swankeymonkey.production.animalcrossing_checker.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.Arrays;

import de.swankeymonkey.production.animalcrossing_checker.R;
import de.swankeymonkey.production.animalcrossing_checker.backend.database.GenericDbTask;
import de.swankeymonkey.production.animalcrossing_checker.backend.enums.FishLocation;
import de.swankeymonkey.production.animalcrossing_checker.backend.enums.FishTime;
import de.swankeymonkey.production.animalcrossing_checker.backend.models.Fish;
import de.swankeymonkey.production.animalcrossing_checker.backend.viewmodels.FishViewModel;
import de.swankeymonkey.production.animalcrossing_checker.backend.viewmodels.InsectViewModel;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    private FishViewModel mFishViewModel;
    private InsectViewModel insectViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFishViewModel = new ViewModelProvider(this).get(FishViewModel.class);
        insectViewModel = new ViewModelProvider(this).get(InsectViewModel.class);
}

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        Fish fish = new Fish();
        fish.setName("Bitterling");
        fish.setPrice(900);
        fish.setLocation(FishLocation.RIVER);
        fish.setTime(FishTime.ALL_DAY);

        String[] stringArray = {getString(R.string.Jan), getString(R.string.Feb), getString(R.string.Mar), getString(R.string.Nov), getString(R.string.Dec)};
        ArrayList<String> months = new ArrayList<String>(Arrays.asList(stringArray));
        fish.setMonths(months);

        mFishViewModel.saveNewFish(fish, new GenericDbTask.DbCallback<Fish>() {
            @Override
            public void onFinsh(Fish data) {
                Log.d("db", "onFinsh: baasssst");
            }
        });

        return root;
    }

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

}