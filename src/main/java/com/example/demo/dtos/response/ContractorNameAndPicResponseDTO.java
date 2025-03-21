package com.example.demo.dtos.response;

import com.example.demo.types.ContractorNameAndPicture;

public class ContractorNameAndPicResponseDTO {
    private ContractorNameAndPicture[] contractorList;

    public ContractorNameAndPicture[] getContractorList() {
        return contractorList;
    }

    public void setContractorList(ContractorNameAndPicture[] contractorList) {
        this.contractorList = contractorList;
    }

    public ContractorNameAndPicResponseDTO(ContractorNameAndPicture[] contractorList) {
        this.contractorList = contractorList;
    }

    public ContractorNameAndPicResponseDTO(){}

}
