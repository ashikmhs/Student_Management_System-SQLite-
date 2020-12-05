package com.example.studentmanagementsystem;

public class Student {

    private int id;
    private String name;
    private String studentID;
    private String department;
    private String contact;
    private String gender;

    public Student() {
    }

    public Student(int id, String name, String studentID, String department, String contact, String gender) {
        this.id = id;
        this.name = name;
        this.studentID = studentID;
        this.department = department;
        this.contact = contact;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
