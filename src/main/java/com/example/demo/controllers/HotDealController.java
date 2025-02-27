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