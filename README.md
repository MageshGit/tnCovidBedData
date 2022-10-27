# **tnCovidBedData**  </br>
this project will be useful to download the available bed details of hospitals in TN as an excel file </br>
Official site - https://tncovidbeds.tnega.org/

## **Tech Stack:**  </br> 
Programming language: Java v8 </br>
Json marshal library: Apache Juneau  </br>
Excel utility: Apache Poi  </br>

## **Dependencies**
Make sure your system has Java installed.   </br>
This utility works with Java version higher/equal to 8  </br>

## **Steps**
1. Download the jar file   </br>
2. Open command prompt/power shell in the location where jar is located  </br>
command to execute **java -jar tnBedsCovidToExcel.jar**  </br>
--2.1. if the above command throws error, try with   </br>
**java -jar tnBedsCovidToExcel.jar com.tn.covid.data.impl.ExportData**  </br>
3. Type or Paste the path where you wish to download the excel file and hit enter
4. You will be notified once the data is rendered in excel via a popup  </br>  </br>
