//package com.example.demo.controllers;
//
//import com.example.demo.entities.HotDeal;
//import com.example.demo.services.HotDealService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/hot-deals")
//public class HotDealController {
//
//    @Autowired
//    private HotDealService hotDealService;
//
//    @GetMapping("/{userId}")
//    public ResponseEntity<List<HotDeal>> getHotDeals(@PathVariable String userId) {
//        return ResponseEntity.ok(hotDealService.getHotDealsByUser(userId));
//    }
//
//    @PostMapping("/")
//    public ResponseEntity<HotDeal> addHotDeal(@RequestBody HotDeal hotDeal) {
//        return ResponseEntity.ok(hotDealService.addHotDeal(hotDeal));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<HotDeal> updateHotDeal(@PathVariable String id, @RequestBody HotDeal hotDeal) {
//        return ResponseEntity.ok(hotDealService.updateHotDeal(id, hotDeal));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteHotDeal(@PathVariable String id) {
//        hotDealService.deleteHotDeal(id);
//        return ResponseEntity.noContent().build();
//    }
//}
package com.example.demo.controllers;

import com.example.demo.entities.HotDeal;
import com.example.demo.services.HotDealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hot-deals")
public class HotDealController {

    @Autowired
    private HotDealService hotDealService;

    // Create HotDeal
    @PostMapping
    public ResponseEntity<HotDeal> addHotDeal(@RequestBody HotDeal hotDeal) {
        return ResponseEntity.ok(hotDealService.addHotDeal(hotDeal));
    }

    // Get all HotDeals
    @GetMapping
    public ResponseEntity<List<HotDeal>> getAllHotDeals() {
        return ResponseEntity.ok(hotDealService.getAllHotDeals());
    }

    // Get HotDeals by User ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<HotDeal>> getHotDealsByUser(@PathVariable String userId) {
        return ResponseEntity.ok(hotDealService.getHotDealsByUser(userId));
    }

    // Get HotDeal by ID
    @GetMapping("/{id}")
    public ResponseEntity<HotDeal> getHotDealById(@PathVariable String id) {
        Optional<HotDeal> hotDeal = hotDealService.getHotDealById(id);
        return hotDeal.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update HotDeal
    @PutMapping("/{id}")
    public ResponseEntity<HotDeal> updateHotDeal(@PathVariable String id, @RequestBody HotDeal hotDeal) {
        return ResponseEntity.ok(hotDealService.updateHotDeal(id, hotDeal));
    }

    // Delete HotDeal by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotDeal(@PathVariable String id) {
        Optional<HotDeal> existingHotDeal = hotDealService.getHotDealById(id);
        if (existingHotDeal.isPresent()) {
            hotDealService.deleteHotDeal(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete all HotDeals
    @DeleteMapping
    public ResponseEntity<Void> deleteAllHotDeals() {
        hotDealService.deleteAllHotDeals();
        return ResponseEntity.noContent().build();
    }
}
