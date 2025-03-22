package com.example.demo.services.impl;

import com.example.demo.dtos.internal.IdBasedInternalDTO;
import com.example.demo.dtos.request.IdBasedRequestDTO;
import com.example.demo.dtos.response.ProjectDetailsResponseDTO;
import com.example.demo.entities.Project;
import com.example.demo.repositories.DealRepository;
import com.example.demo.repositories.ProjectRepository;
import com.example.demo.services.ProjectService;
import com.example.demo.types.ProjectCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

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






}
