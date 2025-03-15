package com.example.demo.services.impl;

import com.example.demo.dtos.internal.AddUpdateRatingInternalDTO;
import com.example.demo.dtos.internal.IdBasedInternalDTO;
import com.example.demo.dtos.response.RatingSummeryResponseDTO;
import com.example.demo.entities.Rating;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repositories.ContractorRepository;
import com.example.demo.repositories.RatingRepository;
import com.example.demo.services.RatingService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService {


    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private ContractorRepository contractorRepository;

    @Override
    public RatingSummeryResponseDTO getRatingSummery(IdBasedInternalDTO id) {

        try{
            List<Object[]> results = ratingRepository.findRatingCountsByContractorId(id.getId());

            int ones =(Integer) results.get(0)[1];
            int twos =(Integer) results.get(1)[1];
            int threes =(Integer) results.get(2)[1];
            int fours =(Integer) results.get(3)[1];
            int fives =(Integer) results.get(4)[1];


            int mean = (
                    (ones + twos * 2 + threes * 3 + fours * 4 + fives * 5)/
                            (ones + twos + threes + fours + fives)
            );

            return new RatingSummeryResponseDTO(mean, ones, twos, threes, fours, fives);
        } catch (Exception e){
            throw new ResourceNotFoundException("Error occurred while fetching ratings based on contractor id");
        }


    }

    @Transactional
    @Override
    public void addUpdateRating(AddUpdateRatingInternalDTO addUpdateRatingInternalDTO) {
        Optional<Rating> existingRatingOpt = ratingRepository.findBySenderIdAndContractorId(addUpdateRatingInternalDTO.getRateSender(), addUpdateRatingInternalDTO.getRateReceiver());
        if (existingRatingOpt.isPresent()) {

            Rating existingRating = existingRatingOpt.get();
            existingRating.setRating(addUpdateRatingInternalDTO.getRating());
            ratingRepository.save(existingRating);

        } else {

            Rating newRating = new Rating();
            newRating.setSenderId(addUpdateRatingInternalDTO.getRateSender());


            newRating.setContractor(
                    contractorRepository.findById(addUpdateRatingInternalDTO.getRateReceiver())
                            .orElseThrow(() -> new IllegalArgumentException("Contractor not found"))
            );

            newRating.setRating(addUpdateRatingInternalDTO.getRating());
            ratingRepository.save(newRating);
        }
    }
}
