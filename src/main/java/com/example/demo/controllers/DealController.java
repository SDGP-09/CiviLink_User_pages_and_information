package com.example.demo.controllers;


import com.example.demo.dtos.internal.AddIdBasedInternalDTO;
import com.example.demo.dtos.internal.PostAddInternalDTO;
import com.example.demo.dtos.internal.UpdateAddInternalDTO;
import com.example.demo.dtos.request.*;
import com.example.demo.dtos.response.AddResponseDTO;
import com.example.demo.dtos.response.AllDealsResponseDTO;
import com.example.demo.services.DealService;
import com.example.demo.util.StandardResponse;
//import com.google.rpc.context.AttributeContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/dealsIndeed")
public class DealController {

    @Autowired
    private DealService dealService;

    @PostMapping("/post-deal")
    public ResponseEntity<StandardResponse> createDeal(
            @RequestBody PostAddRequestDTO postAddRequestDTO,
            @RequestPart("images") MultipartFile[] images,
            Authentication authentication
    ){

        Jwt jwt =(Jwt) authentication.getPrincipal();


        String senderId = jwt.getClaimAsString("sub");
//        Long senderId = Long.valueOf(senderIdClaim); //Make sure that the user id will be all ways long





        AddResponseDTO response = dealService.postAdd(new PostAddInternalDTO(
                senderId,
                postAddRequestDTO.getTitle(),
                postAddRequestDTO.getDescription(),
                postAddRequestDTO.getField(),
                images,
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


    @PutMapping("/update-deal")
    public ResponseEntity<StandardResponse> updateDeal(
            @RequestBody UpdateAddRequestDTO updateAddRequestDTO,
            @RequestPart("images") MultipartFile[] images,
            Authentication authentication)
    {

        Jwt jwt =(Jwt) authentication.getPrincipal();


        String senderId = jwt.getClaimAsString("sub");
//        Long senderId = Long.valueOf(senderIdClaim);

        AddResponseDTO response = dealService.updateDTO(new UpdateAddInternalDTO(
                updateAddRequestDTO.getId(),
                senderId,
                updateAddRequestDTO.getTitle(),
                updateAddRequestDTO.getDescription(),
                updateAddRequestDTO.getField(),
                updateAddRequestDTO.getDeletedImages(),
                images,
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

    @PostMapping("/hideShow")
    public ResponseEntity<StandardResponse> toggleVisibility(@RequestBody AddIdBasedRequestDTO addIdBasedRequestDTO, Authentication authentication){

        Jwt jwt =(Jwt) authentication.getPrincipal();


        String senderId = jwt.getClaimAsString("sub");
//        Long senderId = Long.valueOf(senderIdClaim);

        dealService.toggleVisibility(new AddIdBasedInternalDTO(
                addIdBasedRequestDTO.getAddId(),
                senderId
        ));

        return new ResponseEntity<>(
                new StandardResponse(200, "Rating Posted", true),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/deleteAdd")
    public ResponseEntity<StandardResponse> deleteDeal(@RequestBody AddIdBasedRequestDTO addIdBasedRequestDTO, Authentication authentication){

        Jwt jwt =(Jwt) authentication.getPrincipal();


        String senderId = jwt.getClaimAsString("sub");
//        Long senderId = Long.valueOf(senderIdClaim);

        dealService.deleteAdd(new AddIdBasedInternalDTO(
                addIdBasedRequestDTO.getAddId(),
                senderId
        ));

        return new ResponseEntity<>(
                new StandardResponse(200, "Rating Posted", true),
                HttpStatus.OK
        );
    }

    @PostMapping("/get-all-deals")
    public ResponseEntity<StandardResponse> getAllDeals(@RequestBody UserIdBasedRequestDTO userIdBasedRequestDTO){


        AllDealsResponseDTO deals = dealService.getDealsByContractorId(userIdBasedRequestDTO);

        return new ResponseEntity<>(
                new StandardResponse(200, "Rating Posted", deals),
                HttpStatus.OK
        );
    }


}
