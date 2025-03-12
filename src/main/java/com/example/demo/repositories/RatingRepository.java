package com.example.demo.repositories;


import com.example.demo.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RatingRepository extends JpaRepository<Rating, Long> {


    @Query("SELECT r.rating, COUNT(r) " +
            "FROM Rating r " +
            "WHERE r.contractor.id = :contractorId " +
            "GROUP BY r.rating")
    List<Object[]> findRatingCountsByContractorId(@Param("contractorId") Long contractorId);

    @Query("SELECT r FROM Rating r WHERE r.senderId = :senderId AND r.contractor.id = :contractorId")
    Optional<Rating> findBySenderIdAndContractorId(@Param("senderId") Long senderId,
                                                   @Param("contractorId") Long contractorId);
}
