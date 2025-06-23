package com.mahesh.fetchivo.api;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class WheatherResponse{
    public Request request;
    public Location location;
    public Current current;

    public Current getCurrent() {
        return this.current;
    }
    public Location getLocation(){
        return this.location;
    }
    public Request getRequest(){
        return this.request;
    }
}

