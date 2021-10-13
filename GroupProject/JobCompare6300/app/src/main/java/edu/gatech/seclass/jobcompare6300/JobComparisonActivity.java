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

    public void handleClick(View view){
        Intent intent;
        switch (view.getId()){
            case R.id.buttonBackToMain:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            case R.id.buttonAnotherComparison:
                intent = new Intent(this, JobRankingActivity.class);
                startActivity(intent);
        }

    }

    private void initializeWidgets() {


    }


    private void receiveAndShowData() {
        //RECEIVE DATA FROM ITEMS ACTIVITY VIA INTENT
        Intent i = this.getIntent();
        String jobA = i.getStringExtra("JobA");
        String jobB = i.getStringExtra("JobB");

        //SET DATA TO TEXTVIEWS

    }
}
