package com.solution.enums;

/**This doucments status of the project and status
 *
 */
public enum Status {

    NEW("NEW"),INPROGRESS("INPROGRESS"), PENDING("PENDING"), STOPPED("STOPPED"),
    COMPLETED("COMPLETED");

    private String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
