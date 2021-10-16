package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CurrentJobActivity extends AppCompatActivity {



    private EditText titleTxt, companyTxt, cityTxt, stateTxt, livingCostTxt, salaryTxt, bonusTxt,
            leaveDaysTxt, teleTxt, gymAllowanceTxt;
    // private Job job;
    // delete test job to save in jobManager.currentJob
    // private JobManager jobManager;
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
        System.out.println(view.getId());
        System.out.println(R.id.buttonSaveCurrentJob);
        System.out.println(R.id.buttonCancelCurrentJob);
        switch (view.getId()){

            case R.id.buttonSaveCurrentJob:
                saveData();
                System.out.println("To save");
                intent = new Intent(this, MainActivity.class);
                System.out.println(jobMgr.getCurrentJob());
                startActivity(intent);
                break;

            case R.id.buttonCancelCurrentJob:
                intent = new Intent(this, MainActivity.class);
                System.out.println("To MainActivity");
                startActivity(intent);
        }
    }


    private void receiveAndShowData() {
        //RECEIVE DATA FROM ITEMS ACTIVITY VIA INTENT
        Intent i = this.getIntent();
        Job job = jobMgr.getCurrentJob();

        //SET RECEIVED DATA TO TEXTVIEWS

        if ( job == null) {
            titleTxt.setText("Title");
            companyTxt.setText("Company");
            cityTxt.setText("City");
            livingCostTxt.setText("0");
            salaryTxt.setText("0");
            bonusTxt.setText("0");
            leaveDaysTxt.setText("0");
            teleTxt.setText("0");
            gymAllowanceTxt.setText("0");
        }else {
            titleTxt.setText(job.getTitle());
            companyTxt.setText(job.getCompany());
            cityTxt.setText(job.getLocation());
            livingCostTxt.setText(Integer.toString(job.getLivingCostIndex()));
            salaryTxt.setText(Integer.toString(job.getYearlySalary()));
            bonusTxt.setText(Integer.toString(job.getYearlyBonus()));
            leaveDaysTxt.setText(Integer.toString(job.getLeaveTime()));
            teleTxt.setText(Integer.toString(job.getWeeklyAllowedRemoteDays()));
            gymAllowanceTxt.setText(Integer.toString(job.getGymAllowance()));
        }
    }


    private void saveData() {

        jobMgr.editCurrentJob(
                titleTxt.getText().toString(),
                companyTxt.getText().toString(),
                cityTxt.getText().toString(),
                Integer.parseInt(livingCostTxt.getText().toString()),
                Integer.parseInt(salaryTxt.getText().toString()),
                Integer.parseInt(bonusTxt.getText().toString()),
                Integer.parseInt(teleTxt.getText().toString()),
                Integer.parseInt(leaveDaysTxt.getText().toString()),
                Integer.parseInt(gymAllowanceTxt.getText().toString())
        );

    }

}