package com.example.demo.dtos.response;

import com.example.demo.types.DealPortable;

public class AllDealsResponseDTO {
    private DealPortable[] deals;

    public DealPortable[] getDeals() {
        return deals;
    }

    public void setDeals(DealPortable[] deals) {
        this.deals = deals;
    }

    public AllDealsResponseDTO(DealPortable[] deals){
        this.deals = deals;
    }

    public AllDealsResponseDTO(){}
}
