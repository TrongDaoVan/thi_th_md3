package com.example.thi_th_md3.controller;

import com.example.thi_th_md3.model.Student;
import com.example.thi_th_md3.service.IStudent;
import com.example.thi_th_md3.service.StudentDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/Student")
public class StudentServlet extends HttpServlet {
    private IStudent iStudent = new StudentDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getParameter("action");
    if(action == null){
        action = "";
    }
    switch (action) {
        case "add":
            break;
        case "edit":
            break;
        case "delete":
            break;
        default:
            listStudent(request,response);
            break;
    }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void listStudent(HttpServletRequest request, HttpServletResponse response) {
        List<Student> students = this.iStudent.findAll();
        request.setAttribute("students", students);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/student/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
