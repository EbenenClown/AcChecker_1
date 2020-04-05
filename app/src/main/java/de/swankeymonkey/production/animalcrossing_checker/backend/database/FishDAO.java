package de.swankeymonkey.production.animalcrossing_checker.backend.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import de.swankeymonkey.production.animalcrossing_checker.backend.models.Fish;

@Dao
public interface FishDAO {
    @Insert()
    public void saveNewFish(Fish fish);

    @Delete()
    public void deleteFish(Fish fish);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    public void updateFish(Fish fish);

    @Query("SELECT * FROM Fish")
    public LiveData<List<Fish>> getAllFish();

    @Query("SELECT * FROM Fish WHERE :id = id")
    public LiveData<Fish> getFishWithId(int id);

    @Query("SELECT * FROM Fish WHERE isCatched = 1")
    public LiveData<List<Fish>> getMissingFish();

    @Query("DELETE FROM FISH")
    public void nukeTable();
}
