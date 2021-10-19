package edu.gatech.seclass.jobcompare6300;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class JobRankingActivity extends AppCompatActivity {
    private MyAdapter mAdapter;

    JobManager jobMgr = JobManager.getInstance();
//    JobComparison jobComparison = JobComparison.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.job_ranking);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        DatabaseHelper databaseHelper = DatabaseHelper.getInstance(JobRankingActivity.this);
        List<Job> job_list = databaseHelper.getAllJobs();



//        Weight weight = databaseHelper.getAllWgts();


//        jobMgr.loadAllJobs(job_list);
//        jobMgr.rankOffers(weight);
//        List<Job> input = jobMgr.getJobList();


        // everytime save a new job, calculate score, add to this.score and save to database
        // everytime the weights were updated, all scores are recalculated, and saved to database

        mAdapter = new MyAdapter(job_list);
        recyclerView.setAdapter(mAdapter);

    }


    public void handleClick(View view){
        Intent intent;
        switch (view.getId()){
            case R.id.buttonCompareJobs:
                intent = new Intent(this, JobComparisonActivity.class);
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_LONG;
                ArrayList<Job> checkedJob = mAdapter.getCheckedJob();

                if (checkedJob.size() < 2){
                    CharSequence text = "Error: please select two jobs to compare";
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                }else if (checkedJob.size() > 2){
                    CharSequence text = "Error: More than 2 jobs were selected";
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                }else{
                    Job jobA = checkedJob.get(0);
                    Job jobB = checkedJob.get(1);

                    intent.putExtra("JobA", jobA);
                    intent.putExtra("JobB", jobB);
                    startActivity(intent);
                }
                break;

            case R.id.buttonCancelComparison:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
        }

    }

}
