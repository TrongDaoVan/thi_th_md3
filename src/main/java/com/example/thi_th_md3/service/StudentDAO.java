package com.example.thi_th_md3.service;

import com.example.thi_th_md3.connection.ConnectionDB;
import com.example.thi_th_md3.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IStudent{

    private Connection connection = ConnectionDB.getConnect();

    private final String SELECT_ALL_STUDENT = "select * from student;";
    private final String SELECT_STUDENT_BY_ID = "select * from student where id = ?;";
    private final String INSERT_STUDENT = "insert into student (id, name, dateOfBirth, address, phoneNumber, email, classroom) values (?,?,?,?,?,?,?);";
    private final String DELETE_STUDENT = "delete from student where id = ? ;";
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
    public Student findById(int id) {
    Student student = null;
    try {
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID); {
    preparedStatement.setInt(1,id);
    ResultSet rs = preparedStatement.executeQuery();

    while (rs.next()) {
        int idd = rs.getInt("id");
        String name = rs.getString("name");
        String dateOfBirth = String.valueOf(rs.getDate("dateOfBirth"));
        String address = rs.getString("address");
        String phoneNumber = rs.getString("phoneNumber");
        String email = rs.getString("email");
        String classroom = rs.getString("classroom");
        student = new Student(idd, name, dateOfBirth, address, phoneNumber, email, classroom);

    }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

        return student;
    }

    @Override
    public void add(Student student) {
        System.out.println(INSERT_STUDENT);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT);
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2,student.getName());
            preparedStatement.setString(3,String.valueOf(student.getDateOfBirth()) );
            preparedStatement.setString(4,student.getAddress());
            preparedStatement.setString(5,student.getPhoneNumber());
            preparedStatement.setString(6,student.getEmail());
            preparedStatement.setString(7,student.getClassroom());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean edit(Student student) {
    boolean edit;
    try {
        PreparedStatement preparedStatement = connection.prepareStatement(EDIT_STUDENT); {
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3,String.valueOf(student.getDateOfBirth()));
            preparedStatement.setString(4, student.getAddress());
            preparedStatement.setString(5, student.getPhoneNumber());
            preparedStatement.setString(6, student.getEmail());
            preparedStatement.setString(7, student.getClassroom());
            edit = preparedStatement.executeUpdate() > 0;

        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return edit;
    }

    @Override
    public boolean delete(int id) {
    boolean deleteStudent;
    try {
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT);
        preparedStatement.setInt(1,id);
        deleteStudent = preparedStatement.executeUpdate() > 0;
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return deleteStudent;
    }
}
