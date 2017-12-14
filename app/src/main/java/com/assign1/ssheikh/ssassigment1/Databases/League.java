package com.assign1.ssheikh.ssassigment1.Databases;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class League {
    @PrimaryKey
    public final int id;
    public String leagues;


    public League(int id, String leagues) {
        this.id = id;
        this.leagues = leagues;
    }
}
