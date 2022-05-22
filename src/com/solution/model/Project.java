package com.solution.model;

import com.solution.enums.ProjectType;
import com.solution.enums.Status;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Project {

    Long projectId;
    String projectName;
    List<Task> tasks;
    Map<Integer,List<Task>> taskDependencyDetails;
    Date projectStartDate;
    Date projectEndDate;
    ProjectType projectType;
    String projectOwner;
    Status projectStatus;

    public Project(Long projectId, String projectName, ProjectType projectType, String projectOwner, Status projectStatus) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.tasks = setTaskDetails(tasks);
        this.projectType = projectType;
        this.projectOwner = projectOwner;
        this.projectStatus = projectStatus;
    }

    private List<Task> setTaskDetails(List<Task> taskDetails) {
        taskDetails = new ArrayList<>();
        taskDetails.add(new Task("ConstructionWork",1));
        taskDetails.add(new Task("MasonWork",2));
        taskDetails.add(new Task("PlumbingWork",3));
        taskDetails.add(new Task("WeldingWork",4));
        taskDetails.add(new Task("ElectricWork",5));
        taskDetails.add(new Task("CarpentarWork",6));

        return taskDetails;
    }

    public boolean isProjectCompletable(Date deadlineDate)
    {
        return false;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", tasks=" + tasks +
                ", taskDependencyDetails=" + taskDependencyDetails +
                ", projectStartDate=" + projectStartDate +
                ", projectEndDate=" + projectEndDate +
                ", projectType=" + projectType +
                ", projectOwner='" + projectOwner + '\'' +
                ", projectStatus=" + projectStatus +
                '}';
    }
}
