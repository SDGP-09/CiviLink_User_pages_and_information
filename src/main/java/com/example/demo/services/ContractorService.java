package com.example.demo.services;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.entities.Contractor;
import com.example.demo.repositories.ContractorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dtos.ContractorDTO;

import java.util.List;
import java.util.Optional;

@Service
public class ContractorService {

    @Autowired
    private ContractorRepository contractorRepository;

    public ContractorDTO addContractor(ContractorDTO contractorDTO) {
        Contractor contractor = new Contractor();
        contractor.setName(contractorDTO.getName());
        contractor.setLocation(contractorDTO.getLocation());
        contractor.setCompanyName(contractorDTO.getCompanyName());
        contractor.setRating(contractorDTO.getRating());
        contractor.setProfilePicture(contractorDTO.getProfilePicture());

        contractorRepository.save(contractor);
        return contractorDTO;
    }


    public List<ContractorDTO> searchContractors(String query) {
        List<Contractor> contractors = contractorRepository.findByNameContainingIgnoreCaseOrLocationContainingIgnoreCase(query, query);
        return contractors.stream()
                .map(c -> new ContractorDTO(c.getName(), c.getLocation(), c.getCompanyName(), c.getRating(), c.getProfilePicture()))
                .toList();
    }

    public Optional<ContractorDTO> getContractorProfile(Long id) {
        Optional<Contractor> contractor = contractorRepository.findById(id);
        if (contractor.isEmpty()) {
            throw new ResourceNotFoundException("Contractor not found with id: " + id);
        }
        Contractor savedContractor = contractor.get();
        return contractor.map(c -> new ContractorDTO(c.getName(), c.getLocation(), c.getCompanyName(), c.getRating(), c.getProfilePicture()));
    }

}



