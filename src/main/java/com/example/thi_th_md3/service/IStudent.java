package com.example.thi_th_md3.service;

import com.example.thi_th_md3.model.Student;

import java.util.List;

public interface IStudent {
    public List<Student> findAll();

    public List<Student> findByName();

    public void add(Student student);

    public void edit(int id, Student student);

    public void delete(Student student);
}
