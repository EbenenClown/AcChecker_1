package de.swankeymonkey.production.animalcrossing_checker.backend.repositories;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;

import java.util.List;

import de.swankeymonkey.production.animalcrossing_checker.backend.database.AppDatabase;
import de.swankeymonkey.production.animalcrossing_checker.backend.database.GenericDbTask;
import de.swankeymonkey.production.animalcrossing_checker.backend.models.Fish;

public class FishRepository {
    private AppDatabase mDb;

    public FishRepository(@NonNull Context context) {
        mDb = AppDatabase.getInstance(context);
    }

    public void saveNewFish(Fish fish, @Nullable GenericDbTask.DbCallback<Fish> callback) {
        new SaverTask(mDb, callback).execute(fish);
    }

    public void updateFish(Fish fish, @Nullable GenericDbTask.DbCallback<Fish> callback) {
        new UpdaterTask(mDb, callback).execute(fish);
    }

    public void deleteFish(Fish fish, @Nullable GenericDbTask.DbCallback<Fish> callback) {
        new DeleterTask(mDb, callback).execute(fish);
    }

    public void nukeTable() {
        new TableNukerTask(mDb).execute(new Fish());
    }


    public LiveData<List<Fish>> getAllFish() {
        return mDb.fishDAO().getAllFish();
    }

    public LiveData<List<Fish>> getMissingFish() {
        return mDb.fishDAO().getMissingFish();
    }

    public LiveData<List<Fish>> getCatchedFish() {
        return mDb.fishDAO().getCatchedFish();
    }

    public LiveData<Fish> getFishById(int id) {
        return mDb.fishDAO().getFishWithId(id);
    }

    private static class SaverTask extends GenericDbTask<Fish, Fish> {
        SaverTask(AppDatabase db,@Nullable DbCallback<Fish> callback) {
            super(db, callback);
        }

        @Override
        protected Fish doInBackGroundCustom(Fish data) {
            db.fishDAO().saveNewFish(data);
            return data;
        }
    }

    private static class UpdaterTask extends GenericDbTask<Fish, Fish> {
        UpdaterTask(AppDatabase db,@Nullable DbCallback<Fish> callback) {
            super(db, callback);
        }

        @Override
        protected Fish doInBackGroundCustom(Fish data) {
            db.fishDAO().updateFish(data);
            return data;
        }
    }

    private static class DeleterTask extends GenericDbTask<Fish, Fish> {
        DeleterTask(AppDatabase db,@Nullable DbCallback<Fish> callback) {
            super(db, callback);
        }

        @Override
        protected Fish doInBackGroundCustom(Fish data) {
            db.fishDAO().deleteFish(data);
            return data;
        }
    }

    private static class TableNukerTask extends GenericDbTask<Fish, Void> {
        TableNukerTask(AppDatabase appDatabase) {
            super(appDatabase, null);
        }

        @Override
        protected Void doInBackGroundCustom(Fish data) {
            db.fishDAO().nukeTable();
            return null;
        }
    }
}
