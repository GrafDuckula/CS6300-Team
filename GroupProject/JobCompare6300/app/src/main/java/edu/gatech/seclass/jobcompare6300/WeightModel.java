package edu.gatech.seclass.jobcompare6300;

public class WeightModel {

    private int yearlySalaryWeight;
    private int yearlyBonusWeight;
    private int allowedRemoteDaysWeight;
    private int leaveTimeWeight;
    private int gymAllowanceWeight;

    // constructors
    public WeightModel(int yearlySalaryWeight, int yearlyBonusWeight, int leaveTimeWeight,
                       int allowedRemoteDaysWeight, int gymAllowanceWeight) {
        this.yearlySalaryWeight = yearlySalaryWeight;
        this.yearlyBonusWeight = yearlyBonusWeight;
        this.allowedRemoteDaysWeight = allowedRemoteDaysWeight;
        this.leaveTimeWeight = leaveTimeWeight;
        this.gymAllowanceWeight = gymAllowanceWeight;
    }

    public WeightModel(){

    }

    // toString for printing the contents of a class object
    @Override
    public String toString() {
        return "WeightModel{" +
                "yearly_salary_wgt=" + yearlySalaryWeight +
                ", yearly_bonus_wgt=" + yearlyBonusWeight +
                ", leave_time_wgt=" + leaveTimeWeight +
                ", allowed_wkly_remote_wgt=" + allowedRemoteDaysWeight +
                ", gym_allowance_wgt=" + gymAllowanceWeight +
                '}';
    }

    // getters and setters

    public int getYearlySalaryWeight() {
        return yearlySalaryWeight;
    }

    public void setYearlySalaryWeight(int yearlySalaryWeight) {
        this.yearlySalaryWeight = yearlySalaryWeight;
    }

    public int getYearlyBonusWeight() {
        return yearlyBonusWeight;
    }

    public void setYearlyBonusWeight(int yearlyBonusWeight) {
        this.yearlyBonusWeight = yearlyBonusWeight;
    }

    public int getAllowedRemoteDaysWeight() {
        return allowedRemoteDaysWeight;
    }

    public void setAllowedRemoteDaysWeight(int allowedRemoteDaysWeight) {
        this.allowedRemoteDaysWeight = allowedRemoteDaysWeight;
    }

    public int getLeaveTimeWeight() {
        return leaveTimeWeight;
    }

    public void setLeaveTimeWeight(int leaveTimeWeight) {
        this.leaveTimeWeight = leaveTimeWeight;
    }

    public int getGymAllowanceWeight() {
        return gymAllowanceWeight;
    }

    public void setGymAllowanceWeight(int gymAllowanceWeight) {
        this.gymAllowanceWeight = gymAllowanceWeight;
    }
}
