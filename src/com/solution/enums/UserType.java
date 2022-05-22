package com.solution.enums;

public enum UserType {

    CONSTRUCTIONWORKER("CONSTRUCTIONWORKER"),MASON("MASON"), PLUMBER("PLUMBER"), WELDER("WELDER"),
    ELECTRICIAN("ELECTRICIAN"), CARPENTER("CARPENTER");

    private String value;

    UserType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
