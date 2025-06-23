package com.mahesh.fetchivo.api;


import com.fasterxml.jackson.annotation.JsonProperty;

public class AirQuality{
    public String co;
    public String no2;
    public String o3;
    public String so2;
    public String pm2_5;
    public String pm10;
    @JsonProperty("us-epa-index")
    public String us_epaindex;
    @JsonProperty("gb-defra-index")
    public String gb_defra_index;
}