package edu.gatech.seclass.jobcompare6300;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class JobManager implements Serializable {

    private static JobManager instance;


    // Singleton class JobManager can be used in all other class once a new instance is created
    // JobManager jobMgr = JobManager.getInstance(); to get access to this class.
    public static JobManager getInstance() {
        if(instance == null) {
            instance = new JobManager();
        }
        return instance;
    }

    private List<Job> jobOfferList;
    private Job currentJob;
    private Map<Job, Integer> jobScoreMap;

    private JobManager(){
        this.jobOfferList = new ArrayList<>();
        // delete create new and read data from database everytime create instance.
        // this.jobOfferList = JobDataAccessObject.read();
        this.currentJob = null; // or null??
        this.jobScoreMap =  new HashMap<>();
    }


    //When click save in current Job.
    //Enter Current Job if Current Job is null.
    //Edit Current Job if it's not null.
    public void editCurrentJob(String status, String title, String company, String city, String state, int livingCostIndex,
                                  int yearlySalary, int yearlyBonus, int weeklyAllowedRemoteDays, int leaveTime, int gymAllowance){
        if (this.currentJob == null){
            this.currentJob = new Job("current", title, company, city, state, livingCostIndex, yearlySalary, yearlyBonus,
                    weeklyAllowedRemoteDays, leaveTime, gymAllowance);
        }else{
            this.currentJob.editJob(status, title, company, city, state, livingCostIndex, yearlySalary, yearlyBonus,
                    weeklyAllowedRemoteDays, leaveTime, gymAllowance);
        }
    }

    public void addNewJobOffer(String status, String title, String company, String city, String state, int livingCostIndex,
                               int yearlySalary, int yearlyBonus, int weeklyAllowedRemoteDays, int leaveTime, int gymAllowance){
        Job newJobOffer = new Job("offer", title, company, city, state, livingCostIndex, yearlySalary, yearlyBonus,
                weeklyAllowedRemoteDays, leaveTime, gymAllowance);
        jobOfferList.add(newJobOffer);

    }

    public Job getCurrentJob() {
        return currentJob;
    }

    public List<Job> getJobList() {
        return jobOfferList;
    }

    // Before show the list, rank first.
    public void rankOffers(JobComparison settings) {
        for (int i = 0; i < jobOfferList.size(); i++) {
            Job temp_jobOffer = jobOfferList.get(i);
            int score = temp_jobOffer.calculateScore(settings);
            jobScoreMap.put(temp_jobOffer, score);
            Map<Job, Integer> sortedJobOffers =jobScoreMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
            jobScoreMap = sortedJobOffers;
        }
    }

}