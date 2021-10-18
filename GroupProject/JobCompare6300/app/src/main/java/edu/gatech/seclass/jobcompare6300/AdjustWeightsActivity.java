package edu.gatech.seclass.jobcompare6300;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class AdjustWeightsActivity extends AppCompatActivity {


    private EditText salaryWeightsTxt, bonusWeightsTxt, leaveDaysWeightsTxt, teleWeightsTxt, gymAllowanceWeightsTxt;
    private JobComparison weights = JobComparison.getInstance();
    boolean err = false;

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
                if(!err){
                    intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.buttonCancelWeights:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
        }

    }

    private void receiveAndShowData() {

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


        err = false; // reset error

        String salaryWeights = salaryWeightsTxt.getText().toString();
        String bonusWeights = bonusWeightsTxt.getText().toString();
        String gymAllowanceWeights = gymAllowanceWeightsTxt.getText().toString();
        String leaveDaysWeights = leaveDaysWeightsTxt.getText().toString();
        String teleWeights = teleWeightsTxt.getText().toString();


        if (salaryWeights.equals("")) {
            CharSequence text = "Error: please fill in salary weight";
            salaryWeightsTxt.setError(text);
            err = true;
        }

        if (bonusWeights.equals("")) {
            CharSequence text = "Error: please fill in bonus weight";
            bonusWeightsTxt.setError(text);
            err = true;
        }

        if (gymAllowanceWeights.equals("")) {
            CharSequence text = "Error: please fill in gym membership allowance weight";
            gymAllowanceWeightsTxt.setError(text);
            err = true;
        }

        if (leaveDaysWeights.equals("")) {
            CharSequence text = "Error: please fill in leave time weight";
            leaveDaysWeightsTxt.setError(text);
            err = true;
        }

        if (teleWeights.equals("")) {
            CharSequence text = "Error: please fill in allowed weekly telework days Weight";
            teleWeightsTxt.setError(text);
            err = true;
        }

        if (salaryWeights.equals("0") && bonusWeights.equals("0") && gymAllowanceWeights.equals("0") &&
                leaveDaysWeights.equals("0") && teleWeights.equals("0")){
            CharSequence text = "Error: the weights can not all be zero";
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL,0,200);
            toast.show();
            err = true;
        }

        if(!err) {
            weights.setWeight(Integer.parseInt(salaryWeightsTxt.getText().toString()),
                    Integer.parseInt(bonusWeightsTxt.getText().toString()),
                    Integer.parseInt(gymAllowanceWeightsTxt.getText().toString()),
                    Integer.parseInt(leaveDaysWeightsTxt.getText().toString()),
                    Integer.parseInt(teleWeightsTxt.getText().toString()));
        }
    }

}
