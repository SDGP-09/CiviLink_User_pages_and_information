package com.example.demo.controllers;


import com.example.demo.dtos.request.AddUpdateRatingRequestDTO;
import com.example.demo.dtos.request.PostAddUpdateRequestDTO;
import com.example.demo.dtos.request.IdBasedRequestDTO;
import com.example.demo.dtos.response.RatingSummeryResponseDTO;
import com.example.demo.services.RatingService;
import com.example.demo.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;

@RestController

// Make sure to add the correct mapping.
@RequestMapping("/api/blablabla")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @GetMapping("/get-rating-summery")
    public ResponseEntity<StandardResponse> getRating(@RequestBody IdBasedRequestDTO idBasedRequestDTO, Authentication authentication){

        RatingSummeryResponseDTO ratingSummery = ratingService.getRatingSummery(idBasedRequestDTO);

        return new ResponseEntity<>(
                new StandardResponse(200, "Rating summery", ratingSummery),
                HttpStatus.OK
        );
    }


    public ResponseEntity<StandardResponse> addUpdate(@RequestBody PostAddUpdateRequestDTO postAddUpdateRatingDTO, Authentication authentication){


        Jwt jwt =(Jwt) authentication.getPrincipal();


        String senderIdClaim = jwt.getClaimAsString("sub");
        Long senderId = Long.valueOf(senderIdClaim); //Make sure that the user id will be all ways long

        ratingService.addUpdateRating(new AddUpdateRatingRequestDTO(senderId, postAddUpdateRatingDTO.getRateReceiver(), postAddUpdateRatingDTO.getRating()));

        return new ResponseEntity<>(
                new StandardResponse(200, "Rating Posted", true),
                HttpStatus.OK
        );
    }


}
