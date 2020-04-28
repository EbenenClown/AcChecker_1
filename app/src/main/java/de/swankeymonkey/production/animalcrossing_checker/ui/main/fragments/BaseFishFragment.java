package de.swankeymonkey.production.animalcrossing_checker.ui.main.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.swankeymonkey.production.animalcrossing_checker.MainActivity;
import de.swankeymonkey.production.animalcrossing_checker.R;
import de.swankeymonkey.production.animalcrossing_checker.SettingsActivity;
import de.swankeymonkey.production.animalcrossing_checker.backend.models.Fish;
import de.swankeymonkey.production.animalcrossing_checker.ui.main.adapters.FishRecyclerViewAdapter;

public abstract class BaseFishFragment extends Fragment {
    private static final int NOT_SELECTED = 0;
    private static final int DOWN_SELECTED = 1;
    private static final int UP_SELECTED = 2;

    //
    private Menu mMenu;
    protected ViewHolder mViews;
    protected FishRecyclerViewAdapter mAdapter;
    protected abstract String[] generateIds();
    protected abstract void init(View view);
    protected abstract FishRecyclerViewAdapter.CheckboxClicker<Fish> setOnItemCheckListener();
    private int selected = NOT_SELECTED;
    private int sortNameMode = NOT_SELECTED;
    private int sortPriceMode = NOT_SELECTED;
    private String[] savedInstanceId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        savedInstanceId = generateIds();
        if(savedInstanceState != null) {
            selected = savedInstanceState.getInt(savedInstanceId[0]);
            sortNameMode = savedInstanceState.getInt(savedInstanceId[1]);
            sortPriceMode = savedInstanceState.getInt(savedInstanceId[2]);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(savedInstanceId[0], selected);
        outState.putInt(savedInstanceId[1], sortNameMode);
        outState.putInt(savedInstanceId[2], sortPriceMode);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_filter, menu);
        mMenu = menu;
        switch(selected) {
            case R.id.menuOrderByName:
                if(sortNameMode == DOWN_SELECTED) {
                    mMenu.findItem(R.id.menuOrderByName).setIcon(R.drawable.ic_arrow_downward_white_24dp);
                } else {
                    mMenu.findItem(R.id.menuOrderByName).setIcon(R.drawable.ic_arrow_upward_black_24dp);
                }
                mMenu.findItem(R.id.menuDefaultOrder).setVisible(true);
                mAdapter.setData(orderByName(mAdapter.getData()));
                break;

            case R.id.menuOrderByPrice:
                if(sortPriceMode == DOWN_SELECTED) {
                    mMenu.findItem(R.id.menuOrderByPrice).setIcon(R.drawable.ic_arrow_downward_white_24dp);
                } else {
                    mMenu.findItem(R.id.menuOrderByPrice).setIcon(R.drawable.ic_arrow_upward_black_24dp);
                }
                mMenu.findItem(R.id.menuDefaultOrder).setVisible(true);
                mAdapter.setData(orderByPrice(mAdapter.getData()));
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuOrderByName:
                selected = R.id.menuOrderByName;
                if(sortNameMode == NOT_SELECTED || sortNameMode == DOWN_SELECTED) {
                    item.setIcon(R.drawable.ic_arrow_upward_black_24dp);
                    mMenu.findItem(R.id.menuOrderByPrice).setIcon(null);
                    sortNameMode = UP_SELECTED;
                    sortPriceMode = NOT_SELECTED;
                } else {
                    item.setIcon(R.drawable.ic_arrow_downward_white_24dp);
                    mMenu.findItem(R.id.menuOrderByPrice).setIcon(null);
                    sortNameMode = DOWN_SELECTED;
                    sortPriceMode = NOT_SELECTED;
                }
                mAdapter.setData(orderByName(mAdapter.getData()));
                mMenu.findItem(R.id.menuDefaultOrder).setVisible(true);
                break;

            case R.id.menuOrderByPrice:
                selected = R.id.menuOrderByPrice;
                if(sortPriceMode == NOT_SELECTED || sortPriceMode == DOWN_SELECTED) {
                    item.setIcon(R.drawable.ic_arrow_upward_black_24dp);
                    mMenu.findItem(R.id.menuOrderByName).setIcon(null);
                    sortPriceMode = UP_SELECTED;
                    sortNameMode = NOT_SELECTED;
                } else {
                    item.setIcon(R.drawable.ic_arrow_downward_white_24dp);
                    mMenu.findItem(R.id.menuOrderByName).setIcon(null);
                    sortPriceMode = DOWN_SELECTED;
                    sortNameMode = NOT_SELECTED;
                }
                mAdapter.setData(orderByPrice(mAdapter.getData()));
                mMenu.findItem(R.id.menuDefaultOrder).setVisible(true);
                break;

            case R.id.menuDefaultOrder:
                selected = NOT_SELECTED;
                sortPriceMode = NOT_SELECTED;
                sortNameMode = NOT_SELECTED;
                mAdapter.setData(orderByDefault(mAdapter.getData()));
                mMenu.findItem(R.id.menuOrderByName).setIcon(null);
                mMenu.findItem(R.id.menuOrderByPrice).setIcon(null);
                mMenu.findItem(R.id.menuDefaultOrder).setVisible(false);
                break;

            case R.id.menuSettings:
                Intent intent = new Intent(getActivity(), SettingsActivity.class);
                startActivity(intent);
                getActivity().finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        mViews = new ViewHolder(view);
        mAdapter = new FishRecyclerViewAdapter(getContext(), (MainActivity) getActivity(), setOnItemCheckListener());
        mViews.mRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        mViews.mRecyclerview.setAdapter(mAdapter);
        init(view);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMenu = null;
    }

    protected List<Fish> orderByPrice(List<Fish> fishList) {
        if(sortPriceMode == DOWN_SELECTED) {
            Collections.sort(fishList, (o1, o2) -> Integer.compare(o1.getPrice(), o2.getPrice()));
            return fishList;
        } else {
            Collections.sort(fishList, (o1, o2) -> Integer.compare(o2.getPrice(), o1.getPrice()));
            return fishList;
        }
    }

    protected List<Fish> orderByName(List<Fish> fishList) {
        if(sortNameMode == DOWN_SELECTED) {
            Collections.sort(fishList, (o1, o2) -> o2.getName().compareToIgnoreCase(o1.getName()));
            return fishList;
        } else {
            Collections.sort(fishList, (o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
            return fishList;
        }

    }

    protected List<Fish> orderByDefault(List<Fish> fishList) {
        Collections.sort(fishList, (o1, o2) -> Integer.compare(o1.getId(), o2.getId()));
        return fishList;
    }

    protected void applyFilter() {
        if(sortPriceMode > 0) {
            mAdapter.setData(orderByPrice(mAdapter.getData()));
        } else if(sortNameMode > 0) {
            mAdapter.setData(orderByName(mAdapter.getData()));
        }
    }

    public static class ViewHolder {
        @BindView(R.id.recyclerview_main)
        RecyclerView mRecyclerview;
        Unbinder mUnbinder;

        public ViewHolder(View view) {
            mUnbinder = ButterKnife.bind(this, view);
        }
    }
}
