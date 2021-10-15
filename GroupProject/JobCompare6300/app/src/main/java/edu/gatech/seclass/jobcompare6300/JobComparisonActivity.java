package edu.gatech.seclass.jobcompare6300;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class JobComparisonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.job_comparison);
        initializeWidgets();
        receiveAndShowData();

    }

    private JobManager jobManager;

    public void handleClick(View view){
        Intent intent;
        switch (view.getId()){
            case R.id.buttonBackToMainFromComparison:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonAnotherComparison:
                intent = new Intent(this, JobRankingActivity.class);
                intent.putExtra("jobManager",jobManager);
                startActivity(intent);
        }

    }

    private void initializeWidgets() {


    }


    private void receiveAndShowData() {
        //RECEIVE DATA FROM ITEMS ACTIVITY VIA INTENT
        Intent i = this.getIntent();

        //SET DATA TO TEXTVIEWS

    }
}
