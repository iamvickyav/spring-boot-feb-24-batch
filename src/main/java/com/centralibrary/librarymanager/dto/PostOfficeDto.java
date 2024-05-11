package com.centralibrary.librarymanager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostOfficeDto {

    @JsonProperty("postOfficeName")
    String name;
    String district;
    String region;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
