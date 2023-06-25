package com.example.springbootsecurity.student;

public class Student {
    private final Integer studentId;

    public Integer getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    private final String studentName;

    public Student(Integer studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }
}
