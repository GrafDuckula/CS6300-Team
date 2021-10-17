package edu.gatech.seclass.jobcompare6300;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class JobRankingActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Job> checkedJob=new ArrayList<>();

    JobManager jobMgr = JobManager.getInstance();
    JobComparison jobComparison = JobComparison.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.job_ranking);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);



        DatabaseHelper databaseHelper = new DatabaseHelper(JobRankingActivity.this);
        List<Job> job_list = databaseHelper.getAllJobs();
        jobMgr.getAllJobs(job_list);

        Job current_job = databaseHelper.getCurrentJob();
        if (current_job != null) {
            jobMgr.addCurrentJob(current_job);}

        // need to add and mark current JOb


        jobMgr.rankOffers(jobComparison);
        List<Job> input = jobMgr.getJobList();

        mAdapter = new MyAdapter(input);
        recyclerView.setAdapter(mAdapter);

    }

    private Job jobA;
    private Job jobB;


    public void handleClick(View view){
        Intent intent;
        switch (view.getId()){
            case R.id.buttonCompareJobs:
                intent = new Intent(this, JobComparisonActivity.class);
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_LONG;
                checkedJob = mAdapter.getCheckedJob();
                if (checkedJob.size() < 2){
                    CharSequence text = "Error: please select two jobs to compare";
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }else if (checkedJob.size() > 2){
                    CharSequence text = "Error: More than 2 jobs were selected";
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }else{

                    jobA = checkedJob.get(0);
                    jobB = checkedJob.get(1);
                    jobComparison.addJobOfferToCompare(jobA,jobB);
//                    intent.putExtra("JobA", jobA);
//                    intent.putExtra("JobB", jobB);
                    startActivity(intent);
                }
                break;

            case R.id.buttonCancelComparison:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
        }

    }








}
