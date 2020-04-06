package de.swankeymonkey.production.animalcrossing_checker;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ProgressBar;


import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.swankeymonkey.production.animalcrossing_checker.controllers.DbPopulateController;
import de.swankeymonkey.production.animalcrossing_checker.ui.main.adapters.SectionsPagerAdapter;
import de.swankeymonkey.production.animalcrossing_checker.utils.AppSharedPreferences;

public class MainActivity extends AppCompatActivity {
    private ViewHolder mViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViews = new ViewHolder(this);
        mViews.mProgressBar.setVisibility(View.VISIBLE);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        mViews.mViewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(mViews.mViewPager);
        setSupportActionBar(mViews.mToolbar);

        if(!AppSharedPreferences.isFishDbPopulated(this)) {
            DbPopulateController.populateDb(this);
            AppSharedPreferences.setFishDbPopulated(this, true);
        }
    }

    public class ViewHolder {
        @BindView(R.id.view_pager)
        ViewPager mViewPager;
        @BindView(R.id.toolbar)
        Toolbar mToolbar;
        @BindView(R.id.progessBar)
        ProgressBar mProgressBar;

        public ViewHolder(Activity activity) {
            ButterKnife.bind(this, activity);
        }
    }
}