package com.example.demo.controllers;

import com.example.demo.dtos.ContractorDTO;
import com.example.demo.dtos.internal.IdBasedInternalDTO;
import com.example.demo.dtos.request.IdBasedRequestDTO;
import com.example.demo.dtos.response.CompanyDetailsResponseDTO;
import com.example.demo.repositories.ContractorRepository;
import com.example.demo.services.ContractorService;
import com.example.demo.services.impl.ContractorServiceImpl;
import com.example.demo.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contractors")
public class ContractorController {

    @Autowired
    private ContractorServiceImpl contractorServiceImpl;

    @Autowired
    private ContractorService contractorService;

    @PostMapping
    public ResponseEntity<String> createContractor(@RequestBody ContractorDTO contractorDTO) {
        contractorServiceImpl.addContractor(contractorDTO);
        return ResponseEntity.ok("Contractor Added Successfully");
    }

    @GetMapping("/search")
    public ResponseEntity<List<ContractorDTO>> searchContractors(@RequestParam String query) {
        return ResponseEntity.ok(contractorServiceImpl.searchContractors(query));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContractorDTO> getContractorProfile(@PathVariable Long id) {
        Optional<ContractorDTO> contractor = contractorServiceImpl.getContractorProfile(id);
        return contractor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/Company-details")
    public ResponseEntity<StandardResponse> getContractorDetails(@RequestBody IdBasedRequestDTO idBasedRequestDTO){

        CompanyDetailsResponseDTO companyDetailsResponseDTO = contractorService.getCompanyDetailsByContractorId(new IdBasedInternalDTO(idBasedRequestDTO.getId()));

        return new ResponseEntity<>(
                new StandardResponse(200, "Company details", companyDetailsResponseDTO),
                HttpStatus.OK
        );
    }

}

