package edu.gatech.seclass.jobcompare6300;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Toast;


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
                System.out.println("To CurrentJobActivity");
                startActivity(intent);
                break;

            case R.id.buttonNewOffer:
                intent = new Intent(this, AddNewOfferActivity.class);
                System.out.println("To AddNewOfferActivity");
                startActivity(intent);
                break;

            case R.id.buttonCompare:

                if ((jobMgr.getCurrentJob() == null && jobMgr.getJobList().size() <= 1 )
                        ||(jobMgr.getCurrentJob() != null && jobMgr.getJobList().size() == 0)){
                    Context context = getApplicationContext();
                    CharSequence text = "Error: less than two jobs to compare";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else{
                    intent = new Intent(this, JobRankingActivity.class);
                    System.out.println("To JobRankingActivity");
                    startActivity(intent);
                }

                break;

            case R.id.buttonSetting:
                intent = new Intent(this, AdjustWeightsActivity.class);
                System.out.println("To AdjustWeightsActivity");
                startActivity(intent);
        }

    }

}