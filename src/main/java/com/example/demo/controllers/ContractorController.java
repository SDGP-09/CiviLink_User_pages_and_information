package com.example.demo.controllers;

import com.example.demo.dtos.ContractorDTO;
import com.example.demo.services.impl.ContractorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contractors")
public class ContractorController {

    @Autowired
    private ContractorServiceImpl contractorServiceImpl;

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

}

