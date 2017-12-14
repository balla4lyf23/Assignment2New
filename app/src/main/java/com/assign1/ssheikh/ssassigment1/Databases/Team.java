package com.assign1.ssheikh.ssassigment1.Databases;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Team {
    @PrimaryKey
    public final int id;
    public String teams;

    public Team(int id, String teams) {
        this.id = id;
        this.teams = teams;
    }
}