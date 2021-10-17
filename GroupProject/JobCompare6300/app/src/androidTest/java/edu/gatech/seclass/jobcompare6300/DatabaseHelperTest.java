package edu.gatech.seclass.jobcompare6300;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;


public class DatabaseHelperTest {
    DatabaseHelper dbTest;

    @Before
    public void createDB(){
        Context context = ApplicationProvider.getApplicationContext();
        dbTest = new DatabaseHelper(context);
    }

    @Test
    public void addJobTest(){
        Job testJob = new Job("previous", "SWE", "Apple", "Mountain CantView", "CA", 8, 250001, 7000, 0, 5, 250);
        System.out.println(dbTest.getAllJobs().size());
        Assert.assertTrue(dbTest.getAllJobs().size() == 0);
        dbTest.addJob(testJob);
        System.out.println(dbTest.getAllJobs().size());
        Assert.assertTrue(dbTest.getAllJobs().size() == 1);
    }

    @Test
    public void getCurrentJobTest(){
        Job testJob1 = new Job("previous", "SuperChef", "Apple", "Mountain CantView", "CA", 8, 250001, 7000, 0, 5, 250);
        Job testJob2 = new Job("current", "EntryChef", "Apple", "Mountain CantView", "CA", 8, 250001, 7000, 0, 5, 250);

        dbTest.addJob(testJob1);
        dbTest.addJob(testJob2);
        Assert.assertTrue(dbTest.getAllJobs().size() == 3);

        ArrayList<Job> totalJobs = new ArrayList<Job>();
        totalJobs.add(dbTest.getCurrentJob());
        System.out.println(totalJobs.size());
        Assert.assertTrue(totalJobs.size() == 1);
        Job resultJob = totalJobs.get(0);
        System.out.println(resultJob.getTitle());
        Assert.assertEquals(resultJob.getTitle(),"EntryChef");
    }



    @After
    public void closeDB(){
        dbTest.close();
        dbTest = null;
    }


}
