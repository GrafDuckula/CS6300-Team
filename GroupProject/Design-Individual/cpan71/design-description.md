# Assignment 5 Software Design

## Task
Design a job comparision app to compare different job offers

## Requirements and Design Description

Requirements are lists and then designs are explained.
1.  When the app is started, the user is presented with the main menu, which allows the user to (1) enter or edit current job details, (2) enter job offers, (3) adjust the comparison settings, or (4) compare job offers (disabled if no job offers were entered yet1).

    >"MainMenu" class is designed to be an entry point of this app. In the "MainMenu" class, it includes the four functions fot the four purpose. "editCurrentJob()" can enter and edit current job. "enterJobs()" can enter job offers. "adjustComparisionSetting()" uses for adjust the setting. "compareJobs()"is for the purpose of comparing job offers.

2. When choosing to enter current job details, a user will:  
a. Be shown a user interface to enter (if it is the first time) or edit all of the details of their current job, which consist of:

    i. Title  
ii. Company  
iii. Location (entered as city and state)  
iv. Cost of living in the location (expressed as an index)  
v. Yearly salary  
vi. Yearly bonus  
vii. Allowed weekly telework days (expressed as the number of days per
week allowed for remote work, inclusively between 0 and 5)  
viii. Leave time (vacation days and holiday and/or sick leave, as a single overall number of days)  
ix. Gym membership allowance ($0 to $500 annually)  

    >the class "JobManager" is created to manage all the jobs including current jobs. It contains the list of all jobs and a parameter of the current job. It also offers one function "editCurrentJob()" to edit the details of current job.    
    All the jobs including current job are saved through the class "Job". The Job class contains all the details as its attributes, and it offers set() function for editing.

    b. Be able to either save the job details or cancel and exit without saving, returning in both cases to the main menu.
    >"JobManager" offer the function "saveJob()" to save the editing details, it replaces the details of the job selected. "cancelEdit()" can discard editing and set the job as its original details. it also bring back to main menu.

3. When choosing to enter job offers, a user will:  
a. Be shown a user interface to enter all of the details of the offer, which are the same ones listed above for the current job.  
b. Be able to either save the job offer details or cancel.  
c. Be able to (1) enter another offer, (2) return to the main menu, or (3) compare the offer (if they saved it) with the current job details (if present).

    > when entering job offers, the new interface will use "JobManager" call "addJob()" to edit the details of offer. "saveJob()" and "cancelEdit()" can save or cancel editing. Save or cancel will return to the main menu. Calling "addJob()" again can help implement enter another offer. If saved, the job can compare with current job through the class "JobComparision", the saved job will be the attribute "compareJob" and implement the function "compareJobs(currentJob, compareJob)", and the comparision will use setting and weights attributes in class JobComparison for comparing.

4. When adjusting the comparison settings, the user can assign integer weights to:  
a. Yearly salary  
b. Yearly bonus  
c. Allowed weekly telework days  
d. Leave time  
e. Gym membership allowance  
If no weights are assigned, all factors are considered equal.  
    >The four comparison attributes are stored in "JobComparison" class as a list, and the weight are stored in another list. The class offer function adjustWeight() to modify the weights of each attribute.

5. When choosing to compare job offers, a user will:  
a. Be shown a list of job offers, displayed as Title and Company, ranked from best to worst (see below for details), and including the current job (if present), clearly indicated.
b. Select two jobs to compare and trigger the comparison.
c. Be shown a table comparing the two jobs, displaying, for each job:  
i. Title  
ii. Company  
iii. Location  
iv. Yearly salary adjusted for cost of living  
v. Yearly bonus adjusted for cost of living  
vi. Allowed weekly telework days  
vii. Leave time  
viii. Gym Membership Allowance  
d. Be offered to perform another comparison or go back to the main menu.
    >When choosing compare job offers. JobManager will provide the full list of job offers, based on its score which is calculated and stored in "Job" class as one attribute.
    compareJobs can compare the details of the two jobs and show the details. After comparison, GUI buttons can provide to previous job offers, or main menu.

6. When ranking jobs, a job’s score is computed as the weighted sum of:
AYS + AYB + GYM + (LT * AYS / 260) - ((260 - 52 * RWT) * (AYS / 260) / 8)

    >The ranking score of each job is computed in Job Class and stored in Job attribute. The score is used in JobManager class to rank the offers.

7. The user interface must be intuitive and responsive.
    > This will be implemented through GUI implementation.