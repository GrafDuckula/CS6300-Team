package edu.gatech.seclass.jobcompare6300;

public class JobModel {

    private int id;
    private String status; // current or offer
    private String title;
    private String company;
    private String location;
    private int livingCostIndex;
    private int yearlySalary;
    private int yearlyBonus;
    private int weeklyAllowedRemoteDays; //0-5
    private int leaveTime;
    private int gymAllowance; //0-500

    public JobModel(int id, String status, String title, String company, String location,
                    int livingCostIndex, int yearlySalary, int yearlyBonus, int weeklyAllowedRemoteDays,
                    int leaveTime, int gymAllowance)
    {
        this.id = id;
        this.status = status;
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

    public JobModel(){

    }

    // toString for printing the contents of a class object
    @Override
    public String toString() {
        return "JobModel{" +
                "id=" + id +
                ", status=" + status +
                ", title=" + title +
                ", company=" + company +
                ", location=" + location +
                ", living_cost_index=" + livingCostIndex +
                ", yearly_salary=" + yearlySalary +
                ", yearly_bonus=" + yearlyBonus +
                ", weekly_allowed_remote_days=" + weeklyAllowedRemoteDays +
                ", leave_time=" + leaveTime +
                ", gym_allowance=" + gymAllowance +
                '}';
    }


    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public void setYearlySalary(int yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    public int getYearlyBonus() {
        return yearlyBonus;
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
