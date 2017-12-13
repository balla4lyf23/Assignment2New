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

public class Scores extends AppCompatActivity {

    AppDB db;

    private TextView mTextMessage;
    String allScores="";

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;

    {
        mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Intent intent;

                switch (item.getItemId()) {
                    case R.id.navigation_home:

                        return true;
                    case R.id.navigation_dashboard:
                        intent = new Intent(Scores.this, teamsActivity.class);
                        startActivity(intent);
                        return true;
                    case R.id.navigation_notifications:
                        intent = new Intent(Scores.this, activityLeagues.class);
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

        db=App.get().getDB();

        new getScores().execute();

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


    public void setText(){
        mTextMessage.setText(allScores);

    }

    protected class getScores extends AsyncTask<Void, Void, Boolean>{

        @Override
        protected Boolean doInBackground(Void... params) {



            try{

                db.scoreDAO().addScore(new Score( 1, "Toronto Raptors vs Chicago Bulls", +4.5, "96-85"));
                db.scoreDAO().addScore(new Score( 2, "Vancouver Canucks vs Toronto Maple Leafs", -1.5, "0-0"));
                db.scoreDAO().addScore(new Score( 3, "Milwaukee Bucks @ Philadelphia 76ers", +3.5, "0-0"));
                db.scoreDAO().addScore(new Score( 4, "Roger Federer vs Rafael Nadal", -1.5, "2/40-15"));
                db.scoreDAO().addScore(new Score( 5, "New England Patriots @ Buffalo Bills", -10.5, "21-7"));
                db.scoreDAO().addScore(new Score( 6, "Toronto Blue Jays @ San Diego Padres", -1.5, "3-1"));
                db.scoreDAO().addScore(new Score( 7, "Golden State Warriors vs Sacramento Kings", -15.5, "126-85"));
                List<Score> scores = db.scoreDAO().getAllScores();
                for (Score score : scores){
                    allScores = allScores + score.teams + " " + score.odds + " "  +  score.score +"\n" + "\n" ;
                }



            }
            catch (Exception e){
                Log.e("SCOREDB", e.getMessage());
                return  false;
            }
            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success){

            if (success) {

                setText();

            }
            else{
            }
        }
    }
}
