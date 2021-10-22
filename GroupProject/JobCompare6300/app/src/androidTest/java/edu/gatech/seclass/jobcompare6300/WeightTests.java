package edu.gatech.seclass.jobcompare6300;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class WeightTests {

    private Weight weight = new Weight();

    @Test
    public void setWeightTest(){
        weight.setWeights(1,2,3,4,5);
        Assert.assertEquals(1, weight.getYearlySalaryWeight());
        Assert.assertEquals(2, weight.getYearlyBonusWeight());
        Assert.assertEquals(3, weight.getLeaveTimeWeight());
        Assert.assertEquals(4, weight.getAllowedRemoteDaysWeight());
        Assert.assertEquals(5, weight.getGymAllowanceWeight());
    }

    @Test
    public void setSalaryWeightTest(){
        weight.setYearlySalaryWeight(100);
        Assert.assertEquals(100, weight.getYearlySalaryWeight());
    }

    @Test
    public void setBonusWeightTest(){
        weight.setYearlyBonusWeight(100);
        Assert.assertEquals(100, weight.getYearlyBonusWeight());
    }

    @Test
    public void setRemoteDaysWeightTest(){
        weight.setAllowedRemoteDaysWeight(100);
        Assert.assertEquals(100, weight.getAllowedRemoteDaysWeight());
    }

    @Test
    public void setLeaveTimeWeightTest(){
        weight.setLeaveTimeWeight(100);
        Assert.assertEquals(100, weight.getLeaveTimeWeight());
    }

    @Test
    public void setGymAllowanceTest(){
        weight.setGymAllowanceWeight(100);
        Assert.assertEquals(100, weight.getGymAllowanceWeight());
    }

    @Test
    public void getSumTest(){
        weight.setWeights(1,2,3,4,5);
        Assert.assertEquals(1+2+3+4+5, weight.getSum());
    }





}
