package com.solution.enums;

public enum ProjectType {

    HIGHPRIORITY("HIGHPRIORITY"),LOWPRIORITY("LOWPRIORITY"), CRITICALPRIORITY("CRITICALPRIORITY");

    private String value;

    ProjectType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
