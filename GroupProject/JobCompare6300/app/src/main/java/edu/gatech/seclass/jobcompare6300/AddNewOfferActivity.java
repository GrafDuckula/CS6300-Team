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
    private Button backToMainButton, saveOfferButton, cancelOfferButton, addAnotherOfferButton, compareWithCurrentJobButton;

    //We start by initializing our widgets.
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

        backToMainButton = findViewById(R.id.buttonBackToMain);
        saveOfferButton = findViewById(R.id.buttonSaveOffer);
        cancelOfferButton = findViewById(R.id.buttonCancelOffer);
        addAnotherOfferButton = findViewById(R.id.buttonAddAnotherOffer);
        compareWithCurrentJobButton = findViewById(R.id.buttonCompareWithCurrent);


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
                //
                startActivity(intent);
        }

    }


    private void saveData() {

        // save data
        //...///
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

    public class job{


    }

}
