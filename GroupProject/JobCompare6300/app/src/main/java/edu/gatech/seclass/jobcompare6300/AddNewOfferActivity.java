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
            case R.id.buttonAddAnotherOffer:
                saveData();
                intent = new Intent(this, AddNewOfferActivity.class);
                startActivity(intent);
            case R.id.buttonBackToMain:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            case R.id.buttonSaveOffer:
                saveData();

            case R.id.buttonCancelOffer:
                reset();

            case R.id.buttonCompareWithCurrent:
                intent = new Intent(this, JobComparisonActivity.class);
                // need to send two Job keys to comparison
                intent.putExtra("JobA",  "current_key");
                intent.putExtra("JobB", "new_key");
                startActivity(intent);
        }

    }


    private void saveData() {

        Job newOffer = new Job(
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_offer);

        initializeWidgets();


    }


}
