package edu.gatech.seclass.jobcompare6300;

import java.io.Serializable;

public class Job implements Serializable {

    private String status; // current or offer
    private String title;
    private String company;
    private String city;
    private String state;
    private int livingCostIndex;
    private int yearlySalary;
    private int yearlyBonus;
    private int weeklyAllowedRemoteDays; //0-5
    private int leaveTime;
    private int gymAllowance; //0-500
    private int adjustedYearlySalary;
    private int adjustedYearlyBonus;


    public Job( String status, String title, String company, String city, String state, int livingCostIndex,
               int yearlySalary, int yearlyBonus, int weeklyAllowedRemoteDays, int leaveTime, int gymAllowance)
    {

        this.status = status;
        this.title = title;
        this.company = company;
        this.city = city;
        this.state = state;
        this.livingCostIndex = livingCostIndex;
        this.yearlySalary = yearlySalary;
        this.yearlyBonus = yearlyBonus;
        this.weeklyAllowedRemoteDays = weeklyAllowedRemoteDays;
        this.leaveTime = leaveTime;
        this.gymAllowance = gymAllowance;

        this.adjustedYearlySalary = yearlySalary * 100 / livingCostIndex;
        this.adjustedYearlyBonus = yearlyBonus * 100 / livingCostIndex;

    }

    public Job() {
    }

    // return bool ??

    public void editJob(String status, String title, String company, String city, String state, int livingCostIndex,
                        int yearlySalary, int yearlyBonus, int weeklyAllowedRemoteDays, int leaveTime, int gymAllowance)
    {
        // check parameters are valid through frontend main activity before use.
        // allowedRemoteDays and gymAllowance can be 0

        if (title == null || company == null || city == null || state == null) {
            throw new NullPointerException();
        }
//        if (livingCostIndex == 0 || yearlySalary == 0 || yearlyBonus == 0 || leaveTime == 0) {
//            throw new IllegalArgumentException();
//        }
        // should check numbers and refuse input from GUI.
        this.status = "current";
        this.title = title;
        this.company = company;
        this.city = city;
        this.state = state;
        this.livingCostIndex = livingCostIndex;
        this.yearlySalary = yearlySalary;
        this.yearlyBonus = yearlyBonus;
        this.weeklyAllowedRemoteDays = weeklyAllowedRemoteDays;
        this.leaveTime = leaveTime;
        this.gymAllowance = gymAllowance;


        this.adjustedYearlySalary = yearlySalary * 100 / livingCostIndex;
        this.adjustedYearlyBonus = yearlyBonus * 100 / livingCostIndex;


    }

    public int calculateScore(JobComparison setting){
        return setting.getAYS()/setting.getSum() * this.adjustedYearlySalary
                + setting.getAYB()/setting.getSum() * this.adjustedYearlyBonus
                + setting.getGYM()/setting.getSum() * this.gymAllowance
                + setting.getLT()/setting.getSum() * (this.leaveTime * this.adjustedYearlySalary/260)
                + setting.getRWT()/setting.getSum() * ((260 -52 * this.weeklyAllowedRemoteDays) * (this.adjustedYearlySalary/260)/8);
    }

    // getters and setters


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getLivingCostIndex() {
        return livingCostIndex;
    }

    public void setLivingCostIndex(int livingCostIndex) {
        this.livingCostIndex = livingCostIndex;
    }

    public int getYearlySalary() {
        return yearlySalary;
    }
    public int getAdjustedYearlySalary() {
        return adjustedYearlySalary;
    }

    public void setYearlySalary(int yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    public int getYearlyBonus() {
        return yearlyBonus;
    }
    public int getAdjustedYearlyBonus() {
        return adjustedYearlyBonus;
    }

    public void setYearlyBonus(int yearlyBonus) {
        this.yearlyBonus = yearlyBonus;
    }

    public int getWeeklyAllowedRemoteDays() {
        return weeklyAllowedRemoteDays;
    }

    public void setWeeklyAllowedRemoteDays(int weeklyAllowedRemoteDays) {
        this.weeklyAllowedRemoteDays = weeklyAllowedRemoteDays;
    }

    public int getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(int leaveTime) {
        this.leaveTime = leaveTime;
    }

    public int getGymAllowance() {
        return gymAllowance;
    }

    public void setGymAllowance(int gymAllowance) {
        this.gymAllowance = gymAllowance;
    }

}