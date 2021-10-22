//package edu.gatech.seclass.jobcompare6300;
//
//import androidx.test.ext.junit.runners.AndroidJUnit4;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.Rule;
//import org.junit.Assert;
//
//import org.junit.runner.RunWith;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import edu.gatech.seclass.jobcompare6300.Job;
//
//
//public class JobManagerTests {
//
//    JobManager jobManager = JobManager.getInstance();
//
//    @Test
//    public void addNewJobOfferTest(){
//        Assert.assertTrue(jobManager.getJobList().size() == 0);
//
//        jobManager.addNewJobOffer("current", "Chef", "Microsoft", "Mountain View", "CA", 5, 250000, 5000, 5, 20, 400);
//        jobManager.addNewJobOffer("previous", "SWE", "Apple", "Mountain CantView", "CA", 8, 250001, 7000, 0, 5, 250);
//
//        Assert.assertTrue(jobManager.getJobList().size() == 2);
//    }
//
//
//    @Test
//    public void editCurrentJob(){
//        Assert.assertTrue(jobManager.getCurrentJob() == null);
//       jobManager.editCurrentJob("current", "Chef", "Microsoft", "Mountain View", "CA", 5, 250000, 5000, 5, 20, 400);
//       String originalJobTitle = jobManager.getCurrentJob().getTitle();
//       Assert.assertTrue(jobManager.getCurrentJob() != null);
//
//        jobManager.editCurrentJob("current", "SuperChef", "Microsoft", "Mountain View", "CA", 5, 250000, 5000, 5, 20, 400);
//        Assert.assertTrue(originalJobTitle != jobManager.getCurrentJob().getTitle());
//    }
//
////    @Test
////    public void rankOffersTest(){
////        JobComparison jobComparison = JobComparison.getInstance();
////        Job offer1 = new Job("Chef", "Microsoft", "Mountain View, CA", 5, 250000, 5000, 5, 20, 400);;
////        Job offer2 = new Job("SWE", "Apple", "Mountain NoView, CA", 8, 250001, 7000, 0, 5, 250);
////        jobComparison.JobOffer_1 = offer1;
////        jobComparison.JobOffer_2 = offer2;
////        jobComparison.setWeight(2,5,15,3,8);
////
////        jobManager.rankOffers(jobComparison);
////
////    }
//
////    @Test   NOT POSSIBLE UNLESS WE ASSIGN CURRENTJOB IN THE ADDNEWJOBOFFER
////    public void getCurrentJobTest(){
////        jobManager.addNewJobOffer("SuperChef", "Microsoft", "Mountain View, CA", 5, 250000, 5000, 5, 20, 400);
////        System.out.println(jobManager.getCurrentJob().getTitle());
////    }
//
//}
