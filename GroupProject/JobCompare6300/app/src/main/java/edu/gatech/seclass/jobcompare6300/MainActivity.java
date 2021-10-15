package edu.gatech.seclass.jobcompare6300;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;


public class MainActivity extends AppCompatActivity {

    private JobManager jobManager = new JobManager();
    private Weights weights = new Weights();
    private Job currentJob;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // need to create new job manager, and load all save job data

        // fake current job for test
//        currentJob = new Job("senior developer", "Netflix", "CA",
//                144, 120000,20000,
//                2,17,225);
        jobManager.editCurrentJob("senior developer", "Netflix", "CA",
                144, 120000,20000,
                2,17,225);
        jobManager.addNewJobOffer("senior developer", "tesla", "Texas",
                137, 135000,15000,
                3,14,500);
        jobManager.addNewJobOffer("senior developer", "PNC", "PA",
                125, 95000,5000,
                5,14,400);
    }



    public void handleClick(View view){
        Intent intent;
        switch (view.getId()){
            case R.id.buttonCurrent:
                intent = new Intent(this, CurrentJobActivity.class);
                intent.putExtra("jobManager",jobManager);
                System.out.println("To CurrentJobActivity");
                startActivity(intent);
                break;

            case R.id.buttonNewOffer:
                intent = new Intent(this, AddNewOfferActivity.class);
                intent.putExtra("jobManager",jobManager);
                System.out.println("To AddNewOfferActivity");
                startActivity(intent);
                break;

            case R.id.buttonCompare:
                intent = new Intent(this, JobRankingActivity.class);
                intent.putExtra("jobManager",jobManager);
                System.out.println("To JobRankingActivity");
                startActivity(intent);
                break;

            case R.id.buttonSetting:
                intent = new Intent(this, AdjustWeightsActivity.class);
                intent.putExtra("Weights",weights);
                System.out.println("To AdjustWeightsActivity");
                startActivity(intent);
        }

    }

}