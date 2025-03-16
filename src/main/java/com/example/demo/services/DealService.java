package com.example.demo.services;

import com.example.demo.dtos.internal.AddIdBasedInternalDTO;
import com.example.demo.dtos.internal.PostAddInternalDTO;
import com.example.demo.dtos.internal.UpdateAddInternalDTO;
import com.example.demo.dtos.response.AddResponseDTO;

public interface DealService {


    public AddResponseDTO postAdd(PostAddInternalDTO postAddInternalDTO);

    public AddResponseDTO updateDTO(UpdateAddInternalDTO updateAddInternalDTO);

    public void toggleVisibility(AddIdBasedInternalDTO addIdBasedInternalDTO);

    public void deleteAdd(AddIdBasedInternalDTO addIdBasedInternalDTO);
}
