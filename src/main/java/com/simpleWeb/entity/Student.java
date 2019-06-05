package com.simpleWeb.entity;

public class Student {
    private String Name;
    private String Password;
    private String Email;
    private int Status;

    public Student() {
        this.Name = "";
        this.Password = "";
        this.Email = "";
    }

    public Student(String name, String password, String email) {
        Name = name;
        Password = password;
        Email = email;
    }

    public enum StudentStatus {
        ACTIVE(1), DEACTIVE(0), DELETE(-1);
        int value;

        StudentStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static StudentStatus findByValue(int value) {
            for (StudentStatus status : StudentStatus.values()) {
                if (status.getValue() == value) {
                    return status;
                }
            }
            return null;
        }
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(StudentStatus status) {
        if (status == null) {
            status = StudentStatus.ACTIVE;
        }
    }
}
