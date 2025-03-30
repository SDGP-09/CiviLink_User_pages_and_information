package com.example.demo.controllers;

import com.example.demo.dtos.internal.IdBasedInternalDTO;
import com.example.demo.dtos.internal.UserIdBasedInternalDTO;
import com.example.demo.dtos.request.*;
import com.example.demo.dtos.response.CompanyDetailsResponseDTO;
import com.example.demo.dtos.response.ContractorCardResponseDTO;
import com.example.demo.dtos.response.ContractorNameAndPicResponseDTO;
import com.example.demo.services.ContractorService;
import com.example.demo.services.impl.ContractorServiceImpl;
import com.example.demo.util.StandardResponse;
import jakarta.el.StandardELContext;
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

//    @PostMapping
//    public ResponseEntity<String> createContractor(@RequestBody ContractorDTO contractorDTO) {
//        contractorServiceImpl.addContractor(contractorDTO);
//        return ResponseEntity.ok("Contractor Added Successfully");
//    }

//    @GetMapping("/search")
//    public ResponseEntity<List<ContractorDTO>> searchContractors(@RequestParam String query) {
//        return ResponseEntity.ok(contractorServiceImpl.searchContractors(query));
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<ContractorDTO> getContractorProfile(@PathVariable Long id) {
//        Optional<ContractorDTO> contractor = contractorServiceImpl.getContractorProfile(id);
//        return contractor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }

    @PostMapping("/Company-details")
    public ResponseEntity<StandardResponse> getContractorDetails(@RequestBody UserIdBasedRequestDTO userIdBasedRequestDTO){

        CompanyDetailsResponseDTO companyDetailsResponseDTO = contractorService.getCompanyDetailsByContractorId(new UserIdBasedInternalDTO(userIdBasedRequestDTO.getId()));

        return new ResponseEntity<>(
                new StandardResponse(200, "Company details", companyDetailsResponseDTO),
                HttpStatus.OK
        );
    }

    @PostMapping("/contractor-selection-cards")
    public ResponseEntity<StandardResponse> getSelectingContractor(@RequestBody NameBasedRequestDTO nameBasedRequestDTO){


        ContractorNameAndPicResponseDTO contractors = contractorService.searchContractorsByName(nameBasedRequestDTO);




        return new ResponseEntity<>(
                new StandardResponse(200, "contractor cards", contractors),
                HttpStatus.OK
        );
    }

    @PostMapping("/get-contractor-name")
    public ResponseEntity<StandardResponse> getContractorNameAndId(@RequestBody IdPackBasedRequestDTO idPackBasedRequestDTO){


        ContractorNameAndPicResponseDTO contractors = contractorService.searchContractorsByIdPack(idPackBasedRequestDTO);




        return new ResponseEntity<>(
                new StandardResponse(200, "contractor cards", contractors),
                HttpStatus.OK
        );
    }


    @PostMapping("/search-contractor-by-name")
    public ResponseEntity<StandardResponse> getSearchedContractor(@RequestBody NameBasedRequestDTO nameBasedRequestDTO){

        ContractorCardResponseDTO contractors = contractorService.searchContractorCardsByName(nameBasedRequestDTO);

        return new ResponseEntity<>(
                new StandardResponse(200, "contractor cards", contractors),
                HttpStatus.OK
        );
    }



    @PostMapping("/get-contractor-cards")
    public ResponseEntity<StandardResponse> getContractorCards(@RequestBody PageBasedRequestDTO pageBasedRequestDTO){

        ContractorCardResponseDTO contractors = contractorService.getContractorsByPage(pageBasedRequestDTO);



        return new ResponseEntity<>(
                new StandardResponse(200, "contractor cards", contractors),
                HttpStatus.OK
        );

    }

    @PostMapping("/create-contractor")
    public ResponseEntity<StandardResponse> createContractor(@RequestBody ContractorCreationRequestDTO contractorCreationRequestDTO){

        contractorService.createContractor(contractorCreationRequestDTO);


        return new ResponseEntity<>(
                new StandardResponse(200, "contractor created", true),
                HttpStatus.OK
        );
    }



}

