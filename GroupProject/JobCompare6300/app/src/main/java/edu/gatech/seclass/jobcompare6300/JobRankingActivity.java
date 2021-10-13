package edu.gatech.seclass.jobcompare6300;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class JobRankingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.job_ranking);
        initializeWidgets();

    }

    private void initializeWidgets() {


    }

    // need adaptor
    // need click listener


    public void handleClick(View view){
        Intent intent;
        switch (view.getId()){
            case R.id.buttonCompareJobs:
                intent = new Intent(this, JobComparisonActivity.class);
                // need to send two Job keys to comparison
                intent.putExtra("JobA",  "A_key");
                intent.putExtra("JobB", "B_key");
                startActivity(intent);

            case R.id.buttonCancelComparison:
                reset();

                // need to be able to navigate back to main menu

        }

    }
    private void reset(){

    }

}
