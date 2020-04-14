package de.swankeymonkey.production.animalcrossing_checker.ui.main.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.swankeymonkey.production.animalcrossing_checker.MainActivity;
import de.swankeymonkey.production.animalcrossing_checker.R;
import de.swankeymonkey.production.animalcrossing_checker.utils.AppSharedPreferences;

public class WelcomeDialog extends DialogFragment {
    private ViewHolder mViews;
    private AlertDialog mDialog;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_welcome, null);
        mViews = new ViewHolder(view);
        mDialog = new AlertDialog.Builder(getContext()).setView(view).create();
        mViews.mNHemisphere.setOnClickListener(v -> {
            AppSharedPreferences.setAppHemisphere(getContext(), 0);
            AppSharedPreferences.setIsNotFirstTime(getContext());
            MainActivity activity = (MainActivity)getActivity();
            activity.init();
            dismiss();
        });

        mViews.mSHemisphere.setOnClickListener(v -> {
            AppSharedPreferences.setAppHemisphere(getContext(), 1);
            AppSharedPreferences.setIsNotFirstTime(getContext());
            MainActivity activity = (MainActivity)getActivity();
            activity.init();
            dismiss();
        });

        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        return mDialog;
    }

    @Override
    public void onStart() {
        super.onStart();
        mDialog.getButton(androidx.appcompat.app.AlertDialog.BUTTON_NEGATIVE).setEnabled(false);
        mDialog.getButton(androidx.appcompat.app.AlertDialog.BUTTON_POSITIVE).setEnabled(false);
    }

    public class ViewHolder {
        @BindView(R.id.btNothernHemisphere)
        Button mNHemisphere;
        @BindView(R.id.btSouthernHemisphere)
        Button mSHemisphere;
        Unbinder mUnbinder;

        public ViewHolder(View view) {
            mUnbinder = ButterKnife.bind(this, view);
        }
    }
}
