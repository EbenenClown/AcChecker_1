package de.swankeymonkey.production.animalcrossing_checker;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;

import de.swankeymonkey.production.animalcrossing_checker.controllers.DbPopulateController;
import de.swankeymonkey.production.animalcrossing_checker.ui.main.SectionsPagerAdapter;
import de.swankeymonkey.production.animalcrossing_checker.utils.AppSharedPreferences;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        if(!AppSharedPreferences.isFishDbPopulated(this)) {
            DbPopulateController.populateDb(this);
            AppSharedPreferences.setFishDbPopulated(this, true);
        }
    }
}