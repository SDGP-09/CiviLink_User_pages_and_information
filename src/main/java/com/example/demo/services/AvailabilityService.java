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

    // Get Availability by User ID
    public Availability getAvailabilityByUserId(String userId) {
        return availabilityRepository.findByUserId(userId);
    }

    // Get Availability by ID
//    public Optional<Availability> getAvailabilityById(Long id) {
//        return availabilityRepository.findById(id);
//    }

    // Get All Availabilities
    public List<Availability> getAllAvailabilities() {
        return availabilityRepository.findAll();
    }

    // Update Availability
    public Availability updateAvailability(Availability availability) {
        return availabilityRepository.save(availability);
    }

    // Delete Availability by ID
    public void deleteAvailability(Long id) {
        availabilityRepository.deleteById(id);
    }
}
