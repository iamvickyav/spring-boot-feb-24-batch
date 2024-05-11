package com.centralibrary.librarymanager.service;

import com.centralibrary.librarymanager.dto.PostOffice;
import com.centralibrary.librarymanager.dto.PostOfficeDetail;
import com.centralibrary.librarymanager.dto.PostOfficeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    RestTemplate restTemplate;

    public List<PostOfficeDto> getPostOfficeByPinCode(String pinCode) {
        System.out.println("Called getPostOfficeByPinCode");
        ResponseEntity<List<PostOffice>> response = restTemplate.exchange("https://api.postalpincode.in/pincode/" + pinCode,
                HttpMethod.GET, null,
                new ParameterizedTypeReference<List<PostOffice>>() {
                });
        if(response.getStatusCode().value() == 200) {
            List<PostOffice> postOfficeList =  response.getBody();
            List<PostOfficeDetail> postofficeDetailList = postOfficeList.stream().findFirst().get().postOffice;
            List<PostOfficeDto> responseFromApi = postofficeDetailList.stream().map(postOffice -> {
                PostOfficeDto postOfficeDto = new PostOfficeDto();
                postOfficeDto.setName(postOffice.name);
                postOfficeDto.setDistrict(postOffice.district);
                postOfficeDto.setRegion(postOffice.region);
                return postOfficeDto;
            }).collect(Collectors.toList());

            return responseFromApi;

        } else {
            return Collections.EMPTY_LIST;
        }
    }
}