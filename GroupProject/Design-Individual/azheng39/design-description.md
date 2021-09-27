1. When the app is started, the user is presented with the main menu, which allows the user to (1) enter or edit current job details, (2) enter job offers, (3) adjust the comparison settings, or (4) compare job offers (disabled if no job offers were entered yet).  

     **To realize this requirement, I added a ‘currentJob’ to the User class to track the current job, and a list ‘offerList’ to represent all the offers received. These values are entered by the AddCurrentJob() and AddOffer() method. Compare() method will be used to compare job offers, and setWeight() method in the Weights class was used to set the "weights" for the comparison setting.**
     
2. When choosing to enter current job details, a user will:
    * Be shown a user interface to enter (if it is the first time) or edit all of the details of their current job, which consist of: Title, Company, Location (entered as city and state), Cost of living in the location (expressed as an index), Yearly salary, Yearly bonus, Allowed weekly telework days (expressed as the number of days per week allowed for remote work, inclusively between 0 and 5), Leave time (vacation days and holiday and/or sick leave, as a single overall number of days), Gym membership allowance ($0 to $500 annually)
    * Be able to either save the job details or cancel and exit without saving, returning in both cases to the main menu.

     **To realize this requirement, I added ‘Title’, "Company", "Location", "CostOfLiving", "YearlySalary", "YearlyBonus", "WeeklyRemoteDays", "LeaveTime", "GymAllowance" to the JOB class to represent all of the details of the current job. These values are entered by the EditJob() method, after prompts are handled within the GUI.**
     
3. When choosing to enter job offers, a user will:
    * Be shown a user interface to enter all of the details of the offer, which are the same ones listed above for the current job.
    * Be able to either save the job offer details or cancel.
    * Be able to (1) enter another offer, (2) return to the main menu, or (3) compare the offer (if they saved it) with the current job details (if present).
    
     **To realize this requirement, I added ‘Title’, "Company", "Location", "CostOfLiving", "YearlySalary", "YearlyBonus", "WeeklyRemoteDays", "LeaveTime", "GymAllowance" to the JOB class to represent all of the details of the job offer. These values are entered by the EditJob() method. The other requirements will be handled within the GUI implementation.**

4. When adjusting the comparison settings, the user can assign integer weights to: Yearly salary, Yearly bonus, Allowed weekly telework days, Leave time, Gym membership allowance. If no weights are assigned, all factors are considered equal.

     **To realize this requirement, I added a list 'weights’ to the Weights class to track all five weights. These values are entered by the setWeights() method, after prompts are handled within the GUI.**

5. When choosing to compare job offers, a user will:
    * Be shown a list of job offers, displayed as Title and Company, ranked from best to worst (see below for details), and including the current job (if present), clearly indicated.
    * Select two jobs to compare and trigger the comparison.
    * Be shown a table comparing the two jobs, displaying, for each job: Title, Company, Location, Yearly salary adjusted for cost of living, Yearly bonus adjusted for cost of living, Allowed weekly telework days, Leave time, Gym Membership Allowance
    * Be offered to perform another comparison or go back to the main menu.

     **To realize this requirement, I added a list ‘offerList’ to the User class to track all the offers received and Rank() method to sort all the offers by descending order. To compare two jobs, the Compare() method was added to the User class. The other requirements will be handled within the GUI implementation.**


6. When ranking jobs, a job’s score is computed as the weighted sum of: AYS + AYB + GYM + (LT * AYS / 260) - ((260 - 52 * RWT) * (AYS / 260) / 8)

      **This will be implemented in the Rank() method in the User class.**

7. The user interface must be intuitive and responsive.

      **This is not represented in my design, as it will be handled entirely within the GUI implementation.**

8. For simplicity, you may assume there is a single system running the app (no communication or saving between devices is necessary).

      **This is not represented in my design, as it will be handled entirely within the GUI implementation.**

