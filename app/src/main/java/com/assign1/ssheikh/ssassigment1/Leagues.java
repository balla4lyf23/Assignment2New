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
import com.assign1.ssheikh.ssassigment1.Databases.League;
import com.assign1.ssheikh.ssassigment1.Databases.Team;
import com.assign1.ssheikh.ssassigment1.Databases.Score;
import java.util.List;

public class Leagues extends AppCompatActivity {
    AppDB db;
    String allLeagues = "";
    private TextView mTextMessage;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;

    {
        mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        intent = new Intent(Leagues.this, Scores.class);
                        startActivity(intent);
                        return true;
                    case R.id.navigation_dashboard:
                        return true;
                    case R.id.navigation_notifications:
                        intent = new Intent(Leagues.this, teamsActivity.class);
                        startActivity(intent);
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
        new getLeagues().execute();
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void setText() {
        mTextMessage.setText(allLeagues);
    }

    protected class getLeagues extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Void... params) {
            try {

                db.leagueDAO().addLeague(new League(1, "NBA"));
                db.leagueDAO().addLeague(new League(2, "NFL"));
                db.leagueDAO().addLeague(new League(3, "MLB"));
                db.leagueDAO().addLeague(new League(4, "NHL"));
                db.leagueDAO().addLeague(new League(5, "ATP"));
                db.leagueDAO().addLeague(new League(6, "NCAA"));
                db.leagueDAO().addLeague(new League(7, "EPL"));
                List<League> leagues = db.leagueDAO().getAllLeagues();
                for (League league : leagues) {
                    allLeagues = allLeagues + league.leagues + "\n" + "\n";
                }
            } catch (Exception e) {
                Log.e("LEAGUEDB", e.getMessage());
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
