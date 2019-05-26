package com.secaidastudio.e04_mvc.model;

import java.util.Date;

/**
 *
 * @author oscar
 */
public class Student {
    private int code;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String contactPhone;
    private String guardian;
    private Date birthday;

    public Student(int code, String firstName, String lastName, String gender, String email, String contactPhone, String guardian, Date birthday) {
        this.code = code;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.contactPhone = contactPhone;
        this.guardian = guardian;
        this.birthday = birthday;
    }

    public Student() {        
    }

    

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getGuardian() {
        return guardian;
    }

    public void setGuardian(String guardian) {
        this.guardian = guardian;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
    
    
}
