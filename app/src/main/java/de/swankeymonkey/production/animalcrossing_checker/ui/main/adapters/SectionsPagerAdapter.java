package de.swankeymonkey.production.animalcrossing_checker.ui.main.adapters;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import de.swankeymonkey.production.animalcrossing_checker.R;
import de.swankeymonkey.production.animalcrossing_checker.ui.main.fragments.FishAllFragment;
import de.swankeymonkey.production.animalcrossing_checker.ui.main.fragments.FishCatchedFragment;
import de.swankeymonkey.production.animalcrossing_checker.ui.main.fragments.FishMissingFragment;
import de.swankeymonkey.production.animalcrossing_checker.ui.main.fragments.FishNowFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_all, R.string.tab_catched, R.string.tab_missing, R.string.tab_today};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 1:
                return FishCatchedFragment.newInstance();
            case 2:
                return FishMissingFragment.newInstance();
            case 3:
                return FishNowFragment.newInstance();
            default:
                return FishAllFragment.newInstance();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 4;
    }
}