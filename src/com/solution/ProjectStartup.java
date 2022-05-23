package com.solution;

import com.solution.enums.ProjectType;
import com.solution.enums.ResourceType;
import com.solution.enums.Status;
import com.solution.enums.UserType;
import com.solution.model.Project;
import com.solution.model.Resource;
import com.solution.model.Task;
import com.solution.model.User;
import com.solution.service.ProjectService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *  This class contains the actual entry point which collects enddate for calculating the project feasibility and initializes new project
 *
 */
public class ProjectStartup {

    /**Entry point to the application which takes enddate as commandline argument and invokes the project completability function
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        System.out.println("Enter the end date for the completion of project in dd/MM/yyyy format: "+args[0]);

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(args[0]);
        String endDateValue = formatter.format(date);

        Date endDate= null;
        try {
            endDate = new SimpleDateFormat("dd/MM/yyyy").parse(endDateValue);
        } catch (ParseException e) {
            System.out.println("Incorrect Date Format");
            throw new Exception(e.getMessage());
        }

        Project project = new Project(1l,"StandardProject", ProjectType.HIGHPRIORITY,"Adminuser", Status.NEW);

        List<Task> taskList = project.getTasks();
        taskList.stream().forEach(task ->
        {
                if(task.getTaskName().equals("ConstructionWork"))
                {
                    task.setTaskId(1l);
                    task.setUser(initializeUser("ConstructionWork",task.getUser()));
                    task.setTimeTaken(288000l);
                    task.setResource(initializeResource("ConstructionWork",task.getResource()));
                }
                else if(task.getTaskName().equals("MasonWork"))
                {
                    List<String> dependentTask = new ArrayList<>();
                    task.setTaskId(2l);
                    task.setUser(initializeUser("MasonWork",task.getUser()));
                    task.setTimeTaken(230400l);
                    task.setResource(initializeResource("MasonWork",task.getResource()));
                    dependentTask.add("ConstructionWork");
                    task.setDependencyTasks(dependentTask);
                }
                else if(task.getTaskName().equals("PlumbingWork"))
                {
                    List<String> dependentTask = new ArrayList<>();
                    task.setTaskId(3l);
                    task.setUser(initializeUser("PlumbingWork",task.getUser()));
                    task.setTimeTaken(144000l);
                    task.setResource(initializeResource("PlumbingWork",task.getResource()));
                }
                else if(task.getTaskName().equals("WeldingWork"))
                {
                    task.setTaskId(4l);
                    task.setUser(initializeUser("WeldingWork",task.getUser()));
                    task.setTimeTaken(86400l);
                    task.setResource(initializeResource("WeldingWork",task.getResource()));
                }
                else if(task.getTaskName().equals("ElectricWork"))
                {
                    task.setTaskId(5l);
                    task.setUser(initializeUser("ElectricWork",task.getUser()));
                    task.setTimeTaken(115200l);
                    task.setResource(initializeResource("ElectricWork",task.getResource()));
                }
                else if(task.getTaskName().equals("CarpentarWork"))
                {
                    task.setTaskId(6l);
                    task.setUser(initializeUser("CarpentarWork",task.getUser()));
                    task.setTimeTaken(57600l);
                    task.setResource(initializeResource("CarpentarWork",task.getResource()));
                }
        });
        System.out.println(project);

        ProjectService projectService = new ProjectService();

        boolean isProjectCompleteable = projectService.isProjectCompletable(endDate,project);
        System.out.println("Is project can be completed in the given date "+endDate + " :: " +isProjectCompleteable);
    }

    /**
     *Initializes and create the object for resource based on task type
     *
     * @param constructionWork
     * @param resource
     * @return
     */
    private static Resource initializeResource(String constructionWork, Resource resource) {
        if (constructionWork.equalsIgnoreCase("ConstructionWork")) {
            resource = new Resource(1l,"BLUESTAR CRANE", ResourceType.CRANE,5000.00,true);
        }
        else if(constructionWork.equalsIgnoreCase("MasonWork")) {
            resource = new Resource(2l,"ROUNDED HAMMER", ResourceType.BRICKHAMMER,250.00,true);
        }
        else if(constructionWork.equalsIgnoreCase("PlumbingWork")) {
            resource = new Resource(3l,"BLUESTAR", ResourceType.PLUMBINGMACHINE,1000.00,true);
        }
        else if(constructionWork.equalsIgnoreCase("WeldingWork")) {
            resource = new Resource(4l,"BLUESTAR", ResourceType.WELDINGMACHINE,1500.00,true);
        }
        else if(constructionWork.equalsIgnoreCase("ElectricWork")) {
            resource = new Resource(5l,"MAKESHIFT DRILL", ResourceType.BATTERYDRILL,2500.00,true);
        }
        else if(constructionWork.equalsIgnoreCase("CarpentarWork")) {
            resource = new Resource(6l,"STRAIGHT CUTTER", ResourceType.WOODCUTTER,1000.00,true);
        }
        return resource;
    }

    /**
     * Initializes and create the object for user based on task type
     * @param constructionWork
     * @param user
     * @return
     */
    private static User initializeUser(String constructionWork, User user) {
        if(constructionWork.equalsIgnoreCase("ConstructionWork")) {
           user = new User(1l,"CRANE OPERATOR",UserType.CONSTRUCTIONWORKER,1500.00,true);
        }
        else if(constructionWork.equalsIgnoreCase("MasonWork")) {
            user = new User(2l,"admin",UserType.MASON,1000.00,true);
        }
        else if(constructionWork.equalsIgnoreCase("PlumbingWork")) {
            user = new User(3l,"admin",UserType.PLUMBER,3500.00,true);
        }

        else if(constructionWork.equalsIgnoreCase("WeldingWork")) {
            user = new User(4l,"admin",UserType.WELDER,2500.00,true);
        }

        else if(constructionWork.equalsIgnoreCase("ElectricWork")) {
            user = new User(5l,"admin",UserType.ELECTRICIAN,1500.00,true);
        }
        else if(constructionWork.equalsIgnoreCase("CarpentarWork")) {
            user = new User(6l,"admin",UserType.CARPENTER,3000.00,true);
        }
        return user;
    }
}
