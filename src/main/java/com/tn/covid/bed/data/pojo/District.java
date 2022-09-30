package com.tn.covid.bed.data.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class District{
    public String _id;
    @JsonProperty("IsDeleted") 
    public boolean isDeleted;
    @JsonProperty("SortOrder") 
    public int sortOrder;
    @JsonProperty("StateCode") 
    public String stateCode;
    @JsonProperty("Code") 
    public String code;
    @JsonProperty("TamilName") 
    public String tamilName;
    @JsonProperty("Name") 
    public String name;
    @JsonProperty("ShortCode") 
    public String shortCode;
    public Date createdAt;
    public Date updatedAt;
    public int __v;
    @JsonProperty("State") 
    public String state;
    @JsonProperty("ColorCode") 
    public String colorCode;
    @JsonProperty("IsSpecial") 
    public boolean isSpecial;
}
