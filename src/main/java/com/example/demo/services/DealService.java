package com.example.demo.services;

import com.example.demo.dtos.internal.PostAddInternalDTO;
import com.example.demo.dtos.response.AddResponseDTO;

public interface DealService {


    public AddResponseDTO postAdd(PostAddInternalDTO postAddInternalDTO);
}
