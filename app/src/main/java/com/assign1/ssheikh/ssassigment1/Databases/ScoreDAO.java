package com.assign1.ssheikh.ssassigment1.Databases;

/**
 * Created by Ssheikh-cc on 12/13/2017.
 */

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


@Dao
public interface ScoreDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addScore (Score score);

    @Query("select * from score")
    public List<Score> getAllScores();

    @Query("select * from score where id = :id")
    public List<Score> getScores(long id);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateScore(Score score);

    @Query("delete from score")
    void removeAllScores();
}