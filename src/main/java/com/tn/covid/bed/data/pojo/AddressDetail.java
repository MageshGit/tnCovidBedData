package com.tn.covid.bed.data.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressDetail{
    public String _id;
    @JsonProperty("Line1") 
    public String line1;
    @JsonProperty("Line3") 
    public String line3;
    @JsonProperty("Taluk") 
    public Taluk taluk;
    @JsonProperty("Line2") 
    public String line2;
    @JsonProperty("Pincode") 
    public String pincode;
}