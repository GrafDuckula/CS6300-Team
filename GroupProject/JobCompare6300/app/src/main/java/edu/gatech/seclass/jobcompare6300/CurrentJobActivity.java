package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CurrentJobActivity extends AppCompatActivity {



    private EditText titleTxt, companyTxt, cityTxt, stateTxt, livingCostTxt, salaryTxt, bonusTxt,
            leaveDaysTxt, teleTxt, gymAllowanceTxt;

    private boolean err = false;
    private boolean isNew = true;

//    JobManager jobMgr = JobManager.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_job);
        initializeWidgets();
        receiveAndShowData();
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

    }

    public void handleClick(View view){
        Intent intent;

        switch (view.getId()){

            case R.id.buttonSaveCurrentJob:
                saveData();

                if (err){
                    break;
                }else{
                    intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                }

                break;

            case R.id.buttonCancelCurrentJob:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
        }
    }


    private void receiveAndShowData() {

        // read in current job from database, if null moves

        DatabaseHelper databaseHelper = DatabaseHelper.getInstance(CurrentJobActivity.this);
        Job current_job = databaseHelper.getCurrentJob();


        if (current_job == null) {
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
        }else {
            titleTxt.setText(current_job.getTitle());
            companyTxt.setText(current_job.getCompany());
            cityTxt.setText(current_job.getCity());
            stateTxt.setText(current_job.getState());
            livingCostTxt.setText(Integer.toString(current_job.getLivingCostIndex()));
            salaryTxt.setText(Integer.toString(current_job.getYearlySalary()));
            bonusTxt.setText(Integer.toString(current_job.getYearlyBonus()));
            leaveDaysTxt.setText(Integer.toString(current_job.getLeaveTime()));
            teleTxt.setText(Integer.toString(current_job.getWeeklyAllowedRemoteDays()));
            gymAllowanceTxt.setText(Integer.toString(current_job.getGymAllowance()));
            isNew = false;
        }
    }


    private void saveData() {

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

        err = false; // reset


        if (title.equals("")){
            CharSequence text = "Error: please fill in Job title";
            titleTxt.setError(text);
            err = true;
        }

        if (company.equals("")){
            CharSequence text = "Error: please fill in Company name";
            companyTxt.setError(text);
            err = true;
        }

        if (city.equals("")) {
            CharSequence text = "Error: please fill in city";
            cityTxt.setError(text);
            err = true;
        }

        if (livingCost.equals("") || Integer.parseInt(livingCost) == 0 ) {
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
        }

        if (leaveDays.equals("")) {
            CharSequence text = "Error: please fill in the leave days";
            leaveDaysTxt.setError(text);
            err = true;
        }

        if (gymAllowance.equals("")) {
            CharSequence text = "Error: please fill in the gym Allowance per year";
            gymAllowanceTxt.setError(text);
            err = true;
        }


        if (Integer.parseInt(leaveDays) > 365) {
            CharSequence text = "Error: Leave days per year should be less than 365";
            leaveDaysTxt.setError(text);
            err = true;
        }


        if (Integer.parseInt(tele) > 5) {
            CharSequence text = "Error: weekly allowed telework days should be at most 5";
            teleTxt.setError(text);
            err = true;
        }

        if (Integer.parseInt(gymAllowance) > 500) {
            CharSequence text = "Error: Gym allowance per year should be less than 500";
            gymAllowanceTxt.setError(text);
            err = true;
        }


        if (!err){
            String status = "current";
//            jobMgr.editCurrentJob(
//                    status,
//                    title,
//                    company,
//                    city,
//                    state,
//                    Integer.parseInt(livingCost),
//                    Integer.parseInt(salary),
//                    Integer.parseInt(bonus),
//                    Integer.parseInt(tele),
//                    Integer.parseInt(leaveDays),
//                    Integer.parseInt(gymAllowance)
//            );

            Job job;
            job = new Job(
                    status,
                    title,
                    company,
                    city,
                    state,
                    Integer.parseInt(livingCost),
                    Integer.parseInt(salary),
                    Integer.parseInt(bonus),
                    Integer.parseInt(tele),
                    Integer.parseInt(leaveDays),
                    Integer.parseInt(gymAllowance)
            );
            // provide a 'checker' for isNew to decide either to update or add
            DatabaseHelper databaseHelper = DatabaseHelper.getInstance(CurrentJobActivity.this);
            boolean success;
            if (isNew == true) {
                success = databaseHelper.addJob(job);
            } else {
                databaseHelper.updateCurrentJob(job);
                success = true; }

            Toast.makeText(CurrentJobActivity.this, "Success= "+ success, Toast.LENGTH_SHORT).show();


        }


    }

}