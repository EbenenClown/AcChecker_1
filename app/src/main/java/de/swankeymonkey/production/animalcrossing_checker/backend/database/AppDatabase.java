package de.swankeymonkey.production.animalcrossing_checker.backend.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import de.swankeymonkey.production.animalcrossing_checker.backend.models.Fish;
import de.swankeymonkey.production.animalcrossing_checker.backend.models.Insect;

import static de.swankeymonkey.production.animalcrossing_checker.utils.Constants.*;

@Database(entities = {Fish.class, Insect.class}, version = DB_VERSION, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;
    public abstract FishDAO fishDAO();
    public abstract InsectDAO insectDAO();

    public static AppDatabase getInstance(@NonNull Context context) {
        if(INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, AppDatabase.class, DB_NAME).build();
        }
        return INSTANCE;
    }
}
