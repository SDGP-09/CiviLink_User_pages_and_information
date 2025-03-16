package com.example.demo.services;

import com.example.demo.dtos.ContractorDTO;

import java.util.List;
import java.util.Optional;

public interface ContractorService  {

    public ContractorDTO addContractor(ContractorDTO contractorDTO);
    public List<ContractorDTO> searchContractors(String query);
    public Optional<ContractorDTO> getContractorProfile(Long id);
}
