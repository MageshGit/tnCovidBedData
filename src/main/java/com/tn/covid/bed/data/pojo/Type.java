package com.tn.covid.bed.data.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Type{
    public String _id;
    @JsonProperty("Name") 
    public String name;
    @JsonProperty("IsDeleted") 
    public boolean isDeleted;
}