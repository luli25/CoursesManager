package com.finalProject.CoursesManager.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;
    private String name;
    private String professorName;
    @JsonFormat(pattern = "MM-dd-yyyy")
    private Date startDate;

    public Course() {}

    public Course(int ID, String name, String professorName, Date startDate) {
        this.ID = ID;
        this.name = name;
        this.professorName = professorName;
        this.startDate = startDate;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Course{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", professorName='" + professorName + '\'' +
                ", startDate=" + startDate +
                '}';
    }
}
