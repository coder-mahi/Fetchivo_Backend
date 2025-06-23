package com.mahesh.fetchivo.controller;

import com.mahesh.fetchivo.api.WheatherResponse;
import com.mahesh.fetchivo.service.WheatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {
    @Autowired
    private WheatherService weatherService;

    @GetMapping("/{city}")
    public ResponseEntity<?> getWeather(@PathVariable String city){
        WheatherResponse response = weatherService.getWheather(city);
        String result = "";
        if(response!=null){
            result = "Today's weather at "+city+" feels like : "+response.getCurrent().feelslike;
        }
        return new ResponseEntity<>("Hello Mahesh, "+result, HttpStatus.OK);
    }

    @GetMapping("/{city}/all-details")
    public WheatherResponse getDetailedWeather(@PathVariable String city){
        WheatherResponse response = weatherService.getWheather(city);
        return response;
    }
}
