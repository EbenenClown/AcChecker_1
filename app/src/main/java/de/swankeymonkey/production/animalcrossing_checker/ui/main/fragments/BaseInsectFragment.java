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
import de.swankeymonkey.production.animalcrossing_checker.R;
import de.swankeymonkey.production.animalcrossing_checker.SettingsActivity;
import de.swankeymonkey.production.animalcrossing_checker.backend.models.Insect;
import de.swankeymonkey.production.animalcrossing_checker.ui.main.adapters.AnimalRecyclerViewAdapter;
import de.swankeymonkey.production.animalcrossing_checker.ui.main.adapters.InsectRecyclerViewAdapter;

public abstract class BaseInsectFragment extends Fragment {
    private static final int NOT_SELECTED = -1;
    private static final int DOWN_SELECTED = 1;
    private static final int UP_SELECTED = 2;

    private static final String SELECTED_MENU = "selectedMenuBug";
    private static final String SORTED_PRICE = "isSortedPriceBug";
    private static final String SORTED_NAME = "isSortedNameBug";

    private Menu mMenu;
    protected BaseInsectFragment.ViewHolder mViews;
    protected InsectRecyclerViewAdapter mAdapter;
    protected abstract void init(View view);
    protected abstract AnimalRecyclerViewAdapter.CheckboxClicker<Insect> initCheckboxListener();
    private int selected = NOT_SELECTED;
    private int sortNameMode = NOT_SELECTED;
    private int sortPriceMode = NOT_SELECTED;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if(savedInstanceState != null) {
            selected = savedInstanceState.getInt(SELECTED_MENU);
            sortNameMode = savedInstanceState.getInt(SORTED_NAME);
            sortPriceMode = savedInstanceState.getInt(SORTED_PRICE);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(SELECTED_MENU, selected);
        outState.putInt(SORTED_NAME, sortNameMode);
        outState.putInt(SORTED_PRICE, sortPriceMode);
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
                if(sortPriceMode == 1) {
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
    public void onDestroy() {
        super.onDestroy();
        mMenu = null;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuOrderByName:
                selected = R.id.menuOrderByName;
                if(sortNameMode == NOT_SELECTED || sortNameMode == UP_SELECTED) {
                    item.setIcon(R.drawable.ic_arrow_downward_white_24dp);
                    mMenu.findItem(R.id.menuOrderByPrice).setIcon(null);
                    sortNameMode = DOWN_SELECTED;
                } else {
                    item.setIcon(R.drawable.ic_arrow_upward_black_24dp);
                    mMenu.findItem(R.id.menuOrderByPrice).setIcon(null);
                    sortNameMode = UP_SELECTED;
                }
                mAdapter.setData(orderByName(mAdapter.getData()));
                mMenu.findItem(R.id.menuDefaultOrder).setVisible(true);
                break;
            case R.id.menuOrderByPrice:
                selected = R.id.menuOrderByPrice;
                if(sortPriceMode == NOT_SELECTED || sortPriceMode == UP_SELECTED) {
                    item.setIcon(R.drawable.ic_arrow_downward_white_24dp);
                    mMenu.findItem(R.id.menuOrderByName).setIcon(null);
                    sortPriceMode = DOWN_SELECTED;
                } else {
                    item.setIcon(R.drawable.ic_arrow_upward_black_24dp);
                    mMenu.findItem(R.id.menuOrderByName).setIcon(null);
                    sortPriceMode = UP_SELECTED;
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
        mViews = new BaseInsectFragment.ViewHolder(view);
        mAdapter = new InsectRecyclerViewAdapter(getContext(), initCheckboxListener());
        mViews.mRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        mViews.mRecyclerview.setAdapter(mAdapter);
        init(view);
        return view;
    }

    protected List<Insect> orderByPrice(List<Insect> fishList) {
        if(sortPriceMode == DOWN_SELECTED) {
            Collections.sort(fishList, (o1, o2) -> Integer.compare(o1.getPrice(), o2.getPrice()));
            return fishList;
        } else {
            Collections.sort(fishList, (o1, o2) -> Integer.compare(o2.getPrice(), o1.getPrice()));
            return fishList;
        }
    }

    protected List<Insect> orderByName(List<Insect> fishList) {
        if(sortNameMode == DOWN_SELECTED) {
            Collections.sort(fishList, (o1, o2) -> o2.getName().compareToIgnoreCase(o1.getName()));
            return fishList;
        } else {
            Collections.sort(fishList, (o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
            return fishList;
        }

    }

    protected List<Insect> orderByDefault(List<Insect> fishList) {
        Collections.sort(fishList, (o1, o2) -> Integer.compare(o1.getId(), o2.getId()));
        return fishList;
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
