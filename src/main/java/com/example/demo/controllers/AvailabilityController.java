//package com.example.demo.controllers;
//import com.example.demo.entities.Availability;
//import com.example.demo.services.AvailabilityService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/availability")
//public class AvailabilityController {
//
//    @Autowired
//    private AvailabilityService availabilityService;
//
//    @GetMapping("/{userId}")
//    public ResponseEntity<Availability> getAvailability(@PathVariable String userId) {
//        return ResponseEntity.ok(availabilityService.getAvailability(userId));
//    }
//
//    @PutMapping("/{userId}")
//    public ResponseEntity<Availability> updateAvailability(@PathVariable String userId, @RequestBody Availability availability) {
//        availability.setId(userId); // Ensure it's updating the correct record
//        return ResponseEntity.ok(availabilityService.updateAvailability(availability));
//    }
//}
package com.example.demo.controllers;

import com.example.demo.entities.Availability;
import com.example.demo.services.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/availability")
public class AvailabilityController {

    @Autowired
    private AvailabilityService availabilityService;

    // Create Availability
    @PostMapping
    public ResponseEntity<Availability> createAvailability(@RequestBody Availability availability) {
        Availability savedAvailability = availabilityService.saveAvailability(availability);
        return ResponseEntity.ok(savedAvailability);
    }

    // Get Availability by User ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<Availability> getAvailabilityByUserId(@PathVariable String userId) {
        Availability availability = availabilityService.getAvailabilityByUserId(userId);
        return availability != null ? ResponseEntity.ok(availability) : ResponseEntity.notFound().build();
    }

    // Get Availability by ID
    @GetMapping("/{id}")
    public ResponseEntity<Availability> getAvailabilityById(@PathVariable String id) {
        Optional<Availability> availability = availabilityService.getAvailabilityById(id);
        return availability.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get All Availabilities
    @GetMapping
    public ResponseEntity<List<Availability>> getAllAvailabilities() {
        List<Availability> availabilities = availabilityService.getAllAvailabilities();
        return ResponseEntity.ok(availabilities);
    }

    // Update Availability
    @PutMapping("/{id}")
    public ResponseEntity<Availability> updateAvailability(@PathVariable String id, @RequestBody Availability availability) {
        Optional<Availability> existingAvailability = availabilityService.getAvailabilityById(id);
        if (existingAvailability.isPresent()) {
            availability.setId(id); // Ensure the same ID is updated
            Availability updatedAvailability = availabilityService.saveAvailability(availability);
            return ResponseEntity.ok(updatedAvailability);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete Availability by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAvailabilityById(@PathVariable String id) {
        Optional<Availability> existingAvailability = availabilityService.getAvailabilityById(id);
        if (existingAvailability.isPresent()) {
            availabilityService.deleteAvailabilityById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete All Availabilities
    @DeleteMapping
    public ResponseEntity<Void> deleteAllAvailabilities() {
        availabilityService.deleteAllAvailabilities();
        return ResponseEntity.noContent().build();
    }
}

