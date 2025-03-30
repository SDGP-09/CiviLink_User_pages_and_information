package com.example.demo.services;

import com.example.demo.dtos.internal.IdBasedInternalDTO;
import com.example.demo.dtos.internal.UserIdBasedInternalDTO;
import com.example.demo.dtos.request.ContractorCreationRequestDTO;
import com.example.demo.dtos.request.IdPackBasedRequestDTO;
import com.example.demo.dtos.request.NameBasedRequestDTO;
import com.example.demo.dtos.request.PageBasedRequestDTO;
import com.example.demo.dtos.response.CompanyDetailsResponseDTO;
import com.example.demo.dtos.response.ContractorCardResponseDTO;
import com.example.demo.dtos.response.ContractorNameAndPicResponseDTO;

import java.util.List;
import java.util.Optional;

public interface ContractorService  {

//    public ContractorDTO addContractor(ContractorDTO contractorDTO);
//    public List<ContractorDTO> searchContractors(String query);
//    public Optional<ContractorDTO> getContractorProfile(Long id);

    public void createContractor(ContractorCreationRequestDTO contractorCreationRequestDTO);

    public CompanyDetailsResponseDTO getCompanyDetailsByContractorId(UserIdBasedInternalDTO userIdBasedInternalDTO);

    public ContractorNameAndPicResponseDTO searchContractorsByName(NameBasedRequestDTO nameBasedRequestDTO);

    public ContractorCardResponseDTO searchContractorCardsByName(NameBasedRequestDTO nameBasedRequestDTO);

    public ContractorCardResponseDTO getContractorsByPage(PageBasedRequestDTO pageBasedRequestDTO);

    public ContractorNameAndPicResponseDTO searchContractorsByIdPack(IdPackBasedRequestDTO idPackBasedRequestDTO);
}
