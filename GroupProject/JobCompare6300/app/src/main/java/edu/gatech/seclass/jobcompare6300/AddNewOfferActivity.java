package edu.gatech.seclass.jobcompare6300;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;

public class AddNewOfferActivity extends AppCompatActivity{
    private EditText titleTxt, companyTxt, cityTxt, stateTxt, livingCostTxt, salaryTxt, bonusTxt,
            leaveDaysTxt, teleTxt, gymAllowanceTxt;

    private Job newOffer;

    private boolean err = false;
    private boolean tempSaved = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_offer);
        initializeWidgets();
    }

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

        titleTxt.setText("");
        companyTxt.setText("");
        cityTxt.setText("");
        stateTxt.setText("");
        livingCostTxt.setText("");
        salaryTxt.setText("");
        bonusTxt.setText("");
        leaveDaysTxt.setText("");
        teleTxt.setText("");
        gymAllowanceTxt.setText("");
    }

    public void handleClick(View view){
        Intent intent;
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;

        // get the current job from the db
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance(AddNewOfferActivity.this);
        Job current_job = databaseHelper.getCurrentJob();

        switch (view.getId()){
            case R.id.buttonAddAnotherOffer:
                if (tempSaved){
                    saveToDB();
                    intent = new Intent(this, AddNewOfferActivity.class);
                    startActivity(intent);
                } else{
                    CharSequence text = "Error: Please SAVE the offer first";
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                break;

            case R.id.buttonMainMenu:
                if (tempSaved){
                    saveToDB();}
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;

            case R.id.buttonSaveOffer:
                saveData();
                break;

            case R.id.buttonCancelOffer:
                reset();
                break;

            case R.id.buttonCompareWithCurrent:
                if(current_job == null){
                    CharSequence text = "Error: Please add current job first";
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else if (tempSaved){
                    saveToDB();
                    intent = new Intent(this, JobComparisonActivity.class);
                    intent.putExtra("JobA", current_job);
                    intent.putExtra("JobB", newOffer);
                    startActivity(intent);
                }else{
                    CharSequence text = "Error: Please SAVE the offer first";
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
        }
    }


    private void saveData() {

        err = false; // reset error

        String title = titleTxt.getText().toString();
        String company = companyTxt.getText().toString();
        String city = cityTxt.getText().toString();
        String state = stateTxt.getText().toString();
        String livingCost = livingCostTxt.getText().toString();
        String salary = salaryTxt.getText().toString();
        String bonus = bonusTxt.getText().toString();
        String tele = teleTxt.getText().toString();
        String leaveDays = leaveDaysTxt.getText().toString();
        String gymAllowance = gymAllowanceTxt.getText().toString();


        if (title.equals("")) {
            CharSequence text = "Error: please fill in Job title";
            titleTxt.setError(text);
            err = true;
        }

        if (company.equals("")) {
            CharSequence text = "Error: please fill in Company name";
            companyTxt.setError(text);
            err = true;
        }

        if (city.equals("")) {
            CharSequence text = "Error: please fill in city";
            cityTxt.setError(text);
            err = true;
        }

        if (state.equals("")) {
            CharSequence text = "Error: please fill in state";
            cityTxt.setError(text);
            err = true;
        }

        if (livingCost.equals("") || Integer.parseInt(livingCost) <= 0) {
            CharSequence text = "Error: please fill in the living cost INDEX";
            livingCostTxt.setError(text);
            err = true;
        }

        if (salary.equals("")) {
            CharSequence text = "Error: please fill in the salary";
            salaryTxt.setError(text);
            err = true;
        }

        if (bonus.equals("")) {
            CharSequence text = "Error: please fill in the bonus";
            bonusTxt.setError(text);
            err = true;
        }

        if (tele.equals("")) {
            CharSequence text = "Error: please fill in the weekly allowed telework days";
            teleTxt.setError(text);
            err = true;
        }else if (Integer.parseInt(tele) > 5) {
            CharSequence text = "Error: weekly allowed telework days should be at most 5";
            teleTxt.setError(text);
            err = true;
        }

        if (leaveDays.equals("")) {
            CharSequence text = "Error: please fill in the leave days";
            leaveDaysTxt.setError(text);
            err = true;
        }else if (Integer.parseInt(leaveDays) > 365) {
            CharSequence text = "Error: Leave days per year should be less than 365";
            leaveDaysTxt.setError(text);
            err = true;
        }

        if (gymAllowance.equals("")) {
            CharSequence text = "Error: please fill in the gym Allowance per year";
            gymAllowanceTxt.setError(text);
            err = true;
        }else if (Integer.parseInt(gymAllowance) > 500) {
            CharSequence text = "Error: Gym allowance per year should be less than 500";
            gymAllowanceTxt.setError(text);
            err = true;
        }

        if (!err) {
            newOffer = new Job("offer", titleTxt.getText().toString(),
                    companyTxt.getText().toString(),
                    cityTxt.getText().toString(),
                    stateTxt.getText().toString(),
                    Integer.parseInt(livingCostTxt.getText().toString()),
                    Integer.parseInt(salaryTxt.getText().toString()),
                    Integer.parseInt(bonusTxt.getText().toString()),
                    Integer.parseInt(leaveDaysTxt.getText().toString()),
                    Integer.parseInt(teleTxt.getText().toString()),
                    Integer.parseInt(gymAllowanceTxt.getText().toString()));
            tempSaved = true;

        }
    }

    private void saveToDB(){

        DatabaseHelper databaseHelper = DatabaseHelper.getInstance(AddNewOfferActivity.this);
        boolean success = databaseHelper.addJob(newOffer);
        Toast.makeText(AddNewOfferActivity.this, "Success= "+ success, Toast.LENGTH_SHORT).show();

    }


    private void reset(){
        titleTxt.setText("");
        companyTxt.setText("");
        cityTxt.setText("");
        stateTxt.setText("");
        livingCostTxt.setText("");
        salaryTxt.setText("");
        bonusTxt.setText("");
        leaveDaysTxt.setText("");
        teleTxt.setText("");
        gymAllowanceTxt.setText("");

        tempSaved = false;
    }

}
