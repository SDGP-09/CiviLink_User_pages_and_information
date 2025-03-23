package com.example.demo.services;

import com.example.demo.dtos.internal.IdBasedInternalDTO;
import com.example.demo.dtos.internal.PostProjectInternalDTO;
import com.example.demo.dtos.internal.ProjectIdBasedInternalDTO;
import com.example.demo.dtos.internal.UpdateProjectInternalDTO;
import com.example.demo.dtos.request.IdBasedRequestDTO;
import com.example.demo.dtos.response.ProjectCardResponseDTO;
import com.example.demo.dtos.response.ProjectDetailsResponseDTO;
import com.example.demo.dtos.response.UnitProjectCardResponseDTO;

public interface ProjectService {

    public ProjectDetailsResponseDTO getVisibleProjectsByContractorId(IdBasedRequestDTO idBasedRequestDTO);

    public ProjectDetailsResponseDTO getAllProjectsByContractorId(IdBasedRequestDTO idBasedRequestDTO);

    public ProjectCardResponseDTO postProject(PostProjectInternalDTO dto);

    public ProjectCardResponseDTO updateProject(UpdateProjectInternalDTO dto);

    public void toggleProjectVisibility(ProjectIdBasedInternalDTO projectIdBasedInternalDTO);

    public void deleteProject(ProjectIdBasedInternalDTO projectIdBasedInternalDTO);

    public UnitProjectCardResponseDTO getUnitProjectById(IdBasedRequestDTO idBasedRequestDTO);
}
