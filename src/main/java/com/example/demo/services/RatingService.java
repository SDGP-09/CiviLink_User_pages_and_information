package com.example.demo.services;

import com.example.demo.dtos.internal.AddUpdateRatingInternalDTO;
import com.example.demo.dtos.internal.IdBasedInternalDTO;
import com.example.demo.dtos.internal.UserIdBasedInternalDTO;
import com.example.demo.dtos.response.RatingSummeryResponseDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingService {

    public RatingSummeryResponseDTO getRatingSummery(UserIdBasedInternalDTO userIdBasedInternalDTO);

    public void addUpdateRating(AddUpdateRatingInternalDTO addUpdateRatingInternalDTO);

}
