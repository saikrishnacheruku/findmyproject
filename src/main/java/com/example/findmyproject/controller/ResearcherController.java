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

import com.example.findmyproject.service.*;
import java.util.List;
import com.example.findmyproject.repository.*;

import com.example.findmyproject.model.Project;
import com.example.findmyproject.model.Researcher;

@RestController
public class ResearcherController {
    @Autowired
    private ResearcherJpaService researcherJpaService;

    @GetMapping("/researchers")
    public List<Researcher> getResearchers() {
        return researcherJpaService.getResearchers();
    }

    @GetMapping("/researchers/{researcherId}")
    public Researcher getResearcherById(@PathVariable("researcherId") int researcherId) {
        return researcherJpaService.getResearcherById(researcherId);
    }

    @PostMapping("/researchers")
    public Researcher addResearcher(@RequestBody Researcher researcher) {
        return researcherJpaService.addResearcher(researcher);
    }

    @PutMapping("/researchers/{researcherId}")
    public Researcher updateResearcher(@PathVariable("researcherId") int researcherId,
            @RequestBody Researcher researcher) {
        return researcherJpaService.updateResearcher(researcherId, researcher);
    }

    @DeleteMapping("/researchers/{researcherId}")
    public void deleteResearcher(@PathVariable("researcherId") int researcherId) {
        researcherJpaService.deleteResearcher(researcherId);
    }

    @GetMapping("/researchers/{researcherId}/projects")
    public List<Project> getProjectResearcher(@PathVariable("researcherId") int researcherId) {
        return researcherJpaService.getProjectResearcher(researcherId);
    }

}