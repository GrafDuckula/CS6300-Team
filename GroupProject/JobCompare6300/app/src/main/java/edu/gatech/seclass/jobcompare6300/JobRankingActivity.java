package edu.gatech.seclass.jobcompare6300;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.job_ranking);
        initializeWidgets();

        Intent intent = this.getIntent();
        jobManager = (JobManager) intent.getSerializableExtra("jobManager");


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        int numOfJobs = jobManager.getJobList().size();
        System.out.println("numOfJobs" + numOfJobs);
        List<Job> input = new ArrayList<>();
        for (int i = 0; i < numOfJobs; i++) {
            Job job = jobManager.getJobList().get(i);
            System.out.println(job.getTitle() + "@" + job.getCompany());
            //input.add(job.getTitle() + "@" + job.getCompany());
            input.add(job);
        }// define an adapter

        mAdapter = new MyAdapter(input);
        recyclerView.setAdapter(mAdapter);




    }

    private Job jobA;
    private Job jobB;
    private JobManager jobManager;

    private void initializeWidgets() {


    }

    public void handleClick(View view){
        Intent intent;
        switch (view.getId()){
            case R.id.buttonCompareJobs:
                intent = new Intent(this, JobComparisonActivity.class);
                // need to send two Job keys to comparison
                checkedJob = mAdapter.getCheckedJob();
                jobA = checkedJob.get(0);
                jobB = checkedJob.get(1);
                System.out.println("in ranking");
                System.out.println(jobA.getTitle());
                System.out.println(jobB.getTitle());

                intent.putExtra("JobA", jobA);
                intent.putExtra("JobB", jobB);
                startActivity(intent);
                break;

            case R.id.buttonCancelComparison:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
        }

    }








}
