package de.swankeymonkey.production.animalcrossing_checker.backend.database;

import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract class GenericDbTask<T, Z> extends AsyncTask<T, Void, Z> {
    protected AppDatabase db;
    protected DbCallback<Z> callback;
    protected abstract Z doInBackGroundCustom(T data);

    public GenericDbTask(@NonNull AppDatabase db,@Nullable DbCallback<Z> callback) {
        this.db = db;
        this.callback = callback;
    }

    @Override
    protected Z doInBackground(T... ts) {
            T t = ts[0];
            return doInBackGroundCustom(t);
    }

    @Override
    protected void onPostExecute(Z z) {
        super.onPostExecute(z);
        if(z != null && callback != null) {
            callback.onFinsh(z);
        }
    }

    public interface DbCallback<Z> {
        void onFinsh(Z data);
    }
}
