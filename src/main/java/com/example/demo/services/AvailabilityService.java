//package com.example.demo.services;
//
//import com.example.demo.entities.Availability;
//import com.example.demo.repositories.AvailabilityRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AvailabilityService {
//
//    @Autowired
//    private AvailabilityRepository availabilityRepository;
//
//    public Availability getAvailability(String userId) {
//        return availabilityRepository.findByUserId(userId);
//    }
//
//    public Availability updateAvailability(Availability availability) {
//        return availabilityRepository.save(availability);
//    }
//}

package com.example.demo.services;

import com.example.demo.entities.Availability;
import com.example.demo.repositories.AvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvailabilityService {

    @Autowired
    private AvailabilityRepository availabilityRepository;

    // Create or Update Availability
    public Availability saveAvailability(Availability availability) {
        return availabilityRepository.save(availability);
    }

    // Read - Get Availability by User ID
    public Availability getAvailabilityByUserId(String userId) {
        return availabilityRepository.findByUserId(userId);
    }

    // Read - Get Availability by ID
    public Optional<Availability> getAvailabilityById(String id) {
        return availabilityRepository.findById(id);
    }

    // Read - Get All Availabilities
    public List<Availability> getAllAvailabilities() {
        return availabilityRepository.findAll();
    }

    // Update - Update an Existing Availability
    public Availability updateAvailability(Availability availability) {
        return availabilityRepository.save(availability);
    }

    // Delete - Remove Availability by ID
    public void deleteAvailabilityById(String id) {
        availabilityRepository.deleteById(id);
    }

    // Delete - Remove All Availabilities
    public void deleteAllAvailabilities() {
        availabilityRepository.deleteAll();
    }
}
