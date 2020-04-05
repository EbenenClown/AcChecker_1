package de.swankeymonkey.production.animalcrossing_checker.backend.repositories;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;

import java.util.List;

import de.swankeymonkey.production.animalcrossing_checker.backend.database.AppDatabase;
import de.swankeymonkey.production.animalcrossing_checker.backend.database.GenericDbTask;
import de.swankeymonkey.production.animalcrossing_checker.backend.models.Insect;

public class InsectRepository {
    private AppDatabase mDb;

    public InsectRepository(@NonNull Context context) {
        mDb = AppDatabase.getInstance(context);
    }

    public void saveNewInsect(Insect insect, @Nullable GenericDbTask.DbCallback<Insect> callback) {
        new InsectRepository.SaverTask(mDb, callback).execute(insect);
    }

    public void updateInsect(Insect insect, @Nullable GenericDbTask.DbCallback<Insect> callback) {
        new InsectRepository.UpdaterTask(mDb, callback).execute(insect);
    }

    public void deleteInsect(Insect insect, @Nullable GenericDbTask.DbCallback<Insect> callback) {
        new InsectRepository.DeleterTask(mDb, callback).execute(insect);
    }


    public LiveData<List<Insect>> getAllInsects() {
        return mDb.insectDAO().getAllInsects();
    }

    public LiveData<List<Insect>> getMissingInsects() {
        return mDb.insectDAO().getMissingInsects();
    }

    public LiveData<Insect> getInsectById(int id) {
        return mDb.insectDAO().getInsectWithId(id);
    }

    private static class SaverTask extends GenericDbTask<Insect, Insect> {
        SaverTask(AppDatabase db,@Nullable DbCallback<Insect> callback) {
            super(db, callback);
        }

        @Override
        protected Insect doInBackGroundCustom(Insect data) {
            db.insectDAO().saveNewInsect(data);
            return data;
        }
    }

    private static class UpdaterTask extends GenericDbTask<Insect, Insect> {
        UpdaterTask(AppDatabase db,@Nullable DbCallback<Insect> callback) {
            super(db, callback);
        }

        @Override
        protected Insect doInBackGroundCustom(Insect data) {
            db.insectDAO().updateInsect(data);
            return data;
        }
    }

    private static class DeleterTask extends GenericDbTask<Insect, Insect> {
        DeleterTask(AppDatabase db,@Nullable DbCallback<Insect> callback) {
            super(db, callback);
        }

        @Override
        protected Insect doInBackGroundCustom(Insect data) {
            db.insectDAO().deleteInsect(data);
            return data;
        }
    }
}
