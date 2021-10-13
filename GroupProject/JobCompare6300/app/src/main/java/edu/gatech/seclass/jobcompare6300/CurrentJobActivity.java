package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CurrentJobActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_job);
    }

    private EditText titleTxt, companyTxt, cityTxt, stateTxt, livingCostTxt, salaryTxt, bonusTxt,
            leaveDaysTxt, teleTxt, gymAllowanceTxt;

    private void initializeWidgets() {
        titleTxt = findViewById(R.id.jobTitle);
        companyTxt = findViewById(R.id.companyName);
        cityTxt = findViewById(R.id.cityLocation);
        stateTxt = findViewById(R.id.stateLocation);
        livingCostTxt = findViewById(R.id.costOfLiving);
        salaryTxt = findViewById(R.id.yearlySalary);
        bonusTxt = findViewById(R.id.yearlyBonus);
        leaveDaysTxt = findViewById(R.id.leaveTime);
        teleTxt = findViewById(R.id.teleDays);
        gymAllowanceTxt = findViewById(R.id.gymAllowance);

    }

    public void handleClick(View view){
        Intent intent;
        switch (view.getId()){
            case R.id.buttonSaveCurrentJob:
                saveData();

            case R.id.buttonCancelCurrentJob:
                reset();
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);

            // need to navigate back to main menu

        }

    }

    private void saveData() {


        Job current = new Job(
                titleTxt.getText().toString(),
                companyTxt.getText().toString(),
                cityTxt.getText().toString(),
                Integer.parseInt(livingCostTxt.getText().toString()),
                Integer.parseInt(salaryTxt.getText().toString()),
                Integer.parseInt(bonusTxt.getText().toString()),
                Integer.parseInt(leaveDaysTxt.getText().toString()),
                Integer.parseInt(teleTxt.getText().toString()),
                Integer.parseInt(gymAllowanceTxt.getText().toString())
        );

        // need to store to job manager

        //

    }

    private void reset(){

    }
}