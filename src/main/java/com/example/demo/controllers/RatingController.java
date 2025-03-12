package com.example.demo.controllers;


import com.example.demo.dtos.request.IdBasedRequestDTO;
import com.example.demo.dtos.response.RatingSummeryResponseDTO;
import com.example.demo.services.RatingService;
import com.example.demo.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.List;

@RestController

// Make sure to add the correct mapping.
@RequestMapping("/api/blablabla")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @GetMapping("/get-rating-summery")
    public ResponseEntity<StandardResponse> getRating(@RequestBody IdBasedRequestDTO idBasedRequestDTO, Authentication authentication){

//        Jwt jwt =(Jwt) authentication.getPrincipal();
//        List<String> groups = jwt.getClaimAsStringList("group");

        RatingSummeryResponseDTO ratingSummery = ratingService.getRatingSummery(idBasedRequestDTO);

        return new ResponseEntity<>(
                new StandardResponse(200, "Rating summery", ratingSummery),
                HttpStatus.OK
        );
    }


}
