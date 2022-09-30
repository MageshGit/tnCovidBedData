package com.tn.covid.data.pojo;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {
	@JsonProperty("SupportNumber")
	public String supportNumber;
	@JsonProperty("IsDeleted")
	public boolean isDeleted;
	public String _id;
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
	public Object state;
	@JsonProperty("ColorCode")
	public String colorCode;
	@JsonProperty("Admins")
	public ArrayList<Object> admins;
	public String id;
	@JsonProperty("IsSpecial")
	public boolean isSpecial;
}
