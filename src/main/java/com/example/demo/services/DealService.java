package com.example.demo.services;

import com.example.demo.dtos.internal.AddIdBasedInternalDTO;
import com.example.demo.dtos.internal.PostAddInternalDTO;
import com.example.demo.dtos.internal.UpdateAddInternalDTO;
import com.example.demo.dtos.request.IdBasedRequestDTO;
import com.example.demo.dtos.response.AddResponseDTO;
import com.example.demo.dtos.response.AllDealsResponseDTO;

public interface DealService {


    public AddResponseDTO postAdd(PostAddInternalDTO postAddInternalDTO);

    public AddResponseDTO updateDTO(UpdateAddInternalDTO updateAddInternalDTO);

    public void toggleVisibility(AddIdBasedInternalDTO addIdBasedInternalDTO);

    public void deleteAdd(AddIdBasedInternalDTO addIdBasedInternalDTO);

    public AllDealsResponseDTO getDealsByContractorId(IdBasedRequestDTO idBasedRequestDTO);
}
