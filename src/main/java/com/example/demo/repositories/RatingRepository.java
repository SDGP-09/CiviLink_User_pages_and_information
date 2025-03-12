package com.example.demo.repositories;


import com.example.demo.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {


    @Query("SELECT r.rating, COUNT(r) " +
            "FROM Rating r " +
            "WHERE r.contractor.id = :contractorId " +
            "GROUP BY r.rating")
    List<Object[]> findRatingCountsByContractorId(@Param("contractorId") Long contractorId);
}
