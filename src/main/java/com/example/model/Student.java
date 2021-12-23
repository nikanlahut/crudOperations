package com.example.model;

import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class Student { //id, isim ve mail olmak üzere 3 fieldlı tablonun objele olarak modellenmesi
    private Integer student_id;
    private String student_name;
    private String student_email;

    public Student(){ //default constructor

    }

    public Student(int student_id, String student_name, String student_email) {

        this.student_id = student_id;
        this.student_name = student_name;
        this.student_email = student_email;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", student_name='" + student_name + '\'' +
                ", student_email='" + student_email + '\'' +
                '}';
    }
}
