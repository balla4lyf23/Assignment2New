package com.assign1.ssheikh.ssassigment1;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.assign1.ssheikh.ssassigment1.Databases.AppDB;
import com.assign1.ssheikh.ssassigment1.Databases.Score;
import com.assign1.ssheikh.ssassigment1.Databases.League;
import com.assign1.ssheikh.ssassigment1.Databases.Team;

import java.util.List;

public class Teams extends AppCompatActivity {
    AppDB db;
    String allTeams = "";
    private TextView mTextMessage;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;

    {
        mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        intent = new Intent(Teams.this, activityLeagues.class);
                        return true;
                    case R.id.navigation_dashboard:
                        intent = new Intent(Teams.this, Scores.class);
                        startActivity(intent);
                        return true;
                    case R.id.navigation_notifications:
                        return true;
                }
                return false;
            }
        };
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.black));
        }
        db = App.get().getDB();
        new getTeams().execute();
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void setText() {
        mTextMessage.setText(allTeams);
    }

    protected class getTeams extends AsyncTask<Void, Void, Boolean> {
        @Override
        protected Boolean doInBackground(Void... params) {
            try {
                db.teamsDAO().addTeam(new Team(1, "Toronto Raptors"));
                db.teamsDAO().addTeam(new Team(2, "Cleveland Cavaliers"));
                db.teamsDAO().addTeam(new Team(3, "Los Angeles Lakers"));
                db.teamsDAO().addTeam(new Team(4, "New Orleans Saints"));
                db.teamsDAO().addTeam(new Team(5, "Manchester United"));
                db.teamsDAO().addTeam(new Team(6, "North Carolina Tar Heels"));
                db.teamsDAO().addTeam(new Team(7, "Minnesota Lynx"));
                List<Team> teams = db.teamsDAO().getAllTeams();
                for (Team team : teams) {
                    allTeams = allTeams + team.teams + "\n" + "\n";
                }
            } catch (Exception e) {
                Log.e("TEAMDB", e.getMessage());
                return false;
            }
            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            if (success) {
                setText();
            } else {
            }
        }
    }
}
