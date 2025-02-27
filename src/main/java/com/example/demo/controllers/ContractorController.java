package com.example.demo.controllers;

import com.example.demo.entities.Contractor;
import com.example.demo.services.ContractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contractors")
public class ContractorController {

    @Autowired
    private ContractorService contractorService;

    // Search for contractors by name or location
    @GetMapping("/search")
    public ResponseEntity<List<Contractor>> searchContractors(@RequestParam String query) {
        return ResponseEntity.ok(contractorService.searchContractors(query));
    }

    // Get a contractor's public profile
    @GetMapping("/{id}")
    public ResponseEntity<Contractor> getContractorProfile(@PathVariable Long id) {
        Optional<Contractor> contractor = contractorService.getContractorProfile(id);
        return contractor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

