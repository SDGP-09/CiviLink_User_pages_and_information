package com.example.demo.services;

import com.example.demo.entities.HotDeal;
import com.example.demo.repositories.HotDealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotDealService {

    @Autowired
    private HotDealRepository hotDealRepository;

    public List<HotDeal> getHotDealsByUser(String userId) {
        return hotDealRepository.findByUserId(userId);
    }

    public HotDeal addHotDeal(HotDeal hotDeal) {
        return hotDealRepository.save(hotDeal);
    }

    public HotDeal updateHotDeal(String id, HotDeal updatedHotDeal) {
        updatedHotDeal.setId(id);
        return hotDealRepository.save(updatedHotDeal);
    }

    public void deleteHotDeal(String id) {
        hotDealRepository.deleteById(id);
    }
}
