package com.simpleWeb.model;

import com.simpleWeb.entity.Student;

import java.sql.*;
import java.util.ArrayList;

public class StudentModel {

    public boolean save(Student student) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DBHelper.getConnection();
            String sqlString = "insert into students (name,password,email) values (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getPassword());
            preparedStatement.setString(3, student.getEmail());

            preparedStatement.executeUpdate();
            System.out.println("insert success !");
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("insert failure !");
            return false;
        }
    }

    public ArrayList<Student> getData() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sqlString = "select * from students where status = 1";
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement preparedStatement = DBHelper.getConnection().prepareStatement(sqlString);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                int status = resultSet.getInt("status");
                Student student = new Student(name, password, email);
                student.setStatus(Student.StudentStatus.findByValue(status));
                students.add(student);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println(ex);
        }

        return students;
    }

    public Student login(String name, Student.StudentStatus status) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DBHelper.getConnection();
            String sqlString = "select * from students where name = ? and status = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, status.getValue());

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String rsUserName = resultSet.getString("name");
                String rsPassword = resultSet.getString("password");
                String rsEmail = resultSet.getString("email");

                int rsStatus = resultSet.getInt("status");

                Student student = new Student(rsUserName, rsPassword, rsEmail);
                student.setStatus(Student.StudentStatus.findByValue(rsStatus));
                return student;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean deleteSoft(String name) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DBHelper.getConnection();
            String sqlString = "UPDATE  students set status = ? where name = ?";
            PreparedStatement statement = connection.prepareStatement(sqlString);
            statement.setInt(1, 0);
            statement.setString(2, name);

            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;


    }

    public static void main(String[] args) {
        if (deleteSoft("Dr.Strange")){
            System.out.println("delete success");
        }else {
            System.err.println("method not action");
        }
    }
}
