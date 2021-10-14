package edu.gatech.seclass.jobcompare6300;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import edu.gatech.seclass.jobcompare6300.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JobManager jobManager = new JobManager();
        Weights weights = new Weights();

        // need to create new job manager, and load all save job data
    }

    public void handleClick(View view){
        Intent intent;
        switch (view.getId()){
            case R.id.buttonNewOffer:
                intent = new Intent(this, AddNewOfferActivity.class);
                startActivity(intent);
            case R.id.buttonCurrent:
                intent = new Intent(this, CurrentJobActivity.class);
                startActivity(intent);
            case R.id.buttonCompare:
                intent = new Intent(this, JobRankingActivity.class);
                startActivity(intent);

            case R.id.buttonSetting:
                intent = new Intent(this, AdjustWeightsActivity.class);
                startActivity(intent);
        }

    }

}