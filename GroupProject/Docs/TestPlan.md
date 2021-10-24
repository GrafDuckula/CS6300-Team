# Test Plan

**Author**: Team177

### Version 2
###### Changes:
- Removed a test case as the team agreed
- White-box testing in "Test Selection" was removed as the team decided it would be better to use black-box for our code, and manual UI for our business logic.
- Removed Selenium under the technologies to use as the app was simple enough that manually testing the UI covered our test plan without issues


## 1 Testing Strategy

### 1.1 Overall strategy


Unit Testing - Our approach for unit testing will be checking each component in its individual state to make sure it accomplished what we expect to.  Our menu should allow us to select each option without any problems.  Our job manager should allow us to be to get jobs, add job offers with all required values, and if values are missing then prevent user from entering the information.

Integration Testing - Our approach for the integration will be from entrance point of the system to enter a job.  Then from entering a job to comparing a job.  This would provide us with 2 different main areas of the application in which we need to test.

System Testing - For this testing, our functional test would be that our user can enter multiple jobs and compare them both.  Our nonfunctional test would involve allowing the user to store as many job offers as possible in the system.  Another part of our nonfunctional would involve the process of usability for our user to be able to compare job offers on their device.

Regression-Testing - Our strategy to make sure unrelated changes are not impacting other parts of our system would be to perform unit and integration testing to ensure that the module that's being worked on does not have issues and the other modules that interact with others.  Our additional strategy would be to automate this testing for us to have a small sample data that we know the output for to make sure results are consistent with each change.


### 1.2 Test Selection

Black-box Testing - One approach we are planning to utilize is Partition testing for the job offer selection as there are multiple ways a job offer could be presented (no stocks, multiple stocks, equity, bonuses, no bonuses, etc), so we would pick a partition and select options from within it.  For this we would use boundary values such as 0 for no stocks, or maybe 100,000 as an average amount of stocks, etc.


### 1.3 Adequacy Criterion

We will apply the black-box testing concept of Finite State Machines as we are utlizing UML diagram for this.


### 1.4 Bug Tracking

Bugs and enhancement requests will be tracked on github through the issue option of the application.


### 1.5 Technology


JUnit testing will be used to test modules of the system to make sure inputs are correct.  We will utilize manual testing for more UI related for interfact interaction for navigating between menus to see if the flow works as expected.

## 2 Test Cases


| 	Test Case	         |                        Purpose                       |	Steps	                                                                                                                                                                                                                                        | Expected                                                                           | Actual 				 		  	   | Pass/Fail | Optional 	     |
| 	----	                 | ----                                                 |	----                                                                                                                                                                                                                                            | ----                                                                               | ----   				 		  	   | ----      | ----     	     |
| 	Edit Job Selection	 | Black box testing to test the Menu selection         |	1. Open Menu <br /> 2. Make sure editCurrentJob selection is present <br /> 3. Select editCurrentJob <br /> 4. Wait for job manager to show up                                                                                                  | Option selection to navigate user to Job Manager                                   | View opens after selection option 		  	   | PASS      | ------   	     |
| 	Enter a Job Offer	 | Black box testing to test the Menu selection         |	1. Open Menu <br /> 2. Make sure Entering a Job Offer is displayed <br /> 3. Select enter job offer <br /> 4. Make sure Job manager menu opens	                                                                                                | Option selection for entering job offer should navigate user to Job Manager        | View opens after selection option 		  	   | PASS      | ------   	     |
| 	Adjust a Job	         | Black box testing to test the Menu selection         |	1. Open Menu <br /> 2. Make sure Adjust a Job is displayed on menu <br /> 3. Select Adjust a Job	                                                                                                                                        | Job Comparison menu should display for the user                                    | View opens after selection option 		  	   | PASS      | ------   	     |
| 	Comparing a Job	         | Black box testing to test the Menu selection         |	1. Open Menu <br /> 2. Comparing a Job should show up in selection screen <br /> 3. Select Compare a job	                                                                                                                                | Job Comparison Menu should display for the user                                    | View opens after selection option 		  	   | PASS      | ------   	     |
| 	Editing Job Information	 | Black box testing to test the Job Manager selection  |	1. Navigate to Job Manager <br /> 2. Select option to edit current job <br /> 3. Update the information with new values <br /> 4. Save <br /> 5. Select option to Get Job Information	                                                        | User should be able to update job information and save correctly                   | Job information updates correctly 		  	   | PASS      | ------   	     |
| 	Add Job Offer	         | Black box testing to test the Job Manager selection  |	1. Navigate to Job Manager <br /> 2. Select Add Job Offer <br /> 3. Enter information and save <br /> 4. Select option to Get Job Information	                                                                                                | User should be able to add a new job                                               | User is able to add job and success toast displays 	   | PASS      | ------   	     |
| 	Compare Jobs	         | Black box testing to test the Job Comparison menu    |	1. Navigate to Job Comparison Menu <br /> 2. Select option to compare jobs <br /> 3. Select 2 jobs and compare	                                                                                                                                | Should be able to select 2 different jobs and display the information between them | Comparing 2 jobs works as expected and information displays | PASS      | ------   	     |
| 	Adjust Job Weights	 | Black box testing to test the Job Comparison menu    |	1. Navigate to Job Comparison Menu <br /> 2. Select option to adjust job weighting <br /> 3. Select values for job weights for corresponding location <br /> 4. Save <br /> 5. Select option to compare jobs <br /> 6. Select 2 jobs to compare	| Adjusting weight should be saved and display correctly when comparing 2 jobs       | Adjust weight works and saves changes 			   | PASS      | ------   	     |
| 	Ranking Job Offers	 | Black box testing to test the Job Comparison menu    |	1. Navigate to Job Comparison Menu <br /> 2. Select option to Rank Job Offers	                                                                                                                                                                | Ranking Job Offers should all jobs starting from Rank 1                            | Ranking job works as expected 				   | PASS      | ------   	     |
               
