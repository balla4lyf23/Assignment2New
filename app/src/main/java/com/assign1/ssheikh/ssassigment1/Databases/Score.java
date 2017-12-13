package com.assign1.ssheikh.ssassigment1.Databases;

/**
 * Created by Ssheikh-cc on 12/13/2017.
 */

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Score {
    @PrimaryKey
    public final int id;
    public String teams;
    public double odds;
    public String score;

    public Score(int id, String teams, double odds, String score) {
        this.id = id;
        this.teams = teams;
        this.odds= odds;
        this.score= score;
    }
}
