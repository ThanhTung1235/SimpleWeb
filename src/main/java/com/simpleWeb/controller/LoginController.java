package com.simpleWeb.controller;

import com.simpleWeb.entity.Student;
import com.simpleWeb.model.StudentModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginController extends HttpServlet {
    private StudentModel model = new StudentModel();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        Student student = (Student) httpSession.getAttribute("authentication");
        req.setAttribute("student", student);
        req.getRequestDispatcher("/member/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Student student = model.login(name, Student.StudentStatus.ACTIVE);
        if (student != null) {
            if (student.getPassword().equals(password)) {
                HttpSession session = req.getSession();
                session.setAttribute("authentication", student);
                System.out.println("Login success");
            } else {
                System.out.println("Login failuer");
            }
        }
    }
}
