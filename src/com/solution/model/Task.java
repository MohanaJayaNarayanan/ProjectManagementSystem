package com.solution.model;

import com.solution.enums.Status;
import com.solution.enums.UserType;

import java.util.Date;
import java.util.List;


public class Task {

    Long taskId;
    String taskName;
    Date startDate;
    Date endDate;
    User user;
    Resource resource;
    Status taskStatus;
    Integer taskOrder;
    List<String> dependencyTasks;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public Status getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Status taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Integer getTaskOrder() {
        return taskOrder;
    }

    public void setTaskOrder(Integer taskOrder) {
        this.taskOrder = taskOrder;
    }

    public Task(String taskName, Integer taskOrder) {
        this.taskName = taskName;
        this.taskOrder = taskOrder;
    }

    public List<String> getDependencyTasks() {
        return dependencyTasks;
    }

    public void setDependencyTasks(List<String> dependencyTasks) {
        this.dependencyTasks = dependencyTasks;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", user=" + user +
                ", resource=" + resource +
                ", taskStatus=" + taskStatus +
                ", taskOrder=" + taskOrder +
                '}';
    }
}
