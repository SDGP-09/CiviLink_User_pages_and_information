package com.example.demo.repositories;

import com.example.demo.entities.Contractor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ContractorRepository extends JpaRepository<Contractor, Long> {
    List<Contractor> findByNameContainingIgnoreCaseOrLocationContainingIgnoreCase(String name, String location);
}

