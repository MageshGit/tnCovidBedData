package com.tn.covid.bed.data.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CovidBedDetails {
	@JsonProperty("Remarks")
	public String remarks;
	@JsonProperty("LastUpdatedTime")
	public int lastUpdatedTime;
	@JsonProperty("LastUpdatedBy")
	public String lastUpdatedBy;
	@JsonProperty("LastUpdatedByUser")
	public String lastUpdatedByUser;
	@JsonProperty("UpdateMissedCount")
	public int updateMissedCount;
	public String _id;
	@JsonProperty("TotalBedsInHospital")
	public int totalBedsInHospital;
	@JsonProperty("BedsAllotedForCovidTreatment")
	public int bedsAllotedForCovidTreatment;
	@JsonProperty("AllotedO2Beds")
	public int allotedO2Beds;
	@JsonProperty("AllotedNonO2Beds")
	public int allotedNonO2Beds;
	@JsonProperty("AllotedICUBeds")
	public int allotedICUBeds;
	@JsonProperty("OccupancyO2Beds")
	public int occupancyO2Beds;
	@JsonProperty("OccupancyNonO2Beds")
	public int occupancyNonO2Beds;
	@JsonProperty("OccupancyICUBeds")
	public int occupancyICUBeds;
	@JsonProperty("VaccantO2Beds")
	public int vaccantO2Beds;
	@JsonProperty("VaccantNonO2Beds")
	public int vaccantNonO2Beds;
	@JsonProperty("VaccantICUBeds")
	public int vaccantICUBeds;
	@JsonProperty("StatusAsOf")
	public int statusAsOf;
	@JsonProperty("TotalVaccantBeds")
	public int totalVaccantBeds;
	@JsonProperty("UpdatedOn")
	public int updatedOn;
	@JsonProperty("OccupancySuspectedCountInO2")
	public int occupancySuspectedCountInO2;
	@JsonProperty("OccupancySuspectedCountInNonO2")
	public int occupancySuspectedCountInNonO2;
	@JsonProperty("OccupancySuspectedCountInICU")
	public int occupancySuspectedCountInICU;
	@JsonProperty("EarMarkedO2Beds")
	public int earMarkedO2Beds;
	@JsonProperty("EarMarkedNonO2Beds")
	public int earMarkedNonO2Beds;
	@JsonProperty("EarMarkedICUBeds")
	public int earMarkedICUBeds;
	@JsonProperty("TotalEarMarkedBeds")
	public int totalEarMarkedBeds;
	@JsonProperty("PaediatricAllotedO2Beds")
	public int paediatricAllotedO2Beds;
	@JsonProperty("PaediatricAllotedNonO2Beds")
	public int paediatricAllotedNonO2Beds;
	@JsonProperty("PaediatricAllotedICUBeds")
	public int paediatricAllotedICUBeds;
	@JsonProperty("PaediatricEarMarkedO2Beds")
	public int paediatricEarMarkedO2Beds;
	@JsonProperty("PaediatricEarMarkedNonO2Beds")
	public int paediatricEarMarkedNonO2Beds;
	@JsonProperty("PaediatricEarMarkedICUBeds")
	public int paediatricEarMarkedICUBeds;
	@JsonProperty("PaediatricOccupancyO2Beds")
	public int paediatricOccupancyO2Beds;
	@JsonProperty("PaediatricOccupancyNonO2Beds")
	public int paediatricOccupancyNonO2Beds;
	@JsonProperty("PaediatricOccupancyICUBeds")
	public int paediatricOccupancyICUBeds;
	@JsonProperty("PaediatricOccupancySuspectedCountInO2")
	public int paediatricOccupancySuspectedCountInO2;
	@JsonProperty("PaediatricOccupancySuspectedCountInNonO2")
	public int paediatricOccupancySuspectedCountInNonO2;
	@JsonProperty("PaediatricOccupancySuspectedCountInICU")
	public int paediatricOccupancySuspectedCountInICU;
	@JsonProperty("PaediatricVaccantO2Beds")
	public int paediatricVaccantO2Beds;
	@JsonProperty("PaediatricVaccantNonO2Beds")
	public int paediatricVaccantNonO2Beds;
	@JsonProperty("PaediatricVaccantICUBeds")
	public int paediatricVaccantICUBeds;
	@JsonProperty("PaediatricTotalVaccantBeds")
	public int paediatricTotalVaccantBeds;
	@JsonProperty("PaediatricBedsAllotedForCovidTreatment")
	public int paediatricBedsAllotedForCovidTreatment;
	@JsonProperty("PaediatricTotalEarMarkedBeds")
	public int paediatricTotalEarMarkedBeds;
	@JsonProperty("AdultTotalBedsInHospital")
	public int adultTotalBedsInHospital;
	@JsonProperty("PaediatricTotalBedsInHospital")
	public int paediatricTotalBedsInHospital;
	@JsonProperty("TotalAllotedICUBeds")
	public int totalAllotedICUBeds;
	@JsonProperty("TotalAllotedNonO2Beds")
	public int totalAllotedNonO2Beds;
	@JsonProperty("TotalAllotedO2Beds")
	public int totalAllotedO2Beds;
	@JsonProperty("TotalBedsAllotedForCovidTreatment")
	public int totalBedsAllotedForCovidTreatment;
	@JsonProperty("TotalEarMarkedICUBeds")
	public int totalEarMarkedICUBeds;
	@JsonProperty("TotalEarMarkedNonO2Beds")
	public int totalEarMarkedNonO2Beds;
	@JsonProperty("TotalEarMarkedO2Beds")
	public int totalEarMarkedO2Beds;
	@JsonProperty("TotalOccupancyICUBeds")
	public int totalOccupancyICUBeds;
	@JsonProperty("TotalOccupancyNonO2Beds")
	public int totalOccupancyNonO2Beds;
	@JsonProperty("TotalOccupancyO2Beds")
	public int totalOccupancyO2Beds;
	@JsonProperty("TotalOccupancySuspectedCountInICU")
	public int totalOccupancySuspectedCountInICU;
	@JsonProperty("TotalOccupancySuspectedCountInNonO2")
	public int totalOccupancySuspectedCountInNonO2;
	@JsonProperty("TotalOccupancySuspectedCountInO2")
	public int totalOccupancySuspectedCountInO2;
	@JsonProperty("TotalTotalBedsInHospital")
	public int totalTotalBedsInHospital;
	@JsonProperty("TotalTotalVaccantBeds")
	public int totalTotalVaccantBeds;
	@JsonProperty("TotalVaccantICUBeds")
	public int totalVaccantICUBeds;
	@JsonProperty("TotalVaccantNonO2Beds")
	public int totalVaccantNonO2Beds;
	@JsonProperty("TotalVaccantO2Beds")
	public int totalVaccantO2Beds;
}
