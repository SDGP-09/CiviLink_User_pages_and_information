package com.example.demo.services.impl;

import com.example.demo.dtos.internal.postAddInternalDTO;
import com.example.demo.dtos.response.AddResponseDTO;
import com.example.demo.repositories.DealRepository;
import com.example.demo.services.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DealServiceImpl implements DealService {

    @Autowired
    private DealRepository dealRepository;


    @Override
    public AddResponseDTO postAdd(postAddInternalDTO postAddInternalDTO) {
        return null;
    }
}
