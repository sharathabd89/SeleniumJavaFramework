package com.sgtesting.happypath;
import java.io.IOException;

import org.apache.http.util.TextUtils;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
public class CreateCompanyScenario {
	@Test(dataProvider="empdataprovider")
	public void companyCreation(String firstname,String lastname,String email,String phone,String address,String state,String zipcode ) 
	{
RestAssured.baseURI="https://enigmatic-meadow-39517.herokuapp.com/api/v1/users";
RequestSpecification request=RestAssured.given();
JSONObject json=new JSONObject();
json.put("first_name",firstname);
json.put("last_name",lastname );
json.put("email",email);
json.put("phone_number", phone);
json.put("address",state);
json.put("state", state);
json.put("zipcode",zipcode);
request.header("Content-type","application/json");
request.header("Authorization","aWD2UASQXnQvCTMXApAw");
request.body(json.toJSONString());
Response respond=request.post();
String respondstatement=respond.getBody().asString();
System.out.println(respondstatement);
JsonPath Jpath=respond.jsonPath();
int statuscode=respond.getStatusCode();
Assert.assertEquals(statuscode,201);
}
	@DataProvider(name="empdataprovider")
	public String[][] getEmpdata() throws IOException
	          {
		String path="C:\\Users\\HP\\eclipse-workspace\\ZZ-api-Automation\\DataforApi.xlsx";
		int rownum=DataDrivenTesting.getRowCount(path,"Sheet1");
		int colnum=DataDrivenTesting.getCellCount(path,"Sheet1",1);
		
		String[][] companydata=new String[rownum][colnum];
		{
			for(int i=1;i<=rownum;i++)
			{
				for(int j=0;j<colnum;j++)
				{
					companydata[i-1][j]=DataDrivenTesting.getCellData(path, "Sheet1",i, j);
				}}
				return companydata;
			
		}
	          }}
