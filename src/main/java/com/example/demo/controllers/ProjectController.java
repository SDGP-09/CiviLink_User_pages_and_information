package com.example.demo.controllers;

import com.example.demo.dtos.request.IdBasedRequestDTO;
import com.example.demo.dtos.response.ProjectDetailsResponseDTO;
import com.example.demo.services.ProjectService;
import com.example.demo.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;


@RestController
@RequestMapping("/api/public-project-display")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/get-visible-projects")
    public ResponseEntity<StandardResponse> getVisibleProjects(@RequestBody IdBasedRequestDTO idBasedRequestDTO){

        ProjectDetailsResponseDTO projects = projectService.getAllProjectsByContractorId(idBasedRequestDTO);



        return new ResponseEntity<>(
                new StandardResponse(200, "contractor cards", projects),
                HttpStatus.OK
        );
    }
    @GetMapping("/get-all-projects")
    public ResponseEntity<StandardResponse> getAllProjects(Authentication authentication){

        Jwt jwt =(Jwt) authentication.getPrincipal();


        String senderIdClaim = jwt.getClaimAsString("sub");
        Long senderId = Long.valueOf(senderIdClaim); //Make sure that the user id will be all ways long

        ProjectDetailsResponseDTO projects = projectService.getAllProjectsByContractorId(new IdBasedRequestDTO(senderId));



        return new ResponseEntity<>(
                new StandardResponse(200, "contractor cards", projects),
                HttpStatus.OK
        );
    }



}
