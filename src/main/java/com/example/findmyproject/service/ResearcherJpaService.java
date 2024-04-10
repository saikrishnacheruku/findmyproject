/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * 
 * import java.util.*;
 *
 */

// Write your code here
package com.example.findmyproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

import com.example.findmyproject.model.Project;
import com.example.findmyproject.model.Researcher;
import com.example.findmyproject.repository.ProjectJpaRepository;
import com.example.findmyproject.repository.ResearcherJpaRepository;
import com.example.findmyproject.repository.ResearcherRepository;

@Service
public class ResearcherJpaService implements ResearcherRepository {

	@Autowired
	private ProjectJpaRepository projectJpaRepository;

	@Autowired
	private ResearcherJpaRepository researcherJpaRepository;

	@Override
	public List<Researcher> getResearchers() {

		return researcherJpaRepository.findAll();
	}

	@Override
	public Researcher getResearcherById(int researcherId) {
		try {
			Researcher researcher = researcherJpaRepository.findById(researcherId).get();
			return researcher;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Researcher addResearcher(Researcher researcher) {

		List<Integer> projectIds = new ArrayList<>();
		for (Project project : researcher.getProjects()) {
			projectIds.add(project.getProjectId());

		}
		List<Project> projects = projectJpaRepository.findAllById(projectIds);
		researcher.setProjects(projects);

		for (Project project : projects) {
			project.getResearchers().add(researcher);
		}

		Researcher savedResearchers = researcherJpaRepository.save(researcher);
		projectJpaRepository.saveAll(projects);

		return savedResearchers;

	}

	@Override
	public Researcher updateResearcher(int researcherId, Researcher researcher) {

		try {
			Researcher newResearcher = researcherJpaRepository.findById(researcherId).get();

			if (researcher.getResearcherName() != null) {
				newResearcher.setResearcherName(researcher.getResearcherName());

			}
			if (researcher.getSpecialization() != null) {
				newResearcher.setSpecialization(researcher.getSpecialization());

			}
			if (researcher.getProjects() != null) {
				List<Project> projects = newResearcher.getProjects();
				for (Project project : projects) {
					project.getResearchers().remove(newResearcher);
				}
				projectJpaRepository.saveAll(projects);
				List<Integer> newProjectIds = new ArrayList<>();
				for (Project project : researcher.getProjects()) {
					newProjectIds.add(project.getProjectId());
				}
				List<Project> newProjects = projectJpaRepository.findAllById(newProjectIds);
				for (Project project : newProjects) {
					project.getResearchers().add(newResearcher);
				}
				projectJpaRepository.saveAll(newProjects);
				newResearcher.setProjects(newProjects);

			}
			return researcherJpaRepository.save(newResearcher);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		}
	}

	@Override
	public void deleteResearcher(int researcherId) {
		try {
			Researcher researcher = researcherJpaRepository.findById(researcherId).get();
			List<Project> projects = researcher.getProjects();

			for (Project project : projects) {
				project.getResearchers().remove(researcher);
			}
			projectJpaRepository.saveAll(projects);
			researcherJpaRepository.deleteById(researcherId);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		}
		throw new ResponseStatusException(HttpStatus.NO_CONTENT);

	}

	@Override
	public List<Project> getProjectResearcher(int researcherId) {
		try {
			Researcher researcher = researcherJpaRepository.findById(researcherId).get();

			return researcher.getProjects();

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		}
	}

}