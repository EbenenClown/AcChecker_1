package de.swankeymonkey.production.animalcrossing_checker.backend.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import de.swankeymonkey.production.animalcrossing_checker.backend.database.GenericDbTask;
import de.swankeymonkey.production.animalcrossing_checker.backend.models.Fish;
import de.swankeymonkey.production.animalcrossing_checker.backend.repositories.FishRepository;

public class FishViewModel extends AndroidViewModel {
    private FishRepository mRepository;
    private LiveData<List<Fish>> mFishList;

    public FishViewModel(Application application) {
        super(application);
        mRepository = new FishRepository(application);
        mFishList = new MutableLiveData<>();
    }

    public LiveData<List<Fish>> getAllFish() {
        mFishList = mRepository.getAllFish();
        return mFishList;
    }

    public LiveData<List<Fish>> getMissingFish() {
        mFishList = mRepository.getMissingFish();
        return mFishList;
    }

    public LiveData<List<Fish>> getCatchedFish() {
        mFishList = mRepository.getCatchedFish();
        return mFishList;
    }

    public LiveData<Fish> getFishById(int id) {
        return mRepository.getFishById(id);
    }

    public void saveNewFish(Fish fish, GenericDbTask.DbCallback<Fish> callback) {
        mRepository.saveNewFish(fish, callback);
    }

    public void updateFish(Fish fish, GenericDbTask.DbCallback<Fish> callback) {
        mRepository.updateFish(fish, callback);
    }

    public void deleteFish(Fish fish, GenericDbTask.DbCallback<Fish> callback) {
        mRepository.deleteFish(fish, callback);
    }

    public void nukeTable() {
        mRepository.nukeTable();
    }
}
