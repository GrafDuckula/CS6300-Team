package edu.gatech.seclass.jobcompare6300;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.test.core.app.ApplicationProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Random;


public class DatabaseHelperTest {
    DatabaseHelper dbTest;
    SQLiteDatabase db;


    @Before
    public void createDB(){
        Context context = ApplicationProvider.getApplicationContext();
        dbTest = DatabaseHelper.getInstance(context);
        db = dbTest.getWritableDatabase();

        db.execSQL("DELETE FROM 'JOBS'");
        db.execSQL("DELETE FROM 'WEIGHTS'");
    }

    @Test
    public void addJobTest(){

        Job testJob = new Job("previous", "SWE", "Apple", "Mountain CantView", "CA", 8, 250001, 7000, 0, 5, 250);
        System.out.println(dbTest.getAllJobs().size());
        Assert.assertTrue(dbTest.getAllJobs().size() == 0);
        dbTest.addJob(testJob);
        System.out.println(dbTest.getAllJobs().size());
        Assert.assertTrue(dbTest.getAllJobs().size() == 1);

        db.execSQL("DELETE FROM 'JOBS'");
        db.execSQL("DELETE FROM 'WEIGHTS'");
    }


    @Test
    public void getCurrentJobTest(){

        Job testJob1 = new Job("previous", "SuperChef", "Apple", "Mountain CantView", "CA", 8, 250001, 7000, 0, 5, 250);
        Job testJob2 = new Job("current", "EntryChef", "Apple", "Mountain CantView", "CA", 8, 250001, 7000, 0, 5, 250);

        dbTest.addJob(testJob1);
        dbTest.addJob(testJob2);
        Assert.assertTrue(dbTest.getAllJobs().size() == 2);

        ArrayList<Job> totalJobs = new ArrayList<Job>();
        totalJobs.add(dbTest.getCurrentJob());
        System.out.println(totalJobs.size());
        Assert.assertTrue(totalJobs.size() == 1);
        Job resultJob = totalJobs.get(0);
        System.out.println(resultJob.getTitle());
        Assert.assertEquals(dbTest.getCurrentJob().getTitle(),"EntryChef");

        db.execSQL("DELETE FROM 'JOBS'");
        db.execSQL("DELETE FROM 'WEIGHTS'");
    }

    @Test
    public void updateCurrentJobTest(){

        Job job1 = new Job("current", "Casting director", "Disney", "Los Angelos", "CA", 144, 150000, 40000, 0, 0, 0);
        dbTest.addJob(job1);
        Assert.assertEquals(dbTest.getCurrentJob().getTitle(), "Casting director");

        Job job2 = new Job("current", "Executive Producer", "HBO", "NEW YORK", "NY", 188, 200000, 80000, 0, 0, 0);
        dbTest.updateCurrentJob(job2);
        Assert.assertEquals(dbTest.getCurrentJob().getTitle(), "Executive Producer");

        db.execSQL("DELETE FROM 'JOBS'");
        db.execSQL("DELETE FROM 'WEIGHTS'");
    }


    @Test
    public void weightDBTest(){

        Weight weight = new Weight();
        Assert.assertEquals(weight.toString(), dbTest.getAllWgts().toString());

        weight.setWeights(1,2,3,4,5);
        dbTest.updateWeights(weight);
        Assert.assertEquals(weight.toString(), dbTest.getAllWgts().toString());

        db.execSQL("DELETE FROM 'JOBS'");
        db.execSQL("DELETE FROM 'WEIGHTS'");

    }


    @Test
    public void updateAllJobScoreTest(){

        // add 100 job offers
        Random rand = new Random();

        for (int i=0; i < 100; i = i+1){
            String status = "offer";
            String title = Integer.toString(rand.nextInt(1000));
            String company = Integer.toString(rand.nextInt(1000));
            String city = Integer.toString(rand.nextInt(1000));
            String state = Integer.toString(rand.nextInt(1000));

            int costIndex = rand.nextInt(200) + 50;
            int salary = rand.nextInt(500000);
            int bonus = rand.nextInt(100000);
            int allowedRemote = rand.nextInt(5);
            int leave = rand.nextInt(60);
            int gymAllow = rand.nextInt(500);;

            Job newJob = new Job(status, title, company, city, state, costIndex,
                    salary, bonus, allowedRemote, leave, gymAllow);

            dbTest.addJob(newJob);
        }

        // set new weight
        Weight weight =  new Weight();
        weight.setWeights(4,3,2,1,0);
        dbTest.updateWeights(weight);
        System.out.println("update weights");
        System.out.println(dbTest.getAllWgts().toString());

        // update all score
        dbTest.updateAllJobScore();
        for (Job job : dbTest.getAllJobs()){
            System.out.println(job.getTitle() + " " + job.getCompany() + " " +job.getScore());
        }

        db.execSQL("DELETE FROM 'JOBS'");
        db.execSQL("DELETE FROM 'WEIGHTS'");

    }


    @After
    public void closeDB(){
        dbTest.close();
        dbTest = null;
    }


}
