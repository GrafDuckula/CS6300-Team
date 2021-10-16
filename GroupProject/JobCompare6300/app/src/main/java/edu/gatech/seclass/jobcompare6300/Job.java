package edu.gatech.seclass.jobcompare6300;

import java.io.Serializable;

public class Job implements Serializable {
    private String title;
    private String company;
    private String location;
    private int livingCostIndex;
    private int yearlySalary;
    private int yearlyBonus;
    private int weeklyAllowedRemoteDays; //0-5
    private int leaveTime;
    private int gymAllowance; //0-500


    public Job(String title, String company, String location, int livingCostIndex,
               int yearlySalary, int yearlyBonus, int weeklyAllowedRemoteDays, int leaveTime, int gymAllowance)
    {
        this.title = title;
        this.company = company;
        this.location = location;
        this.livingCostIndex = livingCostIndex;
        this.yearlySalary = yearlySalary;
        this.yearlyBonus = yearlyBonus;
        this.weeklyAllowedRemoteDays = weeklyAllowedRemoteDays;
        this.leaveTime = leaveTime;
        this.gymAllowance = gymAllowance;

    }

    // return bool ??

    public void editJob(String title, String company, String location, int livingCostIndex,
                        int yearlySalary, int yearlyBonus, int weeklyAllowedRemoteDays, int leaveTime, int gymAllowance)
    {
        // check parameters are valid through frontend main activity before use.
        // allowedRemoteDays and gymAllowance can be 0

        if (title == null || company == null || location == null) {
            throw new NullPointerException();
        }
//        if (livingCostIndex == 0 || yearlySalary == 0 || yearlyBonus == 0 || leaveTime == 0) {
//            throw new IllegalArgumentException();
//        }
        // should check numbers and refuse input from GUI.
        this.title = title;
        this.company = company;
        this.location = location;
        this.livingCostIndex = livingCostIndex;
        this.yearlySalary = yearlySalary;
        this.yearlyBonus = yearlyBonus;
        this.weeklyAllowedRemoteDays = weeklyAllowedRemoteDays;
        this.leaveTime = leaveTime;
        this.gymAllowance = gymAllowance;

    }

    public int calculateScore(JobComparison setting){
        return setting.getAYS()/setting.getSum() * this.yearlySalary
                + setting.getAYB()/setting.getSum() * this.yearlyBonus
                + setting.getGYM()/setting.getSum() * this.gymAllowance
                + setting.getLT()/setting.getSum() * (this.leaveTime * this.yearlySalary/260)
                + setting.getRWT()/setting.getSum() * ((260 -52 * this.weeklyAllowedRemoteDays) * (this.yearlySalary/260)/8);
    }

    public String getTitle() {
        return this.title;
    }

    public String getCompany() {
        return this.company;
    }

    public String getLocation() {
        return this.location;
    }

    public int getLivingCostIndex(){
        return this.livingCostIndex;
    }

    public int getYearlySalary() {
        return this.yearlySalary;
    }

    public int getYearlyBonus(){
        return this.yearlyBonus;
    }

    public int getWeeklyAllowedRemoteDays() {
        return this.weeklyAllowedRemoteDays;
    }

    public int getLeaveTime() {
        return this.leaveTime;
    }

    public int getGymAllowance() {
        return this.gymAllowance;
    }


}