# Team 177 D1 Software Design

## Task
Design a job comparision app to compare different job offers

## Requirements and Design Description

Requirements are lists and then designs are explained.
1.  When the app is started, the user is presented with the main menu, which allows the user to (1) enter or edit current job details, (2) enter job offers, (3) adjust the comparison settings, or (4) compare job offers (disabled if no job offers were entered yet1).

    >"MainMenu" class is designed to be an entry point of this app. In the "MainMenu" class, it includes the four functions for the four purposes. "editCurrentJob()" can enter and edit current job. "enterJobOffers()" can enter job offers. "adjustComparisionSetting()" uses for adjust the setting. "compareJobs()"is for the purpose of comparing job offers.

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

    >The class "JobManager" is created to manage all the job offers and the current jobs. It contains the list of all job offers and a parameter of the current job. It also offers one function "editCurrentJob()" to edit the details of current job.    
    All the job offers and current job are saved through the class "Job". The Job class contains all the details as its attributes, and it offers get(),set() function for showing details and editing.

    b. Be able to either save the job details or cancel and exit without saving, returning in both cases to the main menu.
    >"JobManager" offer the function "saveJob()" to save the editing details, it replaces the details of the job selected. "cancelEdit" can be implemented through GUI, it discards editing and also bring back to main menu.

3. When choosing to enter job offers, a user will:  
a. Be shown a user interface to enter all of the details of the offer, which are the same ones listed above for the current job.  
b. Be able to either save the job offer details or cancel.  
c. Be able to (1) enter another offer, (2) return to the main menu, or (3) compare the offer (if they saved it) with the current job details (if present).

    > When entering job offers, the new interface will use "JobManager" and call "addJobOffer()" to edit the details of offer. "saveJob()". Save or cancel will return to the main menu. Calling "addJobOffer()" again can help implement enter another offer. If saved, the job can compare with current job through the class "JobComparision", the saved job will be the attribute "compareJob" and implement the function "compareJobs(currentJob, compareJob)", and the comparision will use setting and weights attributes in class JobComparison for comparing.

4. When adjusting the comparison settings, the user can assign integer weights to:  
a. Yearly salary  
b. Yearly bonus  
c. Allowed weekly telework days  
d. Leave time  
e. Gym membership allowance  
If no weights are assigned, all factors are considered equal.  
    >The four comparison attributes and weights are stored in a Hashmap. The class offer function adjustWeight() to modify the weights of each attribute.

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
    >When choosing to compare job offers, JobManager will provide the full list of job offers, based on its score which is calculated through JobComparision.
    The function compareJobs() can compare the details of the two jobs and show the details. After comparison, GUI button can link to previous job offers page, or main menu.

6. When ranking jobs, a job’s score is computed as the weighted sum of:
AYS + AYB + GYM + (LT * AYS / 260) - ((260 - 52 * RWT) * (AYS / 260) / 8)

    >The ranking score of each job is computed in JobComparison Class. The score is used to rank the offers stored in listOfJobOffers

7. The user interface must be intuitive and responsive.
    > This will be implemented through GUI implementation.

8. For simplicity, you may assume there is a single system running the app (no communication or saving between devices is necessary).
    > To realize this requirement, all classes are interconnected. 