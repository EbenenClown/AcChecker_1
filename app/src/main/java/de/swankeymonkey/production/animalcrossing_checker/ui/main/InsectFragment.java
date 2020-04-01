package de.swankeymonkey.production.animalcrossing_checker.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.swankeymonkey.production.animalcrossing_checker.R;
import de.swankeymonkey.production.animalcrossing_checker.backend.enums.InsectLocation;
import de.swankeymonkey.production.animalcrossing_checker.backend.enums.InsectTime;
import de.swankeymonkey.production.animalcrossing_checker.backend.models.Insect;
import de.swankeymonkey.production.animalcrossing_checker.backend.viewmodels.InsectViewModel;

public class InsectFragment extends Fragment {
    private ViewHolder mViews;
    private InsectViewModel mViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(InsectViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_insect, container, false);
        mViews = new ViewHolder(view);
        Insect insect = new Insect();
        insect.setName("Common Butterfly");
        insect.setPrice(160);
        insect.setLocation(InsectLocation.FLYING);
        insect.setTime(InsectTime.t4am_7pm);

        ArrayList<String> months = new ArrayList<>();
        months.add(getString(R.string.Jan));
        months.add(getString(R.string.Feb));
        months.add(getString(R.string.Mar));
        months.add(getString(R.string.May));
        months.add(getString(R.string.Jun));
        months.add(getString(R.string.Sep));
        months.add(getString(R.string.Oct));
        months.add(getString(R.string.Nov));
        months.add(getString(R.string.Dec));
        insect.setMonths(months);

        mViewModel.saveNewInsect(insect, null);

        return view;
    }

    public static InsectFragment newInstance() {
        return new InsectFragment();
    }

    public class ViewHolder {
        @BindView(R.id.recyclerview_insects)
        RecyclerView mRecyclerView;
        Unbinder mUnbinder;

        public ViewHolder(View view) {
            mUnbinder = ButterKnife.bind(this, view);
        }
    }
}
