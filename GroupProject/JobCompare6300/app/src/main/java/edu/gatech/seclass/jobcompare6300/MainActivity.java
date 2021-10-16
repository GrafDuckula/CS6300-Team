package edu.gatech.seclass.jobcompare6300;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;


public class MainActivity extends AppCompatActivity {

    private JobManager jobMgr = JobManager.getInstance();
    private JobComparison weights = JobComparison.getInstance();

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
//                intent.putExtra("jobManager",jobMgr);
                System.out.println("To CurrentJobActivity");
                startActivity(intent);
                break;

            case R.id.buttonNewOffer:
                intent = new Intent(this, AddNewOfferActivity.class);
//                intent.putExtra("jobManager",jobMgr);
                System.out.println("To AddNewOfferActivity");
                startActivity(intent);
                break;

            case R.id.buttonCompare:
                intent = new Intent(this, JobRankingActivity.class);
//                intent.putExtra("jobManager",jobMgr);
                System.out.println("To JobRankingActivity");
                startActivity(intent);
                break;

            case R.id.buttonSetting:
                intent = new Intent(this, AdjustWeightsActivity.class);
//                intent.putExtra("Weights",weights);
                System.out.println("To AdjustWeightsActivity");
                startActivity(intent);
        }

    }

}