package com.solution.enums;

public enum ResourceType {

    CRANE("CRANE"),BRICKHAMMER("BRICKHAMMER"), BATTERYDRILL("BATTERYDRILL"), PLUMBINGMACHINE("PLUMBINGMACHINE"),
    WELDINGMACHINE("WELDINGMACHINE"), WOODCUTTER("WOODCUTTER") ;

    private String value;

    ResourceType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
