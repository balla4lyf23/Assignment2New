package com.assign1.ssheikh.ssassigment1.Databases;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


@Dao
public interface TeamsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addTeam(Team team);

    @Query("select * from team")
    public List<Team> getAllTeams();

    @Query("select * from team where id = :id")
    public List<Team> getTeams(long id);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateTeam(Team team);

    @Query("delete from team")
    void removeAllTeams();





}

