package com.example.demo.controllers;

import com.example.demo.entities.Project;
import com.example.demo.dtos.ProjectDTO;
import com.example.demo.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Project>> getProjects(@PathVariable String userId) {
        return ResponseEntity.ok(projectService.getProjectsByUser(userId));
    }

    @PostMapping("/")
    public ResponseEntity<Project> addProject(@RequestBody Project project) {
        return ResponseEntity.ok(projectService.addProject(project));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable String id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}