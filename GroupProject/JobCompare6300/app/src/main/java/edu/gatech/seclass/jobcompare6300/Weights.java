package edu.gatech.seclass.jobcompare6300;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Weights implements Serializable {
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

    // Get

    public int getSalaryWeight() {

        return yearlySalaryWeight;
    }

    public int getBonusWeight() {

        return yearlyBonusWeight;
    }

    public int getRemoteDayWeight() {

        return allowedRemoteDaysWeight;
    }

    public int getLeaveWeight() {

        return leaveTimeWeight;
    }

    public int getGymWeight() {

        return gymAllowanceWeight;
    }



    //Set

    public void setSalaryWeight(int yearlySalaryWeight) {

        this.yearlySalaryWeight = yearlySalaryWeight;
    }

    public void setBonusWeight(int yearlyBonusWeight) {

        this.yearlyBonusWeight = yearlyBonusWeight;
    }

    public void setRemoteDayWeight(int allowedRemoteDaysWeight) {

        this.allowedRemoteDaysWeight = allowedRemoteDaysWeight;
    }

    public void setLeaveWeight(int leaveTimeWeight) {

        this.leaveTimeWeight = leaveTimeWeight;
    }

    public void setGymWeight(int gymAllowanceWeight) {

        this.gymAllowanceWeight = gymAllowanceWeight;
    }




    public ArrayList<Integer> getWeights() {

        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, yearlySalaryWeight, yearlyBonusWeight, allowedRemoteDaysWeight,
                leaveTimeWeight, gymAllowanceWeight);
        return list;
    }

}
