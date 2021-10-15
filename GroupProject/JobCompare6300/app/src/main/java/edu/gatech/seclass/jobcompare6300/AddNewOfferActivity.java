package edu.gatech.seclass.jobcompare6300;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;




public class AddNewOfferActivity extends AppCompatActivity{
    private EditText titleTxt, companyTxt, cityTxt, stateTxt, livingCostTxt, salaryTxt, bonusTxt,
            leaveDaysTxt, teleTxt, gymAllowanceTxt;

    private JobManager jobManager;
    private Job newOffer;

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

    }

    public void handleClick(View view){
        Intent intent;
        System.out.println(view.getId());
        System.out.println(R.id.buttonAddAnotherOffer);
        System.out.println(R.id.buttonMainMenu);
        System.out.println(R.id.buttonSaveOffer);
        System.out.println(R.id.buttonCancelOffer);
        System.out.println(R.id.buttonCompareWithCurrent);
        switch (view.getId()){
            case R.id.buttonAddAnotherOffer:
                saveData();
                intent = new Intent(this, AddNewOfferActivity.class);
                intent.putExtra("jobManager",jobManager);
                startActivity(intent);
                break;
            case R.id.buttonMainMenu:
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

                // need to check if saved first? or just save automatically??

                intent = new Intent(this, JobComparisonActivity.class);
                intent.putExtra("JobB", newOffer);
                intent.putExtra("JobManager", jobManager);
                startActivity(intent);
        }

    }


    private void saveData() {

        Intent i = this.getIntent();
        jobManager = (JobManager) i.getSerializableExtra("jobManager");

        // is this the original instance of Job manager?????
        newOffer = new Job(titleTxt.getText().toString(),
                companyTxt.getText().toString(),
                cityTxt.getText().toString(),
                Integer.parseInt(livingCostTxt.getText().toString()),
                Integer.parseInt(salaryTxt.getText().toString()),
                Integer.parseInt(bonusTxt.getText().toString()),
                Integer.parseInt(leaveDaysTxt.getText().toString()),
                Integer.parseInt(teleTxt.getText().toString()),
                Integer.parseInt(gymAllowanceTxt.getText().toString()));


        jobManager.addNewJobOffer(titleTxt.getText().toString(),
                companyTxt.getText().toString(),
                cityTxt.getText().toString(),
                Integer.parseInt(livingCostTxt.getText().toString()),
                Integer.parseInt(salaryTxt.getText().toString()),
                Integer.parseInt(bonusTxt.getText().toString()),
                Integer.parseInt(leaveDaysTxt.getText().toString()),
                Integer.parseInt(teleTxt.getText().toString()),
                Integer.parseInt(gymAllowanceTxt.getText().toString()));

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

    }




}
