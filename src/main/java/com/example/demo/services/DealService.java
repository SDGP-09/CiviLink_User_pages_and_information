package com.example.demo.services;

import com.example.demo.dtos.internal.postAddInternalDTO;
import com.example.demo.dtos.response.AddResponseDTO;

public interface DealService {


    public AddResponseDTO postAdd(postAddInternalDTO postAddInternalDTO);
}
