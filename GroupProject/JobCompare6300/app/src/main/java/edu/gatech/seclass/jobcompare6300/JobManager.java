package edu.gatech.seclass.jobcompare6300;
import java.io.Serializable;
import java.util.ArrayList;

public class JobManager implements Serializable {

    public ArrayList<Job> jobList;
    private Job currentJob;


    public JobManager(){
        this.jobList = new ArrayList<Job>();
        this.currentJob = null; // or null??
    }

    public boolean editCurrentJob(Job newCurrentJob){
        if (newCurrentJob == null){
            return false;
        }else{
            currentJob = newCurrentJob;
            return true;
        }
    }

    public Job getCurrentJob() {
        return currentJob;
    }

    public void addNewJobOffer(String title, String company, String location, int livingCostIndex,
                               int yearlySalary, int yearlyBonus, int allowedRemoteDays, int leaveTime, int gymAllowance){
        Job newJobOffer = new Job(title, company, location, livingCostIndex, yearlySalary, yearlyBonus, allowedRemoteDays, leaveTime, gymAllowance);
        jobList.add(newJobOffer);

        // do we need to rank the list now?
        
    }
    //.....
}