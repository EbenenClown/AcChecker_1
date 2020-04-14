package de.swankeymonkey.production.animalcrossing_checker;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.swankeymonkey.production.animalcrossing_checker.controllers.DbPopulateController;
import de.swankeymonkey.production.animalcrossing_checker.ui.main.adapters.SectionsPagerAdapter;
import de.swankeymonkey.production.animalcrossing_checker.ui.main.dialogs.WelcomeDialog;
import de.swankeymonkey.production.animalcrossing_checker.utils.AppSharedPreferences;
import de.swankeymonkey.production.animalcrossing_checker.utils.Constants;


public class MainActivity extends AppCompatActivity {
    private static final int FISH_MODE = 1;
    private static final int INSECT_MODE = 2;

    private SectionsPagerAdapter mAdapter;
    private ViewHolder mViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViews = new ViewHolder(this);

        if(AppSharedPreferences.isFirstStart(this) || AppSharedPreferences.getAppHemisphere(this) == Constants.NO_HEMISPHERE_CHOSEN) {
            WelcomeDialog dialog = new WelcomeDialog();
            dialog.show(getSupportFragmentManager(), Constants.WELCOME_DIALOG);
            mAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
            mViews.mViewPager.setOffscreenPageLimit(4);
            TabLayout tabs = findViewById(R.id.tabs);
            tabs.setupWithViewPager(mViews.mViewPager);
            setSupportActionBar(mViews.mToolbar);
        } else {
            init();
        }

        if(!AppSharedPreferences.isDbPopulated(this)) {
            DbPopulateController.populateDb(this);
            AppSharedPreferences.setDbPopulated(this, true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menuSettings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    public void init() {
        mAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        mViews.mViewPager.setAdapter(mAdapter);
        mViews.mViewPager.setOffscreenPageLimit(4);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(mViews.mViewPager);
        setSupportActionBar(mViews.mToolbar);
        mViews.mBottomNavigation.setOnNavigationItemSelectedListener(item -> {
            mViews.mProgressBar.setVisibility(View.VISIBLE);
            if(item.getItemId() == R.id.nav_fish) {
                mAdapter.setMode(FISH_MODE);
                mAdapter.notifyDataSetChanged();
            } else {
                mAdapter.setMode(INSECT_MODE);
                mAdapter.notifyDataSetChanged();
            }
            return false;
        });
    }


    public class ViewHolder {
        @BindView(R.id.view_pager)
        ViewPager mViewPager;
        @BindView(R.id.toolbar)
        Toolbar mToolbar;
        @BindView(R.id.bottom_navigation)
        BottomNavigationView mBottomNavigation;
        @BindView(R.id.progessBar)
        ProgressBar mProgressBar;

        public ViewHolder(Activity activity) {
            ButterKnife.bind(this, activity);
        }
    }
}