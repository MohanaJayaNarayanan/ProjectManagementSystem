# ProjectManagementSystem
Date Models for managing the poject

Overview
  
  This contains datamodels and functions to perform on a projectManagementSystem
  
Design Consideration
  1) Project is assumed to have a set of tasks which collectively accounts to a total project.
  2) Each task has datamodels of user, resource and timetaken by default.
  3) Each task has particular usertype only and its availability.
  4) Each task has particular ResouceType only and its availability.
  5) Tasks have list of dependent tasks assigned to it.
  6) Function to calculate project completability is decided based on the independent tasks and dependent tasks
  7) To Do :: By default all the resources and user's availablity are set to true.
 
 Executing the application to findout project completion feasibility
    
    ProjectStartup.class has main method which accepts endDate as input in the format "dd/mm/yyyy"
    the result can be obtained
      by downloading the sourcecode
      navigate to {yourpath}\ProjectManagementSystem\out\artifacts
      Run the command as below
          
          sample -  "java -jar ProjectManagementSystem.jar 25/06/2022"
          
 
 
