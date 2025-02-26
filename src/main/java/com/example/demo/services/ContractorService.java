//package com.example.demo.services;
//
//
//import com.example.demo.entities.Contractor;
//import com.example.demo.repositories.ContractorRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ContractorService {
//
//    @Autowired
//    private ContractorRepository contractorRepository;
//
//    // Search contractors by name or location
//    public List<Contractor> searchContractors(String query) {
//        return contractorRepository.findByNameContainingIgnoreCaseOrLocationContainingIgnoreCase(query, query);
//    }
//
//    // Get contractor profile by ID
//    public Optional<Contractor> getContractorProfile(Long id) {
//        return contractorRepository.findById(id);
//    }
//}



