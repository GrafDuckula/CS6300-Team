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
    private Weights weights;

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
            case R.id.buttonCancelWeights:
                // resetWeights();
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
        }

    }

    private void receiveAndShowData() {
        //RECEIVE DATA FROM ITEMS ACTIVITY VIA INTENT
        Intent i = this.getIntent();
        weights = (Weights) i.getSerializableExtra("Weights");

        //SET RECEIVED DATA TO TEXTVIEWS
        salaryWeightsTxt.setText(weights.getSalaryWeight());
        bonusWeightsTxt.setText(weights.getBonusWeight());
        leaveDaysWeightsTxt.setText(weights.getLeaveWeight());
        teleWeightsTxt.setText(weights.getRemoteDayWeight());
        gymAllowanceWeightsTxt.setText(weights.getGymWeight());
    }

    private void initializeWidgets() {

        salaryWeightsTxt = findViewById(R.id.yearlySalaryWeights);
        bonusWeightsTxt = findViewById(R.id.yearlyBonusWeights);
        leaveDaysWeightsTxt = findViewById(R.id.leaveTimeWeights);
        teleWeightsTxt = findViewById(R.id.teleDaysWeights);
        gymAllowanceWeightsTxt = findViewById(R.id.gymAllowanceWeights);

    }

    private void saveWeights() {

        weights.setSalaryWeight(Integer.parseInt(salaryWeightsTxt.getText().toString()));
        weights.setBonusWeight(Integer.parseInt(bonusWeightsTxt.getText().toString()));
        weights.setLeaveWeight(Integer.parseInt(leaveDaysWeightsTxt.getText().toString()));
        weights.setRemoteDayWeight(Integer.parseInt(teleWeightsTxt.getText().toString()));
        weights.setGymWeight(Integer.parseInt(gymAllowanceWeightsTxt.getText().toString()));

    }

    private void resetWeights(){
        salaryWeightsTxt.setText("");
        bonusWeightsTxt.setText("");
        leaveDaysWeightsTxt.setText("");
        teleWeightsTxt.setText("");
        gymAllowanceWeightsTxt.setText("");

    }

}
