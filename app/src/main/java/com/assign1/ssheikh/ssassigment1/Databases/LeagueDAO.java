package com.assign1.ssheikh.ssassigment1.Databases;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


@Dao
public interface LeagueDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addLeague(League league);

    @Query("select * from league")
    public List<League> getAllLeagues();

    @Query("select * from league where id = :id")
    public List<League> getLeagues(long id);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateLeague(League league);

    @Query("delete from league")
    void removeAllLeagues();
}