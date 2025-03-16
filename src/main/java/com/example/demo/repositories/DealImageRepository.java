package com.example.demo.repositories;

import com.example.demo.entities.Deal;
import com.example.demo.entities.DealImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DealImageRepository extends JpaRepository<DealImage, Long> {
}
