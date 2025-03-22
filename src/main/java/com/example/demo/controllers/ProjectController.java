package com.example.demo.controllers;

import com.example.demo.dtos.internal.PostProjectInternalDTO;
import com.example.demo.dtos.internal.ProjectIdBasedInternalDTO;
import com.example.demo.dtos.internal.UpdateProjectInternalDTO;
import com.example.demo.dtos.request.IdBasedRequestDTO;
import com.example.demo.dtos.request.PostProjectRequestDTO;
import com.example.demo.dtos.request.UpdateProjectRequestDTO;
import com.example.demo.dtos.response.ProjectCardResponseDTO;
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

        ProjectDetailsResponseDTO projects = projectService.getVisibleProjectsByContractorId(idBasedRequestDTO);



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

    @PostMapping("/post-project")
    public ResponseEntity<StandardResponse> addProject(@RequestBody PostProjectRequestDTO projectRequestDTO, Authentication authentication){

        Jwt jwt =(Jwt) authentication.getPrincipal();


        String senderIdClaim = jwt.getClaimAsString("sub");
        Long senderId = Long.valueOf(senderIdClaim); //Make sure that the user id will be all ways long

        ProjectCardResponseDTO project = projectService.postProject(new PostProjectInternalDTO(
                senderId,
                projectRequestDTO.getName(),
                projectRequestDTO.getDescription(),
                projectRequestDTO.getStartDate(),
                projectRequestDTO.getEstimatedCompletion(),
                projectRequestDTO.isVisible(),
                projectRequestDTO.getImages(),
                projectRequestDTO.getStatus()
        ));





        return new ResponseEntity<>(
                new StandardResponse(200, "contractor cards", project),
                HttpStatus.OK
        );
    }


    @PostMapping("/update-project")
    public ResponseEntity<StandardResponse> UpdateProject(@RequestBody UpdateProjectRequestDTO updateProjectRequestDTO, Authentication authentication){

        Jwt jwt =(Jwt) authentication.getPrincipal();


        String senderIdClaim = jwt.getClaimAsString("sub");
        Long senderId = Long.valueOf(senderIdClaim); //Make sure that the user id will be all ways long


        ProjectCardResponseDTO updatedProject = projectService.updateProject(new UpdateProjectInternalDTO(
                updateProjectRequestDTO.getId(),
                senderId,
                updateProjectRequestDTO.getName(),
                updateProjectRequestDTO.getDescription(),
                updateProjectRequestDTO.getStartDate(),
                updateProjectRequestDTO.getEstimatedCompletion(),
                updateProjectRequestDTO.isVisible(),
                updateProjectRequestDTO.getDeletedImages(),
                updateProjectRequestDTO.getImages(),
                updateProjectRequestDTO.getStatus()
        ));




        return new ResponseEntity<>(
                new StandardResponse(200, "contractor cards", updatedProject),
                HttpStatus.OK
        );
    }



    @PostMapping("/toggle-visibility")
    public ResponseEntity<StandardResponse> toggleProjectVisibility(@RequestBody IdBasedRequestDTO idBasedRequestDTO, Authentication authentication){

        Jwt jwt =(Jwt) authentication.getPrincipal();


        String senderIdClaim = jwt.getClaimAsString("sub");
        Long senderId = Long.valueOf(senderIdClaim); //Make sure that the user id will be all ways long


        projectService.toggleProjectVisibility(new ProjectIdBasedInternalDTO(
                idBasedRequestDTO.getId(),
                senderId
        ));

        return new ResponseEntity<>(
                new StandardResponse(200, "contractor cards", true),
                HttpStatus.OK
        );
    }


    @PostMapping("/delete-project")
    public ResponseEntity<StandardResponse> deleteProject(@RequestBody IdBasedRequestDTO idBasedRequestDTO, Authentication authentication){

        Jwt jwt =(Jwt) authentication.getPrincipal();


        String senderIdClaim = jwt.getClaimAsString("sub");
        Long senderId = Long.valueOf(senderIdClaim); //Make sure that the user id will be all ways long


        projectService.deleteProject(new ProjectIdBasedInternalDTO(
                idBasedRequestDTO.getId(),
                senderId
        ));

        return new ResponseEntity<>(
                new StandardResponse(200, "contractor cards", true),
                HttpStatus.OK
        );
    }






}
