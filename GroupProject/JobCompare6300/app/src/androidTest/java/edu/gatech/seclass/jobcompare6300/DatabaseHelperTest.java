package edu.gatech.seclass.jobcompare6300;

import android.content.Context;
import android.provider.ContactsContract;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.Assert;

import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.gatech.seclass.jobcompare6300.Job;


public class DatabaseHelperTest {
    DatabaseHelper db;

    @Before
    public void createDB(){
        db = new DatabaseHelper(null);
    }



    @After
    public void closeDB(){
        db.close();
    }


}
