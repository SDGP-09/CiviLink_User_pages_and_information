package com.example.demo.services;

import com.example.demo.dtos.internal.IdBasedInternalDTO;
import com.example.demo.dtos.request.IdBasedRequestDTO;
import com.example.demo.dtos.response.ProjectDetailsResponseDTO;

public interface ProjectService {

    public ProjectDetailsResponseDTO getVisibleProjectsByContractorId(IdBasedRequestDTO idBasedRequestDTO);

    public ProjectDetailsResponseDTO getAllProjectsByContractorId(IdBasedRequestDTO idBasedRequestDTO);
}
