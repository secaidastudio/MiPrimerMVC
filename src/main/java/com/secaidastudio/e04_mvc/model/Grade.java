package com.secaidastudio.e04_mvc.model;

/**
 *
 * @author oscar
 */
public class Grade {
    private int studentCode;
    private int courseCode;
    private double grade;

    public Grade() {
        
    }

    public int getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(int studentCode) {
        this.studentCode = studentCode;
    }

    public int getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(int courseCode) {
        this.courseCode = courseCode;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Grade(int studentCode, int courseCode, double grade) {
        this.studentCode = studentCode;
        this.courseCode = courseCode;
        this.grade = grade;
    }
    
    
}
