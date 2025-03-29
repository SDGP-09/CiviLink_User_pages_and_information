package com.example.demo.dtos.request;

import com.example.demo.enums.ContractorField;

public class ContractorCreationRequestDTO {
    private Long id;
    private String name;
    private String location;
    private String companyName;
    private ContractorField field;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public ContractorField getField() {
        return field;
    }

    public void setField(ContractorField field) {
        this.field = field;
    }

    public ContractorCreationRequestDTO(
            Long id,
            String name,
            String location,
            String companyName,
            ContractorField field
    ) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.companyName = companyName;
        this.field = field;
    }

    public ContractorCreationRequestDTO(){}
}
