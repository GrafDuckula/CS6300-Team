package edu.gatech.seclass.jobcompare6300;

public class Job {
    private String title;
    private String company;
    private String location;
    private int livingCostIndex;
    private int yearlySalary;
    private int yearlyBonus;
    private int allowedRemoteDays; //0-5
    private int leaveTime;
    private int gymAllowance; //0-500


    public Job(String title, String company, String location, int livingCostIndex,
               int yearlySalary, int yearlyBonus, int allowedRemoteDays, int leaveTime, int gymAllowance)
    {
        this.title = title;
        this.company = company;
        this.location = location;
        this.livingCostIndex = livingCostIndex;
        this.yearlySalary = yearlySalary;
        this.yearlyBonus = yearlyBonus;
        this.allowedRemoteDays = allowedRemoteDays;
        this.leaveTime = leaveTime;
        this.gymAllowance = gymAllowance;

    }

    // return bool ??

    public void editJob(String title, String company, String location, int livingCostIndex,
                        int yearlySalary, int yearlyBonus, int allowedRemoteDays, int leaveTime, int gymAllowance)
    {
        // check parameters are valid through frontend main activity before use.
        // allowedRemoteDays and gymAllowance can be 0

        if (title == null || company == null || location == null) {
            throw new NullPointerException();
        }
        if (livingCostIndex == 0 || yearlySalary == 0 || yearlyBonus == 0 || leaveTime == 0) {
            throw new IllegalArgumentException();
        }
        this.title = title;
        this.company = company;
        this.location = location;
        this.livingCostIndex = livingCostIndex;
        this.yearlySalary = yearlySalary;
        this.yearlyBonus = yearlyBonus;
        this.allowedRemoteDays = allowedRemoteDays;
        this.leaveTime = leaveTime;
        this.gymAllowance = gymAllowance;

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

    public int getAllowedRemoteDays() {
        return allowedRemoteDays;
    }

    public int getLeaveTime() {
        return leaveTime;
    }

    public int getGymAllowance() {
        return gymAllowance;
    }


}