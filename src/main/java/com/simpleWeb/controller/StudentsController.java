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

public class StudentsController extends HttpServlet {
    private static StudentModel studentModel = new StudentModel();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Student> students = studentModel.getData();
        req.setAttribute("students", students);
        req.getRequestDispatcher("/member/memberList.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("name");
//        studentModel.deleteSoft(userName);
    }
}
