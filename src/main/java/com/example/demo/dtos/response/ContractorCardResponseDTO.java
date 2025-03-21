package com.example.demo.dtos.response;

import com.example.demo.types.ContractorCard;

public class ContractorCardResponseDTO {

    private ContractorCard[] contractorCards;


    public ContractorCard[] getContractorCards() {
        return contractorCards;
    }

    public void setContractorCards(ContractorCard[] contractorCards) {
        this.contractorCards = contractorCards;
    }

    public ContractorCardResponseDTO(ContractorCard[] contractorCards) {
        this.contractorCards = contractorCards;
    }

    public ContractorCardResponseDTO(){}

}
