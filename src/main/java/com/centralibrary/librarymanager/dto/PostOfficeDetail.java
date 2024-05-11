package com.centralibrary.librarymanager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostOfficeDetail {

    @JsonProperty("Name")
    public String name;
    @JsonProperty("Description")
    public Object description;
    @JsonProperty("BranchType")
    public String branchType;
    @JsonProperty("DeliveryStatus")
    public String deliveryStatus;
    @JsonProperty("Circle")
    public String circle;
    @JsonProperty("District")
    public String district;
    @JsonProperty("Division")
    public String division;
    @JsonProperty("Region")
    public String region;
    @JsonProperty("Block")
    public String block;
    @JsonProperty("State")
    public String state;
    @JsonProperty("Country")
    public String country;
    @JsonProperty("Pincode")
    public String pincode;
}