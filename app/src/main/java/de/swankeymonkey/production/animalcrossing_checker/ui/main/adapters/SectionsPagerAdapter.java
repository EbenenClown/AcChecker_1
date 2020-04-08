package de.swankeymonkey.production.animalcrossing_checker.ui.main.adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import de.swankeymonkey.production.animalcrossing_checker.R;
import de.swankeymonkey.production.animalcrossing_checker.ui.main.fragments.FishAllFragment;
import de.swankeymonkey.production.animalcrossing_checker.ui.main.fragments.FishCatchedFragment;
import de.swankeymonkey.production.animalcrossing_checker.ui.main.fragments.FishMissingFragment;
import de.swankeymonkey.production.animalcrossing_checker.ui.main.fragments.FishTodayFragment;
import de.swankeymonkey.production.animalcrossing_checker.ui.main.fragments.InsectAllFragment;
import de.swankeymonkey.production.animalcrossing_checker.ui.main.fragments.InsectCatchedFragment;
import de.swankeymonkey.production.animalcrossing_checker.ui.main.fragments.InsectMissingFragment;
import de.swankeymonkey.production.animalcrossing_checker.ui.main.fragments.InsectTodayFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_all, R.string.tab_catched, R.string.tab_missing, R.string.tab_today};
    private final Context mContext;
    private int mode;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mContext = context;
        mode = 1;
    }

    @Override
    public Fragment getItem(int position) {
        if(mode == 1) {
            switch (position) {
                case 1:
                    return FishCatchedFragment.newInstance();
                case 2:
                    return FishMissingFragment.newInstance();
                case 3:
                    return FishTodayFragment.newInstance();
                default:
                    return FishAllFragment.newInstance();
            }
        } else {
            switch (position) {
                case 1:
                    return InsectCatchedFragment.newInstance();
                case 2:
                    return InsectMissingFragment.newInstance();
                case 3:
                    return InsectTodayFragment.newInstance();
                default:
                    return InsectAllFragment.newInstance();
            }
        }
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    public void setMode(int mode) {
        this.mode = mode;
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