package com.example.demo.services;

import com.example.demo.dtos.ContractorDTO;
import com.example.demo.dtos.internal.IdBasedInternalDTO;
import com.example.demo.dtos.request.NameBasedRequestDTO;
import com.example.demo.dtos.request.PageBasedRequestDTO;
import com.example.demo.dtos.response.CompanyDetailsResponseDTO;
import com.example.demo.dtos.response.ContractorCardResponseDTO;
import com.example.demo.dtos.response.ContractorNameAndPicResponseDTO;

import java.util.List;
import java.util.Optional;

public interface ContractorService  {

    public ContractorDTO addContractor(ContractorDTO contractorDTO);
    public List<ContractorDTO> searchContractors(String query);
    public Optional<ContractorDTO> getContractorProfile(Long id);
    public CompanyDetailsResponseDTO getCompanyDetailsByContractorId(IdBasedInternalDTO internalDTO);

    public ContractorNameAndPicResponseDTO searchContractorsByName(NameBasedRequestDTO nameBasedRequestDTO);

    public ContractorCardResponseDTO searchContractorCardsByName(NameBasedRequestDTO nameBasedRequestDTO);

    public ContractorCardResponseDTO getContractorsByPage(PageBasedRequestDTO pageBasedRequestDTO);
}
