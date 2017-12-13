package com.assign1.ssheikh.ssassigment1;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.assign1.ssheikh.ssassigment1.Databases.AppDB;
import com.assign1.ssheikh.ssassigment1.Databases.Score;

import java.util.List;


public class Leagues extends AppCompatActivity {

    AppDB db;

    private TextView mTextMessage;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Intent intent;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    intent = new Intent(Leagues.this ,Scores.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_dashboard:

                    return true;
                case R.id.navigation_notifications:
                    intent = new Intent(Leagues.this ,teamsActivity.class);
                    startActivity(intent);
                    return true;
            }
            return false;
        }

    };





}
