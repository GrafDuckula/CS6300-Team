package edu.gatech.seclass.jobcompare6300;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;


public class MainActivity extends AppCompatActivity {

    private JobManager jobManager = new JobManager();
    private Weights weights = new Weights();
    private Job currentJob;

    // should I only transfer Job Manager??



    // if current job already exist, need to load the info from database to it.
    // if not, throw a toast

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // need to create new job manager, and load all save job data
    }



    public void handleClick(View view){
        Intent intent;
        switch (view.getId()){
            case R.id.buttonNewOffer:
                intent = new Intent(this, AddNewOfferActivity.class);
                intent.putExtra("jobManager",jobManager);
                startActivity(intent);
            case R.id.buttonCurrent:
                intent = new Intent(this, CurrentJobActivity.class);
                intent.putExtra("currentJob",currentJob);
                startActivity(intent);
            case R.id.buttonCompare:
                intent = new Intent(this, JobRankingActivity.class);
                intent.putExtra("jobManager",jobManager);
                startActivity(intent);

            case R.id.buttonSetting:
                intent = new Intent(this, AdjustWeightsActivity.class);
                intent.putExtra("Weights",weights);
                startActivity(intent);
        }

    }

}