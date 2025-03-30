package com.example.demo.controllers;


import com.example.demo.dtos.internal.AddUpdateRatingInternalDTO;
import com.example.demo.dtos.internal.UserIdBasedInternalDTO;
import com.example.demo.dtos.request.AddUpdateRequestDTO;
import com.example.demo.dtos.internal.IdBasedInternalDTO;
import com.example.demo.dtos.response.RatingSummeryResponseDTO;
import com.example.demo.services.RatingService;
import com.example.demo.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;

@RestController

// Make sure to add the correct mapping.
@RequestMapping("/api/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;


    // We don't need to access the body in this case so make sure that you will be updating it
    @GetMapping("/get-rating-summery")
    public ResponseEntity<StandardResponse> getRating(Authentication authentication){

        Jwt jwt =(Jwt) authentication.getPrincipal();


        String senderId = jwt.getClaimAsString("sub");
//        Long senderId = Long.valueOf(senderIdClaim); //Make sure that the user id will be all ways long


        RatingSummeryResponseDTO ratingSummery = ratingService.getRatingSummery(new UserIdBasedInternalDTO(senderId));

        return new ResponseEntity<>(
                new StandardResponse(200, "Rating summery", ratingSummery),
                HttpStatus.OK
        );
    }

    @PostMapping("/rate")
    public ResponseEntity<StandardResponse> addUpdateRating(@RequestBody AddUpdateRequestDTO postAddUpdateRatingDTO, Authentication authentication){


        Jwt jwt =(Jwt) authentication.getPrincipal();


        String senderId = jwt.getClaimAsString("sub");
//        Long senderId = Long.valueOf(senderIdClaim); //Make sure that the user id will be all ways long

        ratingService.addUpdateRating(new AddUpdateRatingInternalDTO(senderId, postAddUpdateRatingDTO.getRateReceiver(), postAddUpdateRatingDTO.getRating()));

        return new ResponseEntity<>(
                new StandardResponse(200, "Rating Posted", true),
                HttpStatus.OK
        );
    }


}
