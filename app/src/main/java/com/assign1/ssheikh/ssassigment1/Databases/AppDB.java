package com.assign1.ssheikh.ssassigment1.Databases;

import android.content.Context;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Score.class, League.class, Team.class
}, version = 16, exportSchema = false)
public abstract class AppDB extends RoomDatabase {

    private static AppDB INSTANCE;

    public abstract ScoreDAO scoreDAO();

    public abstract LeagueDAO leagueDAO();

    public abstract TeamsDAO teamsDAO();



    public static AppDB getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context, AppDB.class, "appDatabase")
//Room.inMemoryDatabaseBuilder(context.getApplicationContext(), AppDatabase.class)
                            // To simplify the exercise, allow queries on the main thread.
                            // Don't do this on a real app!
                            .allowMainThreadQueries()
                            // recreate the database if necessary
                            .fallbackToDestructiveMigration()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
