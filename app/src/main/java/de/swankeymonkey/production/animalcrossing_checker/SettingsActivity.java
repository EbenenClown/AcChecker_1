package de.swankeymonkey.production.animalcrossing_checker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
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
    private ViewHolder mViews;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        mViews = new ViewHolder(this);

        ArrayAdapter<CharSequence> adapterHemisphere = ArrayAdapter.createFromResource(this, R.array.hemisphere, android.R.layout.simple_spinner_item);
        adapterHemisphere.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mViews.mHemisphereSpinner.setAdapter(adapterHemisphere);
        mViews.mHemisphereSpinner.setSelection(AppSharedPreferences.getAppHemisphere(this));
        mViews.mHemisphereSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AppSharedPreferences.setAppHemisphere(SettingsActivity.this, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mViews.mExpander.setChecked(AppSharedPreferences.isAlwaysExpanded(this));
        mViews.mExpander.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                AppSharedPreferences.setIsAlwaysExpanded(SettingsActivity.this, isChecked);
            }
        });

        ArrayAdapter<CharSequence> adapterMonths = ArrayAdapter.createFromResource(this, R.array.months, android.R.layout.simple_spinner_item);
        adapterMonths.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mViews.mMonthsSpinner.setAdapter(adapterMonths);
        mViews.mMonthsSpinner.setSelection(AppSharedPreferences.getAppMonth(this) != Constants.NO_MONTH_CHOSEN ? AppSharedPreferences.getAppMonth(this) : new DateTime().getMonthOfYear() - 1);
        mViews.mMonthsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AppSharedPreferences.setAppMonth(SettingsActivity.this, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public class ViewHolder {
        @BindView(R.id.spHemisphere)
        Spinner mHemisphereSpinner;
        @BindView(R.id.spMonths)
        Spinner mMonthsSpinner;
        @BindView(R.id.swExpand)
        Switch mExpander;
        @BindView(R.id.tvImpressum)
        TextView mImpressum;

        Unbinder mUnbinder;

        public ViewHolder(Activity activity) {
            mUnbinder = ButterKnife.bind(this, activity);
        }
    }
}
