//package com.example.demo.services;
//
//public class AvailabilityService {
//}
package com.example.projectmanagement.service;

import com.example.projectmanagement.model.Availability;
import com.example.projectmanagement.repository.AvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvailabilityService {

    @Autowired
    private AvailabilityRepository availabilityRepository;

    public Availability getAvailability(Long userId) {
        return availabilityRepository.findByUserId(userId);
    }

    public Availability updateAvailability(Availability availability) {
        return availabilityRepository.save(availability);
    }
}
//5️⃣ Controller Layer (REST APIs)
