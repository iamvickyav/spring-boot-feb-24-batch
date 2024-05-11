package com.centralibrary.librarymanager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = false)
public class PostOffice {
    @JsonProperty("Message")
    public String message;
    @JsonProperty("PostOffice")
    public List<PostOfficeDetail> postOffice;
}
