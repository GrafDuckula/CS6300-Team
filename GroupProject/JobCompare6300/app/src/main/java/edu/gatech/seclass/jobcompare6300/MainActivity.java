package edu.gatech.seclass.jobcompare6300;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void handleClick(View view){
        Intent intent;
        switch (view.getId()){
            case R.id.buttonCurrent:
                intent = new Intent(this, CurrentJobActivity.class);
                startActivity(intent);
                break;

            case R.id.buttonNewOffer:
                intent = new Intent(this, AddNewOfferActivity.class);
                startActivity(intent);
                break;

            case R.id.buttonCompare:

                DatabaseHelper databaseHelper = DatabaseHelper.getInstance(MainActivity.this);
                List<Job> job_list = databaseHelper.getAllJobs();

                if (job_list.size() <= 1){
                    Context context = getApplicationContext();
                    CharSequence text = "Error: less than two jobs to compare";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else{
                    intent = new Intent(this, JobRankingActivity.class);
                    startActivity(intent);
                }

                break;

            case R.id.buttonSetting:
                intent = new Intent(this, AdjustWeightsActivity.class);
                startActivity(intent);
        }

    }

}