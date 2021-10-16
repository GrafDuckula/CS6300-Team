package edu.gatech.seclass.jobcompare6300;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.Assert;
import org.junit.runner.RunWith;

import java.util.List;

import edu.gatech.seclass.jobcompare6300.Job;

@RunWith(AndroidJUnit4.class)
public class WeightsTest {

    @Test
    public void setWeightsTest(){
        Weights weights = new Weights();
        List<Integer> originalWeights = weights.getWeights();
        weights.setWeights(5,5,5,5,5);
        Assert.assertNotEquals(originalWeights, weights.getWeights());
    }

    @Test
    public void changeSalaryWeightTest(){
        Weights weights = new Weights();
        int originalSalaryWeight = weights.getSalaryWeight();
        weights.setSalaryWeight(20);
        Assert.assertNotEquals(originalSalaryWeight, weights.getSalaryWeight());
    }

    @Test
    public void changeBonusWeightTest(){
        Weights weights = new Weights();
        int originalBonusWeight = weights.getBonusWeight();
        weights.setBonusWeight(20);
        Assert.assertNotEquals(originalBonusWeight, weights.getBonusWeight());
    }

    @Test
    public void changeRemoteWeightTest(){
        Weights weights = new Weights();
        int originalRemoteWeight = weights.getRemoteDayWeight();
        weights.setRemoteDayWeight(20);
        Assert.assertNotEquals(originalRemoteWeight, weights.getRemoteDayWeight());
    }

    @Test
    public void changeLeaveWeightTest(){
        Weights weights = new Weights();
        int originalLeaveWeight = weights.getLeaveWeight();
        weights.setLeaveWeight(20);
        Assert.assertNotEquals(originalLeaveWeight, weights.getLeaveWeight());
    }

    @Test
    public void changeGymWeightTest(){
        Weights weights = new Weights();
        int originalGymWeight = weights.getGymWeight();
        weights.setGymWeight(20);
        Assert.assertNotEquals(originalGymWeight, weights.getGymWeight());
    }


}
