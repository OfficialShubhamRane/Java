package com.example.jsp_tutorial.model;

import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
public class User {

    private UUID uuid;
    private String fullName;
    private String password;
    private String confirmPassword;
    private String contactNo;
    private String email;
    private Character gender;
    private String birthdate;
    private String highestEducation;
    private Boolean isMarried;
    private String Note;

    /** Constructor for UUID */
    public User(){
        this.uuid = UUID.randomUUID();
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getfName() {
        return fullName;
    }

    public void setfName(String fName) {
        this.fullName = fName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getProfession() {
        return highestEducation;
    }

    public void setProfession(String profession) {
        this.highestEducation = profession;
    }

    public Boolean getMarried() {
        return isMarried;
    }

    public void setMarried(Boolean married) {
        isMarried = married;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

}
