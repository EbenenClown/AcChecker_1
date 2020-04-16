package de.swankeymonkey.production.animalcrossing_checker.ui.main.fragments;

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
import de.swankeymonkey.production.animalcrossing_checker.backend.models.Fish;
import de.swankeymonkey.production.animalcrossing_checker.ui.main.adapters.FishRecyclerViewAdapter;

public abstract class BaseFishFragment extends Fragment {
    private static final String SELECTED_MENU = "selectedMenu";

    private boolean isSortedByNameDown;
    private boolean isSortedByPriceDown;
    private Menu mMenu;
    protected ViewHolder mViews;
    protected FishRecyclerViewAdapter mAdapter;
    protected abstract void init(View view);
    protected abstract FishRecyclerViewAdapter.CheckboxClicker<Fish> setOnItemCheckListener();
    private int selected = -1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if(savedInstanceState != null) {
            selected = savedInstanceState.getInt(SELECTED_MENU);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(SELECTED_MENU, selected);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_filter, menu);
        mMenu = menu;
        switch(selected) {
            case R.id.menuOrderByName:
                if(isSortedByNameDown) {
                    mMenu.findItem(R.id.menuOrderByName).setIcon(R.drawable.ic_arrow_downward_white_24dp);
                } else {
                    mMenu.findItem(R.id.menuOrderByName).setIcon(R.drawable.ic_arrow_upward_black_24dp);
                }
                mMenu.findItem(R.id.menuDefaultOrder).setVisible(true);
                break;

            case R.id.menuOrderByPrice:
                if(isSortedByPriceDown) {
                    mMenu.findItem(R.id.menuOrderByPrice).setIcon(R.drawable.ic_arrow_downward_white_24dp);
                } else {
                    mMenu.findItem(R.id.menuOrderByPrice).setIcon(R.drawable.ic_arrow_upward_black_24dp);
                }
                mMenu.findItem(R.id.menuDefaultOrder).setVisible(true);
                break;
        }

    }

    @Override
    public void onPrepareOptionsMenu(@NonNull Menu menu) {
        super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuOrderByName:
                selected = R.id.menuOrderByName;
                if(isSortedByNameDown) {
                    item.setIcon(R.drawable.ic_arrow_downward_white_24dp);
                    mMenu.findItem(R.id.menuOrderByPrice).setIcon(null);
                } else {
                    item.setIcon(R.drawable.ic_arrow_upward_black_24dp);
                    mMenu.findItem(R.id.menuOrderByPrice).setIcon(null);
                }
                mAdapter.setData(orderByName(mAdapter.getData()));
                break;
            case R.id.menuOrderByPrice:
                selected = R.id.menuOrderByPrice;
                if(isSortedByPriceDown) {
                    item.setIcon(R.drawable.ic_arrow_downward_white_24dp);
                    mMenu.findItem(R.id.menuOrderByName).setIcon(null);
                } else {
                    item.setIcon(R.drawable.ic_arrow_upward_black_24dp);
                    mMenu.findItem(R.id.menuOrderByName).setIcon(null);
                }
                mAdapter.setData(orderByPrice(mAdapter.getData()));
                mMenu.findItem(R.id.menuDefaultOrder).setVisible(true);
                break;

            case R.id.menuDefaultOrder:
                mAdapter.setData(orderByDefault(mAdapter.getData()));
                mMenu.findItem(R.id.menuOrderByName).setIcon(null);
                mMenu.findItem(R.id.menuOrderByPrice).setIcon(null);
                mMenu.findItem(R.id.menuDefaultOrder).setVisible(false);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        mViews = new ViewHolder(view);
        mAdapter = new FishRecyclerViewAdapter(getContext(), setOnItemCheckListener());
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
        isSortedByNameDown = false;
        if(isSortedByPriceDown) {
            Collections.sort(fishList, (o1, o2) -> Integer.compare(o1.getPrice(), o2.getPrice()));
            isSortedByPriceDown = false;
            return fishList;
        } else {
            Collections.sort(fishList, (o1, o2) -> Integer.compare(o2.getPrice(), o1.getPrice()));
            isSortedByPriceDown = true;
            return fishList;
        }
    }

    protected List<Fish> orderByName(List<Fish> fishList) {
        isSortedByPriceDown = false;
        if(isSortedByNameDown) {
            Collections.sort(fishList, (o1, o2) -> o2.getName().compareToIgnoreCase(o1.getName()));
            isSortedByNameDown = false;
            return fishList;
        } else {
            Collections.sort(fishList, (o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
            isSortedByNameDown = true;
            return fishList;
        }

    }

    protected List<Fish> orderByDefault(List<Fish> fishList) {
        isSortedByNameDown = false;
        isSortedByPriceDown = false;
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
