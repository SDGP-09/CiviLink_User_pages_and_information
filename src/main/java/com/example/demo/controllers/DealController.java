package com.example.demo.controllers;


import com.example.demo.dtos.internal.PostAddInternalDTO;
import com.example.demo.dtos.internal.UpdateAddInternalDTO;
import com.example.demo.dtos.request.PostAddRequestDTO;
import com.example.demo.dtos.request.UpdateAddRequestDTO;
import com.example.demo.dtos.response.AddResponseDTO;
import com.example.demo.services.DealService;
import com.example.demo.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;



@RestController
@RequestMapping("/api/dealsIndeed")
public class DealController {

    @Autowired
    private DealService dealService;

    @PostMapping("/post-deal")
    public ResponseEntity<StandardResponse> createDeal(@RequestBody PostAddRequestDTO postAddRequestDTO, Authentication authentication){

        Jwt jwt =(Jwt) authentication.getPrincipal();


        String senderIdClaim = jwt.getClaimAsString("sub");
        Long senderId = Long.valueOf(senderIdClaim); //Make sure that the user id will be all ways long





        AddResponseDTO response = dealService.postAdd(new PostAddInternalDTO(
                senderId,
                postAddRequestDTO.getTitle(),
                postAddRequestDTO.getDescription(),
                postAddRequestDTO.getField(),
                postAddRequestDTO.getImages(),
                postAddRequestDTO.getFullDescription(),
                postAddRequestDTO.isShow(),
                postAddRequestDTO.getPerHour(),
                postAddRequestDTO.getPerDay(),
                postAddRequestDTO.getPerWeek(),
                postAddRequestDTO.getPerMonth(),
                postAddRequestDTO.getPerYear(),
                postAddRequestDTO.getPrice()
        ));






        return new ResponseEntity<>(
                new StandardResponse(200, "Rating Posted", response),
                HttpStatus.OK
        );
    }


    public ResponseEntity<StandardResponse> updateDeal(@RequestBody UpdateAddRequestDTO updateAddRequestDTO, Authentication authentication){

        Jwt jwt =(Jwt) authentication.getPrincipal();


        String senderIdClaim = jwt.getClaimAsString("sub");
        Long senderId = Long.valueOf(senderIdClaim);

        AddResponseDTO response = dealService.updateDTO(new UpdateAddInternalDTO(
                updateAddRequestDTO.getId(),
                senderId,
                updateAddRequestDTO.getTitle(),
                updateAddRequestDTO.getDescription(),
                updateAddRequestDTO.getField(),
                updateAddRequestDTO.getDeletedImages(),
                updateAddRequestDTO.getImages(),
                updateAddRequestDTO.getFullDescription(),
                updateAddRequestDTO.isShow(),
                updateAddRequestDTO.getPerHour(),
                updateAddRequestDTO.getPerDay(),
                updateAddRequestDTO.getPerWeek(),
                updateAddRequestDTO.getPerMonth(),
                updateAddRequestDTO.getPerYear(),
                updateAddRequestDTO.getPrice()
        ));

        return new ResponseEntity<>(
                new StandardResponse(200, "Rating Posted", response),
                HttpStatus.OK
        );
    }


}
