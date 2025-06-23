package com.mahesh.fetchivo.api;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data
public class Current{
    @JsonProperty("observation_time")
    public String observation_time;
    public int temperature;
    public int weather_code;
    public List<String> weather_icons;
    public List<String> weather_descriptions;
    public Astro astro;
    public AirQuality air_quality;
    public int wind_speed;
    public int wind_degree;
    public String wind_dir;
    public int pressure;
    public int precip;
    public int humidity;
    public int cloudcover;
    public int feelslike;
    public int uv_index;
    public int visibility;
    public String is_day;
}