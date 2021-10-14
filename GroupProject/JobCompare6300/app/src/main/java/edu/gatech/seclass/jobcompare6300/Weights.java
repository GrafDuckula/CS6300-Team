package edu.gatech.seclass.jobcompare6300;

import java.util.ArrayList;
import java.util.Collections;

public class Weights {
    private int yearlySalaryWeight;
    private int yearlyBonusWeight;
    private int allowedRemoteDaysWeight;
    private int leaveTimeWeight;
    private int gymAllowanceWeight;


    public Weights() {
        yearlySalaryWeight = 1;
        yearlyBonusWeight = 1;
        allowedRemoteDaysWeight = 1;
        leaveTimeWeight = 1;
        gymAllowanceWeight = 1;
    }

    public void setWeights(int yearlySalaryWeight, int yearlyBonusWeight, int allowedRemoteDaysWeight,
                           int leaveTimeWeight, int gymAllowanceWeight) {

        this.yearlySalaryWeight = yearlySalaryWeight;
        this.yearlyBonusWeight = yearlyBonusWeight;
        this.allowedRemoteDaysWeight = allowedRemoteDaysWeight;
        this.leaveTimeWeight = leaveTimeWeight;
        this.gymAllowanceWeight = gymAllowanceWeight;

    }

    public ArrayList<Integer> getWeights() {

        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, yearlySalaryWeight, yearlyBonusWeight, allowedRemoteDaysWeight,
                leaveTimeWeight, gymAllowanceWeight);
        return list;
    }

}
