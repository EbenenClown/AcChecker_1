package de.swankeymonkey.production.animalcrossing_checker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.joda.time.DateTime;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.swankeymonkey.production.animalcrossing_checker.utils.AppSharedPreferences;
import de.swankeymonkey.production.animalcrossing_checker.utils.Constants;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ViewHolder views = new ViewHolder(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.settings));

        ArrayAdapter<CharSequence> adapterHemisphere = ArrayAdapter.createFromResource(this, R.array.hemisphere, android.R.layout.simple_spinner_item);
        adapterHemisphere.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        views.mHemisphereSpinner.setAdapter(adapterHemisphere);
        views.mHemisphereSpinner.setSelection(AppSharedPreferences.getAppHemisphere(this));
        views.mHemisphereSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AppSharedPreferences.setAppHemisphere(SettingsActivity.this, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        views.mExpander.setChecked(AppSharedPreferences.isAlwaysExpanded(this));
        views.mExpander.setOnCheckedChangeListener((buttonView, isChecked) -> AppSharedPreferences.setIsAlwaysExpanded(SettingsActivity.this, isChecked));

        ArrayAdapter<CharSequence> adapterMonths = ArrayAdapter.createFromResource(this, R.array.months, android.R.layout.simple_spinner_item);
        adapterMonths.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        views.mMonthsSpinner.setAdapter(adapterMonths);
        views.mMonthsSpinner.setSelection(AppSharedPreferences.getAppMonth(this) != Constants.NO_MONTH_CHOSEN ? AppSharedPreferences.getAppMonth(this) : new DateTime().getMonthOfYear() - 1);
        views.mMonthsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position + 1 == new DateTime().getMonthOfYear()) {
                    AppSharedPreferences.setAppMonth(SettingsActivity.this, Constants.NO_MONTH_CHOSEN);
                } else {
                    AppSharedPreferences.setAppMonth(SettingsActivity.this, position);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        backToMainActivity();
        return true;
    }

    @Override
    public void onBackPressed() {
        backToMainActivity();
    }

    private void backToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public class ViewHolder {
        @BindView(R.id.spHemisphere)
        Spinner mHemisphereSpinner;
        @BindView(R.id.spMonths)
        Spinner mMonthsSpinner;
        @BindView(R.id.swExpand)
        Switch mExpander;

        Unbinder mUnbinder;

        public ViewHolder(Activity activity) {
            mUnbinder = ButterKnife.bind(this, activity);
        }
    }
}
