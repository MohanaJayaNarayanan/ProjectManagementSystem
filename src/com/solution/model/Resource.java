package com.solution.model;

import com.solution.enums.ResourceType;

/**
 * This class contains the attributes of the resource data model
 */
public class Resource {

    Long resourceId;
    String resourceName;
    ResourceType resourceType;
    Double rent;
    boolean isAvailable;

    public Resource(Long resourceId, String resourceName, ResourceType resourceType, Double rent, boolean isAvailable) {
        this.resourceId = resourceId;
        this.resourceName = resourceName;
        this.resourceType = resourceType;
        this.rent = rent;
        this.isAvailable = isAvailable;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    public Double getRent() {
        return rent;
    }

    public void setRent(Double rent) {
        this.rent = rent;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "resourceId=" + resourceId +
                ", resourceName='" + resourceName + '\'' +
                ", resourceType=" + resourceType +
                ", rent=" + rent +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
