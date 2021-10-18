package edu.gatech.seclass.jobcompare6300;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class JobComparisonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.job_comparison);
        initializeWidgets();
        receiveAndShowData();
    }

    private JobManager jobMgr = JobManager.getInstance();
    private JobComparison jobComparison = JobComparison.getInstance();

    public void handleClick(View view){
        Intent intent;
        switch (view.getId()){
            case R.id.buttonBackToMainFromComparison:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonAnotherComparison:
                intent = new Intent(this, JobRankingActivity.class);
                startActivity(intent);
        }

    }

    private TextView titleATxt, companyATxt, locationATxt, salaryATxt, bonusATxt, leaveDaysATxt, teleATxt,
            gymAllowanceATxt, titleBTxt, companyBTxt, locationBTxt, salaryBTxt, bonusBTxt, leaveDaysBTxt,
            teleBTxt, gymAllowanceBTxt;



    private void initializeWidgets() {
        titleATxt = findViewById(R.id.titleA);
        companyATxt = findViewById(R.id.companyA);
        locationATxt = findViewById(R.id.locationA);

        salaryATxt = findViewById(R.id.yearlySalaryA);
        bonusATxt = findViewById(R.id.yearlyBonusA);
        leaveDaysATxt = findViewById(R.id.leaveTimeA);
        teleATxt = findViewById(R.id.teleDaysA);
        gymAllowanceATxt = findViewById(R.id.gymAllowanceA);

        titleBTxt = findViewById(R.id.titleB);
        companyBTxt = findViewById(R.id.companyB);
        locationBTxt = findViewById(R.id.locationB);

        salaryBTxt = findViewById(R.id.yearlySalaryB);
        bonusBTxt = findViewById(R.id.yearlyBonusB);
        leaveDaysBTxt = findViewById(R.id.leaveTimeB);
        teleBTxt = findViewById(R.id.teleDaysB);
        gymAllowanceBTxt = findViewById(R.id.gymAllowanceB);

    }


    private void receiveAndShowData() {

        Job jobA = jobComparison.JobOffer_1;
        Job jobB = jobComparison.JobOffer_2;

        titleATxt.setText(jobA.getTitle());
        companyATxt.setText(jobA.getCompany());
        locationATxt.setText(jobA.getCity() + ", " + jobA.getState());

        salaryATxt.setText(Integer.toString(jobA.getAdjustedYearlySalary()));
        bonusATxt.setText(Integer.toString(jobA.getAdjustedYearlyBonus()));
        leaveDaysATxt.setText(Integer.toString(jobA.getLeaveTime()));
        teleATxt.setText(Integer.toString(jobA.getWeeklyAllowedRemoteDays()));
        gymAllowanceATxt.setText(Integer.toString(jobA.getGymAllowance()));

        titleBTxt.setText(jobB.getTitle());
        companyBTxt.setText(jobB.getCompany());
        locationBTxt.setText(jobB.getCity() + ", " + jobB.getState());


        salaryBTxt.setText(Integer.toString(jobB.getAdjustedYearlySalary()));
        bonusBTxt.setText(Integer.toString(jobB.getAdjustedYearlyBonus()));
        leaveDaysBTxt.setText(Integer.toString(jobB.getLeaveTime()));
        teleBTxt.setText(Integer.toString(jobB.getWeeklyAllowedRemoteDays()));
        gymAllowanceBTxt.setText(Integer.toString(jobB.getGymAllowance()));

    }






}


