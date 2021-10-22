package edu.gatech.seclass.jobcompare6300;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.Assert;
import org.junit.runner.RunWith;

import edu.gatech.seclass.jobcompare6300.Job;

@RunWith(AndroidJUnit4.class)
public class JobTests {

//    @Before
//    public void setUp(){
//        Job testJob = new Job("Chef", "Microsoft", "Mountain View, CA", 5, 250000, 5000, 5, 20, 400);
//    }


//    @Test
//    public void editJobTest(){
//        Job testJob = new Job("current", "SWE", "Apple", "Mountain CantView", "CA", 8, 250001, 7000, 0, 5, 250);
//        String originalTitle = testJob.getTitle();
//        String originalCompany = testJob.getCompany();
//        String originalCity = testJob.getCity();
//        String originalState = testJob.getState();
//        int originalIndex = testJob.getLivingCostIndex();
//        int originalSalary = testJob.getYearlySalary();
//        int originalBonus = testJob.getYearlyBonus();
//        int originalRemote = testJob.getWeeklyAllowedRemoteDays();
//        int originalLeave = testJob.getLeaveTime();
//        int originalGym = testJob.getGymAllowance();
//
//        testJob.editJob("current", "superSWE", "Pear", "Mountain CanView", "TN", 5, 250000, 7001, 5, 8, 350);
//
//        Assert.assertNotEquals(originalTitle, testJob.getTitle());
//        Assert.assertNotEquals(originalCompany, testJob.getCompany());
//        Assert.assertNotEquals(originalCity, testJob.getCity());
//        Assert.assertNotEquals(originalState, testJob.getState());
//        Assert.assertNotEquals(originalIndex, testJob.getLivingCostIndex());
//        Assert.assertNotEquals(originalSalary, testJob.getYearlySalary());
//        Assert.assertNotEquals(originalBonus, testJob.getYearlyBonus());
//        Assert.assertNotEquals(originalRemote, testJob.getWeeklyAllowedRemoteDays());
//        Assert.assertNotEquals(originalLeave, testJob.getLeaveTime());
//        Assert.assertNotEquals(originalGym, testJob.getGymAllowance());
//    }

//    @Test
//    public void calculateScore(){
//        Job testJob = new Job("Chef", "Microsoft", "Mountain View, CA", 5, 250000, 5000, 5, 20, 400);
//
//    }

    @Test
    public void getTitleTest(){
        Job testJob = new Job("current", "Chef", "Microsoft", "Mountain View", "CA", 5, 250000, 5000, 5, 20, 400);
        Assert.assertEquals("Chef", testJob.getTitle());

    }

    @Test
    public void getCompanyTest(){
        Job testJob = new Job("current", "Chef", "Microsoft", "Mountain View", "CA", 5, 250000, 5000, 5, 20, 400);
        Assert.assertEquals("Microsoft", testJob.getCompany());

    }

    @Test
    public void getLocationTest(){
        Job testJob = new Job("current", "Chef", "Microsoft", "Mountain View", "CA", 5, 250000, 5000, 5, 20, 400);
        Assert.assertEquals("Mountain View", testJob.getCity());
        Assert.assertEquals("CA", testJob.getState());
    }

    @Test
    public void getLivingCostIndex(){
        Job testJob = new Job("current", "Chef", "Microsoft", "Mountain View", "CA", 5, 250000, 5000, 5, 20, 400);
        Assert.assertEquals(5, testJob.getLivingCostIndex());
    }

    @Test
    public void getYearlySalary(){
        Job testJob = new Job("current", "Chef", "Microsoft", "Mountain View", "CA", 5, 250000, 5000, 5, 20, 400);
        Assert.assertEquals(250000, testJob.getYearlySalary());
    }

    @Test
    public void getYearlyBonus(){
        Job testJob = new Job("current", "Chef", "Microsoft", "Mountain View", "CA", 5, 250000, 5000, 5, 20, 400);
        Assert.assertEquals(5000, testJob.getYearlyBonus());
    }

    @Test
    public void getWeeklyAllowedRemoteDays(){
        Job testJob = new Job("current", "Chef", "Microsoft", "Mountain View", "CA", 5, 250000, 5000, 5, 20, 400);
        Assert.assertEquals(5, testJob.getWeeklyAllowedRemoteDays());
    }

    @Test
    public void getLeaveTime(){
        Job testJob = new Job("current", "Chef", "Microsoft", "Mountain View", "CA", 5, 250000, 5000, 5, 20, 400);
        Assert.assertEquals(20, testJob.getLeaveTime());
    }

    @Test
    public void getGymAllowance(){
        Job testJob = new Job("current", "Chef", "Microsoft", "Mountain View", "CA", 5, 250000, 5000, 5, 20, 400);
        Assert.assertEquals(400, testJob.getGymAllowance());
    }

}




