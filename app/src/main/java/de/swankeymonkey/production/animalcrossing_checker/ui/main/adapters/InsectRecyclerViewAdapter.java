package de.swankeymonkey.production.animalcrossing_checker.ui.main.adapters;

import android.content.Context;
import android.view.View;

import de.swankeymonkey.production.animalcrossing_checker.backend.models.Animal;
import de.swankeymonkey.production.animalcrossing_checker.backend.models.Insect;

public class InsectRecyclerViewAdapter extends AnimalRecyclerViewAdapter<Insect> {

    public InsectRecyclerViewAdapter(Context context, CheckboxClicker<Insect> listener) {
        super(context, listener);
    }

    @Override
    protected AnimalViewHolder setViewHolder(View view) {
        return new InsectViewHolder(view);
    }

    public class InsectViewHolder extends AnimalViewHolder {
        public InsectViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void setImage(Animal animal) {

        }

        @Override
        protected void setLocation(Animal animal) {

        }

        @Override
        protected void setTime(Animal animal) {

        }
    }
}
