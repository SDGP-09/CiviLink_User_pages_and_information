//package com.example.demo.services;
//
//import com.example.demo.entities.HotDeal;
//import com.example.demo.repositories.HotDealRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class HotDealService {
//
//    @Autowired
//    private HotDealRepository hotDealRepository;
//
//    public List<HotDeal> getHotDealsByUser(String userId) {
//        return hotDealRepository.findByUserId(userId);
//    }
//
//    public HotDeal addHotDeal(HotDeal hotDeal) {
//        return hotDealRepository.save(hotDeal);
//    }
//
//    public HotDeal updateHotDeal(String id, HotDeal updatedHotDeal) {
//        updatedHotDeal.setId(id);
//        return hotDealRepository.save(updatedHotDeal);
//    }
//
//    public void deleteHotDeal(String id) {
//        hotDealRepository.deleteById(id);
//    }
//}
package com.example.demo.services;

import com.example.demo.entities.HotDeal;
import com.example.demo.repositories.HotDealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotDealService {

    @Autowired
    private HotDealRepository hotDealRepository;

    // Create HotDeal
    public HotDeal addHotDeal(HotDeal hotDeal) {
        return hotDealRepository.save(hotDeal);
    }

    // Read - Get all HotDeals
    public List<HotDeal> getAllHotDeals() {
        return hotDealRepository.findAll();
    }

    // Read - Get HotDeals by User ID
    public List<HotDeal> getHotDealsByUser(String userId) {
        return hotDealRepository.findByUserId(userId);
    }

    // Read - Get HotDeal by ID
    public Optional<HotDeal> getHotDealById(String id) {
        return hotDealRepository.findById(id);
    }

    // Update HotDeal
    public HotDeal updateHotDeal(String id, HotDeal updatedHotDeal) {
        updatedHotDeal.setId(id);
        return hotDealRepository.save(updatedHotDeal);
    }

    // Delete - Remove HotDeal by ID
    public void deleteHotDeal(String id) {
        hotDealRepository.deleteById(id);
    }

    // Delete - Remove All HotDeals
    public void deleteAllHotDeals() {
        hotDealRepository.deleteAll();
    }
}
