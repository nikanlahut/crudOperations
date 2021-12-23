package com.example.dao;

import com.example.model.Student;

import java.util.List;

public interface StudentDAO { //interface
    public int save(Student student);

    public int update(Student student);

    public Student get(Integer student_id);

    public int delete(Integer student_id);

    public List<Student> list();


}
