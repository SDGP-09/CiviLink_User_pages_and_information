//package com.example.demo.services;
//
//public class HotDealService {
//}
package com.example.projectmanagement.service;

import com.example.projectmanagement.model.HotDeal;
import com.example.projectmanagement.repository.HotDealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotDealService {

    @Autowired
    private HotDealRepository hotDealRepository;

    public List<HotDeal> getHotDealsByUser(Long userId) {
        return hotDealRepository.findByUserId(userId);
    }

    public HotDeal addHotDeal(HotDeal hotDeal) {
        return hotDealRepository.save(hotDeal);
    }

    public HotDeal updateHotDeal(Long id, HotDeal updatedHotDeal) {
        updatedHotDeal.setId(id);
        return hotDealRepository.save(updatedHotDeal);
    }

    public void deleteHotDeal(Long id) {
        hotDealRepository.deleteById(id);
    }
}
