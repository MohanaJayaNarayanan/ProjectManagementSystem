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
        taskDetails.add(new Task("ConstructionWork"));
        taskDetails.add(new Task("MasonWork"));
        taskDetails.add(new Task("PlumbingWork"));
        taskDetails.add(new Task("WeldingWork"));
        taskDetails.add(new Task("ElectricWork"));
        taskDetails.add(new Task("CarpentarWork"));

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

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Map<Integer, List<Task>> getTaskDependencyDetails() {
        return taskDependencyDetails;
    }

    public void setTaskDependencyDetails(Map<Integer, List<Task>> taskDependencyDetails) {
        this.taskDependencyDetails = taskDependencyDetails;
    }

    public Date getProjectStartDate() {
        return projectStartDate;
    }

    public void setProjectStartDate(Date projectStartDate) {
        this.projectStartDate = projectStartDate;
    }

    public Date getProjectEndDate() {
        return projectEndDate;
    }

    public void setProjectEndDate(Date projectEndDate) {
        this.projectEndDate = projectEndDate;
    }

    public ProjectType getProjectType() {
        return projectType;
    }

    public void setProjectType(ProjectType projectType) {
        this.projectType = projectType;
    }

    public String getProjectOwner() {
        return projectOwner;
    }

    public void setProjectOwner(String projectOwner) {
        this.projectOwner = projectOwner;
    }

    public Status getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(Status projectStatus) {
        this.projectStatus = projectStatus;
    }
}
