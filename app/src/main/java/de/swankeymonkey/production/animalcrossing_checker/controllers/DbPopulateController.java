package de.swankeymonkey.production.animalcrossing_checker.controllers;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

import de.swankeymonkey.production.animalcrossing_checker.backend.database.DatabaseCreateHelper;
import de.swankeymonkey.production.animalcrossing_checker.backend.models.Fish;
import de.swankeymonkey.production.animalcrossing_checker.backend.repositories.FishRepository;

public class DbPopulateController {
    public static void populateDb(Context context) {
        new FishDbPopulaterTask(context).execute();
    }

    public static class FishDbPopulaterTask extends AsyncTask<Void, Void, List<Fish>> {
        private Context mContext;

        public FishDbPopulaterTask(Context context) {
            mContext = context;
        }

        @Override
        protected List<Fish> doInBackground(Void... voids) {
            DatabaseCreateHelper dbHelper = new DatabaseCreateHelper(mContext);
            List<Fish> allFish = dbHelper.populateNorthernFishList();
            FishRepository repository = new FishRepository(mContext);
            for(Fish fish : allFish) {
                repository.saveNewFish(fish, null);
            }
            return allFish;
        }

        @Override
        protected void onPostExecute(List<Fish> fish) {
            super.onPostExecute(fish);

        }
    }
}
