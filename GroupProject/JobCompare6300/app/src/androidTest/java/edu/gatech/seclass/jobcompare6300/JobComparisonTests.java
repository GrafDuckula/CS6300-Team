package edu.gatech.seclass.jobcompare6300;

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

public class JobComparisonTests {
    JobComparison jobcompare;
    Job offerOneTest;
    Job offerTwoTest;

    @Before
    public void setUp(){
        jobcompare = JobComparison.getInstance();
        offerOneTest = new Job("current", "Chef", "Microsoft", "Mountain View", "CA", 5, 250000, 5000, 5, 20, 400);
        offerTwoTest = new Job("previous", "SWE", "Apple", "Mountain CantView", "CA", 8, 250001, 7000, 0, 5, 250);
    }

    @Test
    public void addJobOfferTest(){
        Assert.assertNull(jobcompare.JobOffer_1);
        Assert.assertNull(jobcompare.JobOffer_2);

        jobcompare.JobOffer_1 = offerOneTest;
        jobcompare.JobOffer_2 = offerTwoTest;

        Assert.assertNotNull(jobcompare.JobOffer_1);
        Assert.assertNotNull(jobcompare.JobOffer_2);
    }


    @Test
    public void setWeightTest(){
        Map<String,Integer> originalWeights = new HashMap<>(jobcompare.settingMap);
        jobcompare.setWeight(5, 5, 5 ,5, 5);
        Assert.assertTrue(originalWeights.get("yearlySalary") != jobcompare.getAYS());
        Assert.assertTrue(originalWeights.get("yearlyBonus") != jobcompare.getAYB());
        Assert.assertTrue(originalWeights.get("gymAllowance") != jobcompare.getGYM());
        Assert.assertTrue(originalWeights.get("leaveTime") != jobcompare.getLT());
        Assert.assertTrue(originalWeights.get("weeklyAllowedRemoteDays") != jobcompare.getRWT());
    }

    @Test
    public void getSumTest(){
        Map<String,Integer> originalWeights = new HashMap<>(jobcompare.settingMap);
        jobcompare.setWeight(5, 5, 5 ,5, 5);

        int originalSum = 0;

        for (String key: originalWeights.keySet()) {
            int value = originalWeights.get(key);
            originalSum += value;
        }

        Assert.assertTrue(originalSum != jobcompare.getSum());

    }

    @After
    public void setDefaultJobComparison(){
        jobcompare.setWeight(0, 0, 0, 0, 0);
    }


}
