/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * 
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here

package com.example.findmyproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import com.example.findmyproject.service.*;
import com.example.findmyproject.repository.*;
import com.example.findmyproject.model.Project;
import com.example.findmyproject.model.Researcher;

@RestController
public class ProjectController {
    @Autowired
    private ProjectJpaService projectJpaService;

    @GetMapping("/researchers/projects")
    public List<Project> getProjects() {
        return projectJpaService.getProjects();
    }

    @GetMapping("/researchers/projects/{projectId}")
    public Project getProjectById(@PathVariable("projectId") int projectId) {
        return projectJpaService.getProjectById(projectId);
    }

    @PostMapping("/researchers/projects")
    public Project addProject(@RequestBody Project project) {
        return projectJpaService.addProject(project);
    }

    @PutMapping("/researchers/projects/{projectId}")
    public Project updateProject(@PathVariable("projectId") int projectId, @RequestBody Project project) {
        return projectJpaService.updateProject(projectId, project);
    }

    @DeleteMapping("/researchers/projects/{projectId}")
    public void deleteProject(@PathVariable("projectId") int projectId) {
        projectJpaService.deleteProject(projectId);
    }

    @GetMapping("/projects/{projectId}/researchers")
    public List<Researcher> getProjectResearcher(@PathVariable("projectId") int projectId) {
        return projectJpaService.getProjectResearcher(projectId);
    }

}