package com.example.demo.services;

import com.example.demo.entities.Availability;
import com.example.demo.repositories.AvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvailabilityService {

    @Autowired
    private AvailabilityRepository availabilityRepository;

    public Availability getAvailability(String userId) {
        return availabilityRepository.findByUserId(userId);
    }

    public Availability updateAvailability(Availability availability) {
        return availabilityRepository.save(availability);
    }
}

