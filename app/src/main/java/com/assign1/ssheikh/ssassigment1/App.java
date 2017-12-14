package com.assign1.ssheikh.ssassigment1;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.assign1.ssheikh.ssassigment1.Databases.AppDB;
import com.assign1.ssheikh.ssassigment1.Databases.Score;
import com.assign1.ssheikh.ssassigment1.Databases.League;
import com.assign1.ssheikh.ssassigment1.Databases.Team;

public class App extends Application {
    public static App INSTANCE;
    private static final String DATABASE_NAME = "MyDatabase";
    private static final String PREFERENCES = "RoomDemo.prederences";
    private static  final String KEY_FORCE_UPDATE = "force_update";
    private AppDB database;

    public  static App get(){
        return INSTANCE;
    }
    @Override
    public void onCreate(){
        super.onCreate();
        database = Room.databaseBuilder(getApplicationContext(), AppDB.class, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build();
        INSTANCE = this;
    }
    public AppDB getDB(){
        return database;
    }
}
