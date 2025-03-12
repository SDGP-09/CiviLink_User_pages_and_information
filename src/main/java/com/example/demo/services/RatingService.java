package com.example.demo.services;

import com.example.demo.dtos.request.AddUpdateRatingDTO;
import com.example.demo.dtos.request.IdBasedRequestDTO;
import com.example.demo.dtos.response.RatingSummeryResponseDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingService {

    public RatingSummeryResponseDTO getRatingSummery(IdBasedRequestDTO id);

    public void addUpdateRating(AddUpdateRatingDTO addUpdateRatingDTO);

}
