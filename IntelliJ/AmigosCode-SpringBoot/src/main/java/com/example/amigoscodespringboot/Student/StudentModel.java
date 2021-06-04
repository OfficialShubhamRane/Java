package com.example.amigoscodespringboot.Student;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class StudentModel {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String fullName;
    private LocalDate dob;
    private Integer age;
    private String email;

    public StudentModel() {
    }

    public StudentModel(Long id, String fullName, LocalDate dob, Integer age, String email) {
        this.id = id;
        this.fullName = fullName;
        this.dob = dob;
        this.age = age;
        this.email = email;
    }

    public StudentModel(String fullName, LocalDate dob, Integer age, String email) {
        this.fullName = fullName;
        this.dob = dob;
        this.age = age;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String name) {
        this.fullName = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "StudentModel{" +
                "id=" + id +
                ", name='" + fullName + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
