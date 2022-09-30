package com.tn.covid.data.pojo;

import java.util.ArrayList;

//import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
//import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */


public class Root{
 public ArrayList<Result> result;
 public Object exception;
 public Object pagination;
 public String statusCode;
 public ArrayList<Object> errors;
 public ArrayList<Object> warnings;
}

