package de.swankeymonkey.production.animalcrossing_checker.backend.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import de.swankeymonkey.production.animalcrossing_checker.backend.models.Insect;

@Dao
public interface InsectDAO {
    @Insert()
    void saveNewInsect(Insect insect);

    @Delete()
    void deleteInsect(Insect insect);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateInsect(Insect insect);

    @Query("SELECT * FROM insect")
    LiveData<List<Insect>> getAllInsects();

    @Query("SELECT * FROM insect WHERE :id = id")
    LiveData<Insect> getInsectWithId(int id);

    @Query("SELECT * FROM insect WHERE isCatched = 0")
    LiveData<List<Insect>> getMissingInsects();

    @Query("SELECT * FROM insect WHERE isCatched = 1")
    LiveData<List<Insect>> getCatchedInsects();

    @Query("DELETE FROM Insect")
    void nukeTable();
}
