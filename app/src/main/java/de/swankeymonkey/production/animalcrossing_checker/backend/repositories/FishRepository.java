package de.swankeymonkey.production.animalcrossing_checker.backend.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;

import java.util.List;

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


    private LiveData<List<Fish>> getAllFish() {
        return mDb.fishDAO().getAllFish();
    }

    private LiveData<List<Fish>> getMissingFish() {
        return mDb.fishDAO().getMissingFish();
    }

    private LiveData<Fish> getFishById(int id) {
        return mDb.fishDAO().getFishWithId(id);
    }

    private static class SaverTask extends GenericDbTask<Fish, Fish> {
        SaverTask(AppDatabase db,@Nullable DbCallback<Fish> callback) {
            super(db, callback);
        }

        @Override
        protected Fish doInBackGround(Fish data) {
            db.fishDAO().saveNewFish(data);
            return data;
        }
    }

    private static class UpdaterTask extends GenericDbTask<Fish, Fish> {
        UpdaterTask(AppDatabase db,@Nullable DbCallback<Fish> callback) {
            super(db, callback);
        }

        @Override
        protected Fish doInBackGround(Fish data) {
            db.fishDAO().updateFish(data);
            return data;
        }
    }

    private static class DeleterTask extends GenericDbTask<Fish, Fish> {
        DeleterTask(AppDatabase db,@Nullable DbCallback<Fish> callback) {
            super(db, callback);
        }

        @Override
        protected Fish doInBackGround(Fish data) {
            db.fishDAO().deleteFish(data);
            return data;
        }
    }
}
