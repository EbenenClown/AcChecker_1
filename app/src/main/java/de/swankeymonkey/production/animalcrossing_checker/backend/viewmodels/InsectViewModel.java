package de.swankeymonkey.production.animalcrossing_checker.backend.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import de.swankeymonkey.production.animalcrossing_checker.backend.database.GenericDbTask;
import de.swankeymonkey.production.animalcrossing_checker.backend.models.Insect;
import de.swankeymonkey.production.animalcrossing_checker.backend.repositories.InsectRepository;

public class InsectViewModel extends AndroidViewModel {
    private InsectRepository mRepository;
    private LiveData<List<Insect>> mInsectList;

    public InsectViewModel(Application application) {
        super(application);
        mRepository = new InsectRepository(application);
        mInsectList = new MutableLiveData<>();
    }

    public LiveData<List<Insect>> getAllInsects() {
        mInsectList = mRepository.getAllInsects();
        return mInsectList;
    }

    public LiveData<List<Insect>> getMissingInsects() {
        mInsectList = mRepository.getMissingInsects();
        return mInsectList;
    }

    public LiveData<List<Insect>> getCatchedInsects() {
        mInsectList = mRepository.getCatchedInsects();
        return mInsectList;
    }

    public LiveData<Insect> getInsectById(int id) {
        return mRepository.getInsectById(id);
    }

    public void saveNewInsect(Insect Insect, GenericDbTask.DbCallback<Insect> callback) {
        mRepository.saveNewInsect(Insect, callback);
    }

    public void updateInsect(Insect Insect, GenericDbTask.DbCallback<Insect> callback) {
        mRepository.updateInsect(Insect, callback);
    }

    public void deleteInsect(Insect Insect, GenericDbTask.DbCallback<Insect> callback) {
        mRepository.deleteInsect(Insect, callback);
    }

    public void nukeTable() {
        mRepository.nukeTable();
    }
}
