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
    private JobComparison weights = JobComparison.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adjust_weights);
        initializeWidgets();
        receiveAndShowData();

    }

    public void handleClick(View view){
        Intent intent;
        switch (view.getId()){
            case R.id.buttonSaveWeights:
                saveWeights();
                break;
            case R.id.buttonCancelWeights:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
        }

    }

    private void receiveAndShowData() {
        //RECEIVE DATA FROM ITEMS ACTIVITY VIA INTENT
        Intent i = this.getIntent();


        //SET RECEIVED DATA TO TEXTVIEWS
        salaryWeightsTxt.setText(Integer.toString(weights.getAYS()));
        bonusWeightsTxt.setText(Integer.toString(weights.getAYB()));
        leaveDaysWeightsTxt.setText(Integer.toString(weights.getLT()));
        teleWeightsTxt.setText(Integer.toString(weights.getRWT()));
        gymAllowanceWeightsTxt.setText(Integer.toString(weights.getGYM()));
    }

    private void initializeWidgets() {

        salaryWeightsTxt = findViewById(R.id.yearlySalaryWeights);
        bonusWeightsTxt = findViewById(R.id.yearlyBonusWeights);
        leaveDaysWeightsTxt = findViewById(R.id.leaveTimeWeights);
        teleWeightsTxt = findViewById(R.id.teleDaysWeights);
        gymAllowanceWeightsTxt = findViewById(R.id.gymAllowanceWeights);

    }

    private void saveWeights() {

        weights.setWeight(Integer.parseInt(salaryWeightsTxt.getText().toString()),
                Integer.parseInt(bonusWeightsTxt.getText().toString()),
                Integer.parseInt(gymAllowanceWeightsTxt.getText().toString()),
                Integer.parseInt(leaveDaysWeightsTxt.getText().toString()),
                Integer.parseInt(teleWeightsTxt.getText().toString()));

    }

}
