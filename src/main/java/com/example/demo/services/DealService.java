package com.example.demo.services;

import com.example.demo.dtos.request.AddRequestDTO;
import com.example.demo.dtos.response.AddResponseDTO;

public interface DealService {


    public AddResponseDTO postAdd(AddRequestDTO addRequestDTO);
}
