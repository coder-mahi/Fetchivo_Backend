package com.mahesh.fetchivo.api;

import lombok.Data;

@Data
public class Astro{
    public String sunrise;
    public String sunset;
    public String moonrise;
    public String moonset;
    public String moon_phase;
    public int moon_illumination;
}
