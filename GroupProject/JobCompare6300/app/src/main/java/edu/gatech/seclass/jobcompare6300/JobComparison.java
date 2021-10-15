package edu.gatech.seclass.jobcompare6300;
import java.util.HashMap;
import java.util.Map;


public class JobComparison {

    Map<String, Integer> settingMap;
    Job JobOffer_1;
    Job JobOffer_2;

    public JobComparison(){
        this.settingMap = new HashMap<String, Integer>();
        settingMap.put("yearlySalary", 0);
        settingMap.put("yearlyBonus", 0);
        settingMap.put("gymAllowance", 0);
        settingMap.put("leaveTime", 0);
        settingMap.put("weeklyAllowedRemoteDays", 0);

        this.JobOffer_1 = null;
        this.JobOffer_2 = null;
    }

    public void addJobOffer_1(Job jobOffer_1, Job jobOffer_2){
        this.JobOffer_1 = jobOffer_1;
        this.JobOffer_2 = jobOffer_2;
    }

    public void setWeight(int AYS, int AYB, int GYM, int LT, int RWT){
        settingMap.replace("yearlySalary", AYS);
        settingMap.replace("yearlyBonus", AYB);
        settingMap.replace("gymAllowance", GYM);
        settingMap.replace("leaveTime", LT);
        settingMap.replace("weeklyAllowedRemoteDays", RWT);
    }

    public int getSum(){
        return settingMap.get("yearlySalary")
                + settingMap.get("yearlyBonus")
                + settingMap.get("gymAllowance")
                + settingMap.get("leaveTime")
                + settingMap.get("weeklyAllowedRemoteDays");
    }

   public int getAYS(){
        return settingMap.get("yearlySalary");
   }

    public int getAYB(){
        return settingMap.get("yearlyBonus");
    }
    public int getGYM(){
        return settingMap.get("gymAllowance");
    }
    public int getLT(){
        return settingMap.get("leaveTime");
    }
    public int getRWT(){
        return settingMap.get("weeklyAllowedRemoteDays");
    }
}
