package com.tn.covid.data.impl;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tn.covid.data.pojo.Result;
import com.tn.covid.data.pojo.Root;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportData {
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a file path: ");
		System.out.flush();
		String filePath = scanner.nextLine();
		System.out.println("Excel file will be downloaded in the location- " + filePath);
		getHospitalData(getDistricts(), filePath);
	}

	public static Map<String, String> getDistricts() throws JsonMappingException, JsonProcessingException {
		Map<String, String> districts = new TreeMap<String, String>();
		Response response = given().contentType(ContentType.JSON).when()
				.get("https://tncovidbeds.tnega.org/api/district").then().extract().response();

		Root root = new ObjectMapper().readValue(response.asString(), Root.class);

		for (Result result : root.result) {
			districts.put(result._id, result.name);
		}

		districts.forEach((k, v) -> System.out.println((k + ":" + v)));
		return districts;
	}

	public static void getHospitalData(Map<String, String> districts, String userFilePath)
			throws JsonMappingException, JsonProcessingException {
		String currentDate = java.time.LocalDate.now().toString();
		final String FILE_NAME = userFilePath + File.separatorChar + "CovidBedDataTN_" + currentDate + ".xlsx";

		// write to excel
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = null;

		// iterate districts
		// get hospital data based on district
		// create a sheet in district name
		// use pojo to add data about hospital beds
		// exit

		for (Entry<String, String> entry : districts.entrySet()) {
			String currentDistrictId = entry.getKey();
			String currentDistrictName = entry.getValue();
			int rowCounter = 0;

			// create sheet for districts
			sheet = workbook.createSheet(currentDistrictName);

			// write table data
			// write table header
			XSSFRow row0 = sheet.createRow(rowCounter);
			row0.createCell(0).setCellValue("Hospital"); // c1
			row0.createCell(1).setCellValue("Category"); // c2
			row0.createCell(2).setCellValue("Normal Beds"); // c3
			row0.createCell(4).setCellValue("Oxygen Supported Beds"); // c4
			row0.createCell(6).setCellValue("ICU Beds"); // c5
			row0.createCell(8).setCellValue("Total Beds"); // c6
			rowCounter++;

			// write table header-1
			XSSFRow row1 = sheet.createRow(rowCounter);
			row1.createCell(2).setCellValue("Total");
			row1.createCell(3).setCellValue("Vacant");
			row1.createCell(4).setCellValue("Total");
			row1.createCell(5).setCellValue("Vacant");
			row1.createCell(6).setCellValue("Total");
			row1.createCell(7).setCellValue("Vacant");
			row1.createCell(8).setCellValue("Total");
			row1.createCell(9).setCellValue("Vacant");
			rowCounter++;

			String requestBodyUnFormatted = "{\"searchString\":\"\",\"sortCondition\":{\"Name\":1},\"pageNumber\":1,\"pageLimit\":1000,\"SortValue\":\"Availability\",\"ShowIfVacantOnly\":\"\",\"ShowIfPersonOnly\":\"\",\"Districts\":[\"%s\"],\"IsGovernmentHospital\":true,\"IsPrivateHospital\":true,\"FacilityTypes\":[\"CHO\",\"CHC\",\"CCC\",\"ICCC\"]}";
			String requestBody = String.format(requestBodyUnFormatted, currentDistrictId);

			Response response = given().contentType(ContentType.JSON).and().body(requestBody).when()
					.post("https://tncovidbeds.tnega.org/api/hospitals").then().extract().response();

			com.tn.covid.bed.data.pojo.Root root = new ObjectMapper().readValue(response.asString(),
					com.tn.covid.bed.data.pojo.Root.class);

			for (com.tn.covid.bed.data.pojo.Result result : root.result) {

				String hospitalName = result.facilityType + " - " + result.name;

				int normal_total_beds_total = result.covidBedDetails.totalAllotedNonO2Beds; // TotalAllotedNonO2Beds
				int normal_total_beds_vacant = result.covidBedDetails.totalVaccantNonO2Beds; // TotalVaccantNonO2Beds
				int normal_adult_beds_total = result.covidBedDetails.allotedNonO2Beds; // AllotedNonO2Beds
				int normal_adult_beds_vacant = result.covidBedDetails.vaccantNonO2Beds; // VaccantNonO2Beds
				int normal_paediatric_beds_total = result.covidBedDetails.paediatricAllotedNonO2Beds; // PaediatricAllotedNonO2Beds
				int normal_paediatric_beds_vacant = result.covidBedDetails.paediatricVaccantNonO2Beds; // PaediatricVaccantNonO2Beds

				int o2_total_beds_total = result.covidBedDetails.totalAllotedO2Beds; // TotalAllotedO2Beds
				int o2_total_beds_vacant = result.covidBedDetails.totalVaccantO2Beds; // TotalVaccantO2Beds
				int o2_adult_beds_total = result.covidBedDetails.allotedO2Beds; // AllotedO2Beds
				int o2_adult_beds_vacant = result.covidBedDetails.vaccantO2Beds; // VaccantO2Beds
				int o2_paediatric_beds_total = result.covidBedDetails.paediatricAllotedO2Beds;// PaediatricAllotedO2Beds
				int o2_paediatric_beds_vacant = result.covidBedDetails.paediatricVaccantO2Beds; // PaediatricVaccantO2Beds

				int icu_total_beds_total = result.covidBedDetails.totalAllotedICUBeds; // TotalAllotedICUBeds
				int icu_total_beds_vacant = result.covidBedDetails.totalVaccantICUBeds; // TotalVaccantICUBeds
				int icu_adult_beds_total = result.covidBedDetails.allotedICUBeds; // AllotedICUBeds
				int icu_adult_beds_vacant = result.covidBedDetails.vaccantICUBeds; // VaccantICUBeds
				int icu_paediatric_beds_total = result.covidBedDetails.paediatricAllotedICUBeds;// PaediatricAllotedICUBeds
				int icu_paediatric_beds_vacant = result.covidBedDetails.paediatricVaccantICUBeds; // PaediatricVaccantICUBeds

				int total_total_beds_total = result.covidBedDetails.totalBedsInHospital; // TotalBedsInHospital
				int total_total_beds_vacant = result.covidBedDetails.totalTotalVaccantBeds; // TotalTotalVaccantBeds
				int total_adult_beds_total = result.covidBedDetails.adultTotalBedsInHospital; // AdultTotalBedsInHospital
				int total_adult_beds_vacant = result.covidBedDetails.totalVaccantBeds; // TotalVaccantBeds
				int total_paediatric_beds_total = result.covidBedDetails.paediatricTotalBedsInHospital;// PaediatricTotalBedsInHospital
				int total_paediatric_beds_vacant = result.covidBedDetails.paediatricTotalVaccantBeds; // PaediatricTotalVaccantBeds

				// add table data
				XSSFRow rowTotal = sheet.createRow(rowCounter);
				rowTotal.createCell(0).setCellValue(hospitalName);
				rowTotal.createCell(1).setCellValue("Total");
				rowTotal.createCell(2).setCellValue(normal_total_beds_total);
				rowTotal.createCell(3).setCellValue(normal_total_beds_vacant);
				rowTotal.createCell(4).setCellValue(o2_total_beds_total);
				rowTotal.createCell(5).setCellValue(o2_total_beds_vacant);
				rowTotal.createCell(6).setCellValue(icu_total_beds_total);
				rowTotal.createCell(7).setCellValue(icu_total_beds_vacant);
				rowTotal.createCell(8).setCellValue(total_total_beds_total);
				rowTotal.createCell(9).setCellValue(total_total_beds_vacant);

				rowCounter++;
				XSSFRow rowAdults = sheet.createRow(rowCounter);
				rowAdults.createCell(1).setCellValue("Adults");
				rowAdults.createCell(2).setCellValue(normal_adult_beds_total);
				rowAdults.createCell(3).setCellValue(normal_adult_beds_vacant);
				rowAdults.createCell(4).setCellValue(o2_adult_beds_total);
				rowAdults.createCell(5).setCellValue(o2_adult_beds_vacant);
				rowAdults.createCell(6).setCellValue(icu_adult_beds_total);
				rowAdults.createCell(7).setCellValue(icu_adult_beds_vacant);
				rowAdults.createCell(8).setCellValue(total_adult_beds_total);
				rowAdults.createCell(9).setCellValue(total_adult_beds_vacant);

				rowCounter++;
				XSSFRow rowPaediatrics = sheet.createRow(rowCounter);
				rowPaediatrics.createCell(1).setCellValue("Paediatrics");
				rowPaediatrics.createCell(2).setCellValue(normal_paediatric_beds_total);
				rowPaediatrics.createCell(3).setCellValue(normal_paediatric_beds_vacant);
				rowPaediatrics.createCell(4).setCellValue(o2_paediatric_beds_total);
				rowPaediatrics.createCell(5).setCellValue(o2_paediatric_beds_vacant);
				rowPaediatrics.createCell(6).setCellValue(icu_paediatric_beds_total);
				rowPaediatrics.createCell(7).setCellValue(icu_paediatric_beds_vacant);
				rowPaediatrics.createCell(8).setCellValue(total_paediatric_beds_total);
				rowPaediatrics.createCell(9).setCellValue(total_paediatric_beds_vacant);
				rowCounter++;

			}

			System.out.println(response.asPrettyString());

		}

		// save as file in desktop
		try {
			FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
			workbook.write(outputStream);
			workbook.close();

			JFrame frame = new JFrame();
			// show message to user on completion
			JOptionPane.showMessageDialog(frame,
					"Covid TN Beds Data downloaded succesfully in the path-\n" + FILE_NAME);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
