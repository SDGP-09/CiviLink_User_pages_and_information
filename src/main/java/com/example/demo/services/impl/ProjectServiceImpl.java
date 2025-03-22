package com.example.demo.services.impl;

import com.example.demo.dtos.internal.IdBasedInternalDTO;
import com.example.demo.dtos.internal.PostProjectInternalDTO;
import com.example.demo.dtos.internal.ProjectIdBasedInternalDTO;
import com.example.demo.dtos.internal.UpdateProjectInternalDTO;
import com.example.demo.dtos.request.IdBasedRequestDTO;
import com.example.demo.dtos.response.ProjectCardResponseDTO;
import com.example.demo.dtos.response.ProjectDetailsResponseDTO;
import com.example.demo.entities.Contractor;
import com.example.demo.entities.Project;
import com.example.demo.entities.ProjectImage;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repositories.ContractorRepository;
import com.example.demo.repositories.DealRepository;
import com.example.demo.repositories.ProjectRepository;
import com.example.demo.services.ProjectService;
import com.example.demo.services.StorageService;
import com.example.demo.types.ProjectCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ContractorRepository contractorRepository;

    @Autowired
    private StorageService storageService;


    public ProjectCardResponseDTO postProject(PostProjectInternalDTO dto) {

        Contractor contractor = contractorRepository.findById(dto.getContractorId())
                .orElseThrow(() -> new ResourceNotFoundException("Contractor not found with id: " + dto.getContractorId()));


        Project project = new Project();
        project.setContractor(contractor);
        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setStartDate(dto.getStartDate());
        project.setEstimatedCompletion(dto.getEstimatedCompletion());
        project.setVisible(dto.isVisible());
        project.setStatus(dto.getStatus());


        List<ProjectImage> projectImages = new ArrayList<>();
        MultipartFile[] images = dto.getImages();
        if (images != null) {
            for (MultipartFile file : images) {
                if (file != null && !file.isEmpty()) {
                    try {
                        byte[] fileBytes = file.getBytes();
                        String uploadedFileName = storageService.uploadFile(fileBytes, file.getContentType());
                        ProjectImage pImage = new ProjectImage();
                        pImage.setImage(uploadedFileName);
                        pImage.setProject(project);
                        projectImages.add(pImage);
                    } catch (IOException e) {
                        throw new RuntimeException("Failed to upload image: " + file.getOriginalFilename(), e);
                    }
                }
            }
        }
        project.setImages(projectImages);


        Project savedProject = projectRepository.save(project);


        List<String> imageLinks = new ArrayList<>();
        if (savedProject.getImages() != null) {
            for (ProjectImage pi : savedProject.getImages()) {
                imageLinks.add(pi.getImage());
            }
        }
        String[] imagesArray = imageLinks.toArray(new String[0]);


        return new ProjectCardResponseDTO(
                savedProject.getId(),
                savedProject.getContractor().getId(),
                savedProject.getDescription(),
                savedProject.getStartDate(),
                savedProject.getEstimatedCompletion(),
                savedProject.isVisible(),
                imagesArray,
                savedProject.getStatus()
        );
    }













    @Override
    public ProjectDetailsResponseDTO getVisibleProjectsByContractorId(IdBasedRequestDTO idBasedRequestDTO) {


        List<Project> projects = projectRepository.findByContractorId(idBasedRequestDTO.getId());
        List<ProjectCard> cardList = new ArrayList<>();

        for (Project project : projects) {

            if (project.isVisible()) {
                String[] imagesArray = new String[0];
                if (project.getImages() != null && !project.getImages().isEmpty()) {
                    imagesArray = project.getImages()
                            .stream()
                            .map(pi -> pi.getImage())
                            .toArray(String[]::new);
                }
                ProjectCard card = new ProjectCard(
                        project.getId(),
                        project.getContractor().getId(),
                        project.getDescription(),
                        project.getStartDate(),
                        project.getEstimatedCompletion(),
                        project.isVisible(),
                        imagesArray,
                        project.getStatus()
                );
                cardList.add(card);
            }
        }

        ProjectCard[] cardsArray = cardList.toArray(new ProjectCard[0]);
        return new ProjectDetailsResponseDTO(cardsArray);
    }



    @Override
    public ProjectDetailsResponseDTO getAllProjectsByContractorId(IdBasedRequestDTO idBasedRequestDTO) {

        List<Project> projects = projectRepository.findByContractorId(idBasedRequestDTO.getId());
        List<ProjectCard> cardList = new ArrayList<>();

        for (Project project : projects) {
            String[] imagesArray = new String[0];
            if (project.getImages() != null && !project.getImages().isEmpty()) {
                imagesArray = project.getImages()
                        .stream()
                        .map(pi -> pi.getImage())
                        .toArray(String[]::new);
            }
            ProjectCard card = new ProjectCard(
                    project.getId(),
                    project.getContractor().getId(),
                    project.getDescription(),
                    project.getStartDate(),
                    project.getEstimatedCompletion(),
                    project.isVisible(),
                    imagesArray,
                    project.getStatus()
            );
            cardList.add(card);
        }

        ProjectCard[] cardsArray = cardList.toArray(new ProjectCard[0]);
        return new ProjectDetailsResponseDTO(cardsArray);
    }

    @Override
    public ProjectCardResponseDTO updateProject(UpdateProjectInternalDTO updateProjectInternalDTO) {

        Project project = projectRepository.findById(updateProjectInternalDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id: " + updateProjectInternalDTO.getId()));


        if (!project.getContractor().getId().equals(updateProjectInternalDTO.getContractorId())) {
            throw new RuntimeException("Unauthorized: Contractor id mismatch.");
        }


        project.setName(updateProjectInternalDTO.getName());
        project.setDescription(updateProjectInternalDTO.getDescription());
        project.setStartDate(updateProjectInternalDTO.getStartDate());
        project.setEstimatedCompletion(updateProjectInternalDTO.getEstimatedCompletion());
        project.setVisible(updateProjectInternalDTO.isVisible());
        project.setStatus(updateProjectInternalDTO.getStatus());


        String[] deletedImages = updateProjectInternalDTO.getDeletedImages();
        if (deletedImages != null && deletedImages.length > 0) {
            List<ProjectImage> updatedImages = new ArrayList<>();
            if (project.getImages() != null) {
                for (ProjectImage img : project.getImages()) {
                    boolean shouldDelete = false;
                    for (String delName : deletedImages) {
                        if (img.getImage().equals(delName)) {
                            try {
                                storageService.deleteFile(delName);
                            } catch (IOException e) {
                                throw new RuntimeException("Failed to delete image: " + delName, e);
                            }
                            shouldDelete = true;
                            break;
                        }
                    }
                    if (!shouldDelete) {
                        updatedImages.add(img);
                    }
                }
            }
            project.setImages(updatedImages);
        }


        MultipartFile[] newImages = updateProjectInternalDTO.getImages();
        if (newImages != null) {
            if (project.getImages() == null) {
                project.setImages(new ArrayList<>());
            }
            for (MultipartFile file : newImages) {
                if (file != null && !file.isEmpty()) {
                    try {
                        byte[] fileBytes = file.getBytes();
                        String uploadedFileName = storageService.uploadFile(fileBytes, file.getContentType());
                        ProjectImage newImage = new ProjectImage();
                        newImage.setImage(uploadedFileName);
                        newImage.setProject(project);
                        project.getImages().add(newImage);
                    } catch (IOException e) {
                        throw new RuntimeException("Failed to upload new image: " + file.getOriginalFilename(), e);
                    }
                }
            }
        }


        Project updatedProject = projectRepository.save(project);


        List<String> imageList = new ArrayList<>();
        if (updatedProject.getImages() != null) {
            for (ProjectImage pi : updatedProject.getImages()) {
                imageList.add(pi.getImage());
            }
        }
        String[] imagesArray = imageList.toArray(new String[0]);



        return new ProjectCardResponseDTO(
                updatedProject.getId(),
                updatedProject.getContractor().getId(),
                updatedProject.getDescription(),
                updatedProject.getStartDate(),
                updatedProject.getEstimatedCompletion(),
                updatedProject.isVisible(),
                imagesArray,
                updatedProject.getStatus()
        );
    }

    @Override
    public void toggleProjectVisibility(ProjectIdBasedInternalDTO projectIdBasedInternalDTO) {

        Project project = projectRepository.findById(projectIdBasedInternalDTO.getAddId())
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id: " + projectIdBasedInternalDTO.getAddId()));


        if (!project.getContractor().getId().equals(projectIdBasedInternalDTO.getOwnerId())) {
            throw new RuntimeException("Unauthorized: Contractor id mismatch.");
        }


        project.setVisible(!project.isVisible());


        projectRepository.save(project);
    }

    @Override
    public void deleteProject(ProjectIdBasedInternalDTO projectIdBasedInternalDTO) {

        Project project = projectRepository.findById(projectIdBasedInternalDTO.getAddId())
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id: " + projectIdBasedInternalDTO.getAddId()));


        if (!project.getContractor().getId().equals(projectIdBasedInternalDTO.getOwnerId())) {
            throw new RuntimeException("Unauthorized: Contractor id mismatch.");
        }


        List<ProjectImage> images = project.getImages();
        if (images != null) {
            for (ProjectImage image : images) {
                try {
                    storageService.deleteFile(image.getImage());
                } catch (IOException e) {
                    throw new RuntimeException("Failed to delete image: " + image.getImage(), e);
                }
            }
        }


        projectRepository.delete(project);
    }



}
