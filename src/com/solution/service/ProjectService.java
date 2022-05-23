package com.solution.service;

import com.solution.model.Project;
import com.solution.model.Task;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/** This class contains the functions needed to perform on the project
 *
 */
public class ProjectService {

    /** This method calculates the dependent task details and independent task details and invokes the method
     * to calculate the feasibility of project completion
     *
     * @param endDate
     * @param project
     * @return
     */
    public boolean isProjectCompletable(Date endDate, Project project) {

        Date currentDate = new Date();
        long daysBetween = ChronoUnit.DAYS.between(currentDate.toInstant(),endDate.toInstant())+2;
        System.out.println("Days between the current and enddate :: "+daysBetween);

        long totalTimeGiven = daysBetween * 8 * 60 * 60 ;
        Long timeTakenToDependentTasks = getTimeToCompleteDependentTask(project);

        List<String> dependentTaskNames = project.getTasks().stream()
                                                            .filter(task -> (null != task.getDependencyTasks())).map(Task::getDependencyTasks).flatMap(List :: stream).collect(Collectors.toList());
        long timeTakenToIndependentTasks = project.getTasks().stream()
                                                              .filter(task -> (null == task.getDependencyTasks())).filter(task -> !dependentTaskNames.contains(task.getTaskName()))
                                                                .map(Task :: getTimeTaken).reduce(0l,Long :: sum);


        System.out.println("Days need for Independent Tasks :: "+timeTakenToIndependentTasks/28800 );
        System.out.println("Days need for dependent Tasks :: "+timeTakenToDependentTasks/28800 );

        boolean isCompletable = calculateProjectFeasibility(totalTimeGiven,timeTakenToIndependentTasks,timeTakenToDependentTasks);


        return isCompletable;
    }

    /**This method calculates time difference between actual time given and time taken to complete the project
     *
     * @param totalTimeGiven
     * @param timeTakenToIndependentTasks
     * @param timeTakenToDependentTasks
     * @return
     */
    private boolean calculateProjectFeasibility(long totalTimeGiven, long timeTakenToIndependentTasks, Long timeTakenToDependentTasks) {

        boolean isCompletable = false;
        long days = totalTimeGiven / 28800;

        if (timeTakenToDependentTasks > 0) {
            if (timeTakenToIndependentTasks > timeTakenToDependentTasks) {
                long timeDifference = timeTakenToIndependentTasks - timeTakenToDependentTasks;
                isCompletable = (totalTimeGiven - (timeTakenToDependentTasks + timeDifference) >= 0 ? true : false);
            }
            else{
                isCompletable = totalTimeGiven - timeTakenToDependentTasks >=0 ? true : false ;
            }
        }
        else{
            isCompletable = totalTimeGiven - timeTakenToIndependentTasks >=0 ? true : false ;
        }

        return isCompletable;
    }

    /**This method calculates total timetaken for completing dependent tasks
     *
     * @param project
     * @return
     */
    private Long getTimeToCompleteDependentTask(Project project) {

        Map<String,List<String>>  dependencyTaskMap = new HashMap<>();
        project.getTasks().forEach(task -> {
            if(Objects.nonNull(task.getDependencyTasks()))
                dependencyTaskMap.put(task.getTaskName(), task.getDependencyTasks());
        });

        List<String> dependentTasks = new ArrayList<>();
        dependentTasks.add(dependencyTaskMap.keySet().stream().findAny().get());
        dependentTasks.add(dependencyTaskMap.values().stream().flatMap(List :: stream).findAny().get());

        long timeTakenToDependentTasks = project.getTasks().stream()
                                            .filter(task -> dependentTasks.contains(task.getTaskName()))
                                                    .map(Task :: getTimeTaken).reduce(0l,Long :: sum);

        return timeTakenToDependentTasks;

    }
}
