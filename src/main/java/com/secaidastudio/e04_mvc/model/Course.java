package com.secaidastudio.e04_mvc.model;

/**
 *
 * @author oscar
 */
public class Course {

    private int code;
    private String name;
    private String description;
    private int credits;

    public Course(int code, String name, String description, int credits) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.credits = credits;
    }

    public Course() {      
    }

    
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    
}
