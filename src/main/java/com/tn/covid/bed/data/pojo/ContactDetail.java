package com.tn.covid.bed.data.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactDetail{
    public String _id;
    @JsonProperty("ContactName") 
    public String contactName;
    @JsonProperty("ContactNumber") 
    public String contactNumber;
    @JsonProperty("Timing") 
    public String timing;
}