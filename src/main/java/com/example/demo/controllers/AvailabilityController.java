//package com.example.demo.controllers;
//
//public class AvailabilityController {
//}
package com.example.projectmanagement.controller;

import com.example.projectmanagement.model.Availability;
import com.example.projectmanagement.service.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/availability")
public class AvailabilityController {

    @Autowired
    private AvailabilityService availabilityService;

    @GetMapping("/{userId}")
    public ResponseEntity<Availability> getAvailability(@PathVariable Long userId) {
        return ResponseEntity.ok(availabilityService.getAvailability(userId));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Availability> updateAvailability(@PathVariable Long userId, @RequestBody Availability availability) {
        availability.setId(userId); // Ensure it's updating the correct record
        return ResponseEntity.ok(availabilityService.updateAvailability(availability));
    }
}

