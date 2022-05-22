package com.solution.enums;

public enum ResourceType {

    CRANE("CRANE"),BRICKHAMMER("BRICKHAMMER"), CHISEL("CHISEL"), PLUMBINGMACHINE("PLUMBINGMACHINE"),
    WELDINGMACHINE("WELDINGMACHINE") ;

    private String value;

    ResourceType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
