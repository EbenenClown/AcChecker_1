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
    void saveNewFish(Fish fish);

    @Delete()
    void deleteFish(Fish fish);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateFish(Fish fish);

    @Query("SELECT * FROM Fish")
    LiveData<List<Fish>> getAllFish();

    @Query("SELECT * FROM Fish WHERE :id = id")
    LiveData<Fish> getFishWithId(int id);

    @Query("SELECT * FROM Fish WHERE isCatched = 0")
    LiveData<List<Fish>> getMissingFish();

    @Query("SELECT * FROM Fish WHERE isCatched = 1")
    LiveData<List<Fish>> getCatchedFish();

    @Query("DELETE FROM FISH")
    void nukeTable();
}
