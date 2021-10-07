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

### 1.3 Adequacy Criterion

*Define how you are going to assess the quality of your test cases. Typically, this involves some form of functional or structural coverage. If you plan to use different techniques at different testing levels (e.g., unit and system), you should clarify that.*

### 1.4 Bug Tracking

*Describe how bugs and enhancement requests will be tracked.*

Bugs and enhancement requests will be tracked on github through the issue option of the application.

### 1.5 Technology

*Describe any testing technology you intend to use or build (e.g., JUnit, Selenium).*

## 2 Test Cases

*This section should be the core of this document. You should provide a table of test cases, one per row. For each test case, the table should provide its purpose, the steps necessary to perform the test, the expected result, the actual result (to be filled later), pass/fail information (to be filled later), and any additional information you think is relevant.*


| 	Test Case	 | Purpose |	Steps	| Expected | Actual | Pass/Fail | Optional |
| --------------- |:----:| :----:  |:----:      | :----:   |:----:  | :----:    |:----:    |
