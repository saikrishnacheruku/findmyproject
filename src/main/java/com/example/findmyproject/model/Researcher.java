/*
 * You can use the following import statements
 *
 * import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
 * 
 * import javax.persistence.*;
 * import java.util.List;
 * 
 */

// Write your code here

package com.example.findmyproject.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@Entity
@Table(name = "researcher")
public class Researcher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int researcherId;

    @Column(name = "name")
    private String researcherName;

    @Column(name = "specialization")
    private String specialization;

    @ManyToMany(mappedBy = "researchers")
    @JsonIgnoreProperties("researchers")
    private List<Project> projects;

    // Constructors
    public Researcher() {
    }

    public Researcher(String researcherName, String specialization) {
        this.researcherName = researcherName;
        this.specialization = specialization;
    }

    // Getters and Setters
    public int getResearcherId() {
        return researcherId;
    }

    public void setResearcherId(int researcherId) {
        this.researcherId = researcherId;
    }

    public String getResearcherName() {
        return researcherName;
    }

    public void setResearcherName(String researcherName) {
        this.researcherName = researcherName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Project> getProjects() {
        return projects;
    }
}