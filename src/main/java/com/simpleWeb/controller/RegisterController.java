package com.simpleWeb.controller;

import com.google.gson.Gson;
import com.simpleWeb.entity.Student;
import com.simpleWeb.model.StudentModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegisterController extends HttpServlet {
    private static StudentModel studentModel = new StudentModel();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = new Student();
        req.setAttribute("student", student);
        req.getRequestDispatcher("/member/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        Student student = new Student();
        student.setEmail(email);
        student.setName(name);
        student.setPassword(password);
        studentModel.save(student);
        resp.getWriter().print(new Gson().toJson(student));
    }
}
