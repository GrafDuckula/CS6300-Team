# Design Discussion


## Design 1 
Pros: Has an entry point, has the necessary attributes and methods

Cons: Basic level class diagram, needs additional classes 

<img src="./images/design1.PNG" width="323" height="400"> 

## Design 2
Pros: Has an entry point, level of detail

Cons: Can consolidate some classes, class naming conventions, did not set correct attribute visibility

<img src="./images/design2.PNG" width="573" height="400"> 

## Design 3 
Pros: Beautiful design, concise

Cons: Lacks a connection between classes *JobManager* and *JobComparison*  

<img src="./images/design3.PNG" width="826" height="400"> 

## Design 4
Pros: Has an entry point, clear design

Cons: Lack of detail, lack of attribute visibility indicators, organization of classes between Jobs and addedDetails

<img src="./images/design4.PNG" width="519" height="400"> 

## Team Design
<img src="./images/design5.PNG" width="770" height="400"> 

Some of the main commonalities were having the main menu as the entry point, establishing *Job* as its own class, and various attributes needed. We had different views on where certain method/operations should be housed. For our Team Design, we wanted a clear design with a certain level of detail. As a result, we decided to use Design 3 has our base and then add some modifications to it. We changed some methods around that we felt were better in another class or not needed at all. Some examples were:
1. Removing *jobScore* attribute from the *Job* class
2. Relocating *computeScore()* method from the *Job* class to the *JobComparison* class
3. Relocating *rankJob()* method (renamed *rankJobOffers()*) from the *JobManager* class to the *JobComparison* class 


## Summary
Some of the lessons learned were attribute visibility, necessary connections between certain classes, and class dependencies.