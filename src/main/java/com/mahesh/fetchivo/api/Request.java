package com.mahesh.fetchivo.api;

import lombok.Data;

@Data
public class Request{
    public String type;
    public String query;
    public String language;
    public String unit;
}