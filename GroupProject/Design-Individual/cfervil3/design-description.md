# Design Description



## Requirements

1.	When the app is started, the user is presented with the main menu, which allows the user to (1) enter or edit current job details, (2) enter job offers, (3) adjust the comparison settings, or (4) compare job offers (disabled if no job offers were entered yet ).  
```
To realize this requirement, I added a 'main_menu' that will have those items and interact with them in the GUI implementation. 
```
2.	When choosing to enter current job details, a user will: <ul>
<ul>a.	Be shown a user interface to enter (if it is the first time) or edit all of the details of their current job, which consist of: Title, Company, Location (entered as city and state), Cost of living in the location (expressed as an index), Yearly salary, Yearly bonus, Allowed weekly telework days (expressed as the number of days per week allowed for remote work, inclusively between 0 and 5), Leave time (vacation days and holiday and/or sick leave, as a single overall number of days), Gym membership allowance ($0 to $500 annually)</ul>
<ul>b.	Be able to either save the job details or cancel and exit without saving, returning in both cases to the main menu.</ul></ul>

```
To realize this requirement, I added the 'current_job_details' option which will appear once selected from the menu. It will show the mentioned attributes as well as the functionality to edit, save, or cancel via GUI.
```

3.	When choosing to enter job offers, a user will: 
<ul>a.	Be shown a user interface to enter all of the details of the offer, which are the same ones listed above for the current job.</ul>
<ul>b.	Be able to either save the job offer details or cancel.</ul>
<ul>c.	Be able to (1) enter another offer, (2) return to the main menu, or (3) compare the offer (if they saved it) with the current job details (if present).</ul></ul>

```
To realize this requirement, I added 'job offers' option which will appear once selected from the menu. It will show the option to add a job offer or to return to the main menu. If you have offers already, it will show a list of them upon entering. When you 'add_job_offer', it will take you to another window to enter that information. Upon saving, you can compare it ('compare_current_offer') with your current job details (if current job details is present). You can also cancel ('cancel_offer_details') if you don't want to add it and takes you back to the 'job_offers' window.
```

4.	When adjusting the comparison settings, the user can assign integer weights to:
<ul>a.	Yearly salary</ul>
<ul>b.	Yearly bonus</ul>
<ul>c.	Allowed weekly telework days</ul>
<ul>d.	Leave time</ul>
<ul>e.	Gym membership allowance</ul>
<ul>If no weights are assigned, all factors are considered equal.</ul></ul>


```
To realize this requirement, I added 'adjust_comparison_settings' option which will appear once selected from the menu. It will show the mentioned attributes as well as the functionality to edit, save, or cancel via GUI.
```

5.	When choosing to compare job offers, a user will:
<ul>a.	Be shown a list of job offers, displayed as Title and Company, ranked from best to worst (see below for details), and including the current job (if present), clearly indicated.</ul>
<ul>b.	Select two jobs to compare and trigger the comparison.</ul>
<ul>c.	Be shown a table comparing the two jobs, displaying, for each job: Title, Company, Location, Yearly salary adjusted for cost of living, Yearly bonus adjusted for cost of living, Allowed weekly telework days, inclusively between 0 and 5), Leave time, Gym membership allowance</ul>
<ul>d.	Be offered to perform another comparison or go back to the main menu.</ul></ul>


```
To realize this requirement, I added 'compare_job_offers' which will appear on the menu but will not be accessed if you don't have an offer. To ensure that it has an attribute called 'num_of_job_offers' to check that. Upon entering, it will rank your job offers based on a job score that is calculated using the methodology ('ranking_algo') provided. Afterwards, you can compare two jobs, displaying the attributes mentioned side by side. After the comparison you are given an choice to do another comparison or go back to main menu. 
```

6.	When ranking jobs, a job’s score is computed as the weighted sum of:
<ul>AYS + AYB + GYM + (LT * AYS / 260) - ((260 - 52 * RWT) * (AYS / 260) / 8) where:
AYS = yearly salary adjusted for cost of living
AYB = yearly bonus adjusted for cost of living
GYM = Gym Membership Allowance ($0 to $500 annually)
LT = leave time
RWT = telework days per week
The rationale for the RWT subformula is:</ul>
<ul>a.	value of an employee hour = (AYS / 260) / 8</ul>
<ul>b.	commute hours per year (assuming a 1-hour/day commute) =
1 * (260 - 52 * RWT)</ul>
<ul>c.	therefore travel-time cost = (260 - 52 * RWT) * (AYS / 260) / 8

For example, if the weights are 2 for the yearly salary, 2 for Gym Membership, and 1 for all other factors, the score would be computed as:

2/7 * AYS + 1/7 * AYB + 2/7 * GYM + 1/7 * (LT * AYS / 260) - 1/7 * ((260 - 52 * RWT) * (AYS / 260) / 8)</ul></ul>
```
To realize this requirement, I added 'ranking_algo', which will handle all the calculations and the cost of living adjustments in the background. 
```
7.	The user interface must be intuitive and responsive.
```
This is not represented in my design, as it will be handled entirely within the GUI implementation.
```
8.	For simplicity, you may assume there is a single system running the app (no communication or saving between devices is necessary). 
```
To realize this requirement, all classes are interconnected. 
```
