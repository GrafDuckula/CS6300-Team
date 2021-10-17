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

    JobManager jobMgr = JobManager.getInstance();


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
                System.out.println("To save");

                if (err){
                    break;
                }else{
                    intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                }

                break;

            case R.id.buttonCancelCurrentJob:
                intent = new Intent(this, MainActivity.class);
                System.out.println("To MainActivity");
                startActivity(intent);
        }
    }


    private void receiveAndShowData() {

        Job job = jobMgr.getCurrentJob();

        if (job == null) {
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
            titleTxt.setText(job.getTitle());
            companyTxt.setText(job.getCompany());
            cityTxt.setText(job.getCity());
            stateTxt.setText(job.getState());
            livingCostTxt.setText(Integer.toString(job.getLivingCostIndex()));
            salaryTxt.setText(Integer.toString(job.getYearlySalary()));
            bonusTxt.setText(Integer.toString(job.getYearlyBonus()));
            leaveDaysTxt.setText(Integer.toString(job.getLeaveTime()));
            teleTxt.setText(Integer.toString(job.getWeeklyAllowedRemoteDays()));
            gymAllowanceTxt.setText(Integer.toString(job.getGymAllowance()));
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
            jobMgr.editCurrentJob(
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
        }


    }

}