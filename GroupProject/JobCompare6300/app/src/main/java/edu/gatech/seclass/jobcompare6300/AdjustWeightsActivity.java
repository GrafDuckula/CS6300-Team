package edu.gatech.seclass.jobcompare6300;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class AdjustWeightsActivity extends AppCompatActivity {


    private EditText salaryWeightsTxt, bonusWeightsTxt, leaveDaysWeightsTxt, teleWeightsTxt, gymAllowanceWeightsTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adjust_weights);
        initializeWidgets();

    }

    public void handleClick(View view){
        Intent intent;
        switch (view.getId()){
            case R.id.buttonSaveWeights:
                saveWeights();
            case R.id.buttonCancelWeights:
                resetWeights();
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
        }

    }

    private void initializeWidgets() {

        salaryWeightsTxt = findViewById(R.id.yearlySalaryWeights);
        bonusWeightsTxt = findViewById(R.id.yearlyBonusWeights);
        leaveDaysWeightsTxt = findViewById(R.id.leaveTimeWeights);
        teleWeightsTxt = findViewById(R.id.teleDaysWeights);
        gymAllowanceWeightsTxt = findViewById(R.id.gymAllowanceWeights);

    }

    private void saveWeights() {

        // need weights class


    }



    private void resetWeights(){
        salaryWeightsTxt.setText("");
        bonusWeightsTxt.setText("");
        leaveDaysWeightsTxt.setText("");
        teleWeightsTxt.setText("");
        gymAllowanceWeightsTxt.setText("");

    }

}
