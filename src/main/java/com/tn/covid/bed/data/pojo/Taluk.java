package com.tn.covid.bed.data.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Taluk{
    public String _id;
    @JsonProperty("IsDeleted") 
    public boolean isDeleted;
    @JsonProperty("SortOrder") 
    public int sortOrder;
    @JsonProperty("Code") 
    public String code;
    @JsonProperty("TamilName") 
    public String tamilName;
    @JsonProperty("Name") 
    public String name;
    @JsonProperty("District") 
    public String district;
    public Date createdAt;
    public Date updatedAt;
    public int __v;
}
