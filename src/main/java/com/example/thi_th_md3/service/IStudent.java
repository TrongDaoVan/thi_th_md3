package com.example.thi_th_md3.service;

import com.example.thi_th_md3.model.Student;

import java.util.List;

public interface IStudent {
    public List<Student> findAll();

    public Student findById(int id);

    public void add(Student student);

    public boolean edit(Student student);

    public boolean delete(int id);
}
