package com.example.thi_th_md3.service;

import com.example.thi_th_md3.connection.ConnectionDB;
import com.example.thi_th_md3.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IStudent{

    private Connection connection = ConnectionDB.getConnect();

    private final String SELECT_ALL_STUDENT = "select * from student;";
    private final String SELECT_STUDENT_BY_NAME = "select * from student where name like ?;";
    private final String INSERT_STUDENT = "insert into student (id, name, dateOfBirth, address, phoneNumber, email, classroom) values (?,?,?,?,?,?,?);";
    private final String DELETE_STUDENT = "delete from student where name = 'trong';";
    private final String EDIT_STUDENT = "update student set id = ?, name = ?, dateOfBirth = ?, address = ?, phoneNumber=?, email=?, classroom = ? where id = ?;";

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_STUDENT);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Date dateOfBirth = resultSet.getDate("dateOfBirth");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phoneNumber");
                String email = resultSet.getString("phoneNumber");
                String classroom = resultSet.getString("classroom");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public List<Student> findByName() {
        return null;
    }

    @Override
    public void add(Student student) {

    }

    @Override
    public void edit(int id, Student student) {

    }

    @Override
    public void delete(Student student) {

    }
}
