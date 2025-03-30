package com.example.demo.dtos.request;

import com.example.demo.enums.ContractorField;

public class ContractorCreationRequestDTO {
    private String id;
    private String name;
    private String location;
    private String companyName;
    private ContractorField field;



    public String getId() {
        return id;
    }

    public void setId(String id) {
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
            String id,
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
