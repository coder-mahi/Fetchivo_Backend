package com.mahesh.fetchivo.service;

import com.mahesh.fetchivo.api.WheatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WheatherService {
    private static final String apiKey = "5ee732acaf5bb4d948563d684d004c28";
    private static final String city = "New York";
    private static final String API = "http://api.weatherstack.com/current?access_key="+apiKey+"&query=CITY";

    @Autowired
    private RestTemplate restTemplate;


    public WheatherResponse getWheather(String city){
        String finalApi = API.replace("CITY",city).replace("API_KEY",apiKey);
        ResponseEntity<WheatherResponse> res =  restTemplate.exchange(finalApi, HttpMethod.GET, null, WheatherResponse.class);
        WheatherResponse result = res.getBody();
        return result;
    }

}
