package com.example.demo.repositories;

import com.example.demo.entities.HotDeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotDealRepository extends JpaRepository<HotDeal, Long> {
    List<HotDeal> findByUserId(Long userId);
}

