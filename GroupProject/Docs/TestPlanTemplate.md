# Test Plan

*This is the template for your test plan. The parts in italics are concise explanations of what should go in the corresponding sections and should not appear in the final document.*

**Author**: Team177

## 1 Testing Strategy

### 1.1 Overall strategy

*This section should provide details about your unit-, integration-, system-, and regression-testing strategies. In particular, it should discuss which activities you will perform as part of your testing process, and who will perform such activities.*

Unit Testing - Our approach for unit testing will be checking each component in its individual state to make sure it accomplished what we expect to.  Our menu should allow us to select each option without any problems.  Our job manager should allow us to be to get jobs, add job offers with all required values, and if values are missing then prevent user from entering the information.

Integration Testing - Our approach for the integration will be from entrance point of the system to enter a job.  Then from entering a job to comparing a job.  This would provide us with 2 different main areas of the application in which we need to test.

System Testing - For this testing, our functional test would be that our user can enter multiple jobs and compare them both.  Our nonfunctional test would involve allowing the user to store as many job offers as possible in the system.  Another part of our nonfunctional would involve the process of usability for our user to be able to compare job offers on their device.

Regression-Testing - Our strategy to make sure unrelated changes are not impacting other parts of our system would be to perform unit and integration testing to ensure that the module that's being worked on does not have issues and the other modules that interact with others.  Our additional strategy would be to automate this testing for us to have a small sample data that we know the output for to make sure results are consistent with each change.


### 1.2 Test Selection

*Here you should discuss how you are going to select your test cases, that is, which black-box and/or white-box techniques you will use. If you plan to use different techniques at different testing levels (e.g., unit and system), you should clarify that.*

Black-box Testing - One approach we are planning to utilize is Partition testing for the job offer selection as there are multiple ways a job offer could be presented (no stocks, multiple stocks, equity, bonuses, no bonuses, etc), so we would pick a partition and select options from within it.  For this we would use boundary values such as 0 for no stocks, or maybe 100,000 as an average amount of stocks, etc.

White-box Testing - We would use CFG (Control Flow Graph) and branch coverage to try and get test cases that get 100% branch coverage.

### 1.3 Adequacy Criterion

*Define how you are going to assess the quality of your test cases. Typically, this involves some form of functional or structural coverage. If you plan to use different techniques at different testing levels (e.g., unit and system), you should clarify that.*

We will apply the black-box testing concept of Finite State Machines as we are utlizing UML diagram for this.

### 1.4 Bug Tracking

*Describe how bugs and enhancement requests will be tracked.*

Bugs and enhancement requests will be tracked on github through the issue option of the application.

### 1.5 Technology

*Describe any testing technology you intend to use or build (e.g., JUnit, Selenium).*

JUnit testing will be used to test modules of the system to make sure inputs are correct.  We will utilize manual testing for more UI related for interfact interaction for navigating between menus to see if the flow works as expected.  Selenium will be used to make sure a typical user process is completed successfully (adding a job offer, and retrieving it).

## 2 Test Cases

*This section should be the core of this document. You should provide a table of test cases, one per row. For each test case, the table should provide its purpose, the steps necessary to perform the test, the expected result, the actual result (to be filled later), pass/fail information (to be filled later), and any additional information you think is relevant.*


| 	Test Case	 | Purpose |	Steps	| Expected | Actual | Pass/Fail | Optional |
| 	----	 | ----   |	----   | ----  | ----  | ----   | ---- |
| 	Edit Job Selection	 | Purpose  |	1. Open Menu <br /> 2. Make sure editCurrentJob selection is present <br /> 3. Select editCurrentJob <br /> 4. Wait for job manager to show up | Expected | Actual | Pass/Fail | Optional |
| 	Enter a Job Offer	 | Purpose |	1. Open Menu <br /> 2. Make sure Entering a Job Offer is displayed <br /> 3. Select enter job offer <br /> 4. Make sure Job manager menu opens	| Expected | Actual | Pass/Fail | Optional |
| 	Adjust a Job	 | Purpose |	1. Open Menu <br /> 2. Make sure Adjust a Job is displayed on menu <br /> 3. Select Adjust a Job	| Expected | Actual | Pass/Fail | Optional |
| 	Comparing a Job	 | Purpose |	1. Open Menu <br /> 2. Comparing a Job should show up in selection screen <br /> 3. Select Compare a job	| Expected | Actual | Pass/Fail | Optional |
| 	Getting a Job	 | Purpose |	1. Navigate to Job Manaer <br /> 2. Menu should display an option to get a job or a list of jobs	| Expected | Actual | Pass/Fail | Optional |
| 	Editing Job Information	 | 1. Navigate to Job Manager <br /> 2. Select option to edit current job <br /> 3. Update the information with new values <br /> 4. Save <br /> 5. Select option to Get Job Information |	Steps	| Expected | Actual | Pass/Fail | Optional |
| 	Add Job Offer	 | Purpose |	1. Navigate to Job Manager <br /> 2. Select Add Job Offer <br /> 3. Enter information and save <br /> 4. Select option to Get Job Information	| Expected | Actual | Pass/Fail | Optional |
| 	Compare Jobs	 | Purpose |	1. Navigate to Job Comparison Menu 2. Select option to compare jobs 3. Select 2 jobs and compare	| Expected | Actual | Pass/Fail | Optional |
| 	Adjust Job Weights	 | 1. Navigate to Job Comparison Menu <br /> 2. Select option to adjust job weighting <br /> 3. Select values for job weights for corresponding location <br /> 4. Save <br /> 5. Select option to compare jobs <br /> 6. Select 2 jobs to compare |	Steps	| Expected | Actual | Pass/Fail | Optional |
| 	Ranking Job Offers	 | 1. Navigate to Job Comparison Menu <br /> 2. Select option to Rank Job Offers |	Steps	| Expected | Actual | Pass/Fail | Optional |
               
