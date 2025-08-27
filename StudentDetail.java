package com.sa.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "student_detail")
public class StudentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sd_id")
    private int id;
    private String college;
    private Double cgpa;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    @Override
    public String toString() {
        return "StudentDetail{" +
                "id=" + id +
                ", college='" + college + '\'' +
                ", cgpa=" + cgpa +
                '}';
    }
}

