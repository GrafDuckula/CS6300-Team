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

    private JobManager jobMgr = JobManager.getInstance();
    private JobComparison weights = JobComparison.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load all data
//        DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);
//        List<Job> job_list = databaseHelper.getAllJobs();
//        jobMgr.loadAllJobs(job_list);
//
//        Job current_job = databaseHelper.getCurrentJob();
//        if (current_job != null) {
//            jobMgr.addCurrentJob(current_job);}
//
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

                DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);
                List<Job> job_list = new ArrayList<>();
                job_list = databaseHelper.getAllJobs();
                Job current_job = databaseHelper.getCurrentJob();

                if (current_job != null) {
                    jobMgr.addCurrentJob(current_job);}
                if (job_list != null) {
                    jobMgr.loadAllJobs(job_list); }


                if (jobMgr.getJobList().size() <= 1){
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