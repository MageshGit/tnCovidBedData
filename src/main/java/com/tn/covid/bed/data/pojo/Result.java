package com.tn.covid.bed.data.pojo;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result{
    public String _id;
    @JsonProperty("BedDetailProcessedDate") 
    public int bedDetailProcessedDate;
    @JsonProperty("Name") 
    public String name;
    @JsonProperty("District") 
    public District district;
    @JsonProperty("FacilityType") 
    public String facilityType;
    @JsonProperty("Type") 
    public Type type;
    @JsonProperty("Landline") 
    public String landline;
    @JsonProperty("MobileNumber") 
    public String mobileNumber;
    @JsonProperty("PrimaryContactPerson") 
    public String primaryContactPerson;
    @JsonProperty("CovidBedDetails") 
    public CovidBedDetails covidBedDetails;
    @JsonProperty("ContactDetails") 
    public ArrayList<ContactDetail> contactDetails;
    @JsonProperty("AddressDetail") 
    public AddressDetail addressDetail;
    @JsonProperty("Latitude") 
    public double latitude;
    @JsonProperty("Longitude") 
    public double longitude;
    @JsonProperty("UpdatedDateTime") 
    public int updatedDateTime;
    @JsonProperty("Last6HoursUpdate") 
    public int last6HoursUpdate;
    @JsonProperty("PaediatricsCovidBedDetails") 
    public String paediatricsCovidBedDetails;
}
