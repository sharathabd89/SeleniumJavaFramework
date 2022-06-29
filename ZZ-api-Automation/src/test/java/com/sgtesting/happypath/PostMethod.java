package com.sgtesting.happypath;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class PostMethod {
	@Test
	public void postMethod()
	{
		RestAssured.baseURI="https://enigmatic-meadow-39517.herokuapp.com/api/v1/users";
		RequestSpecification request=RestAssured.given();
		JSONObject json=new JSONObject();
		json.put("email", "demo@gmail.com");
		json.put("first_name", "demo");
		json.put("last_name", "User1");
		json.put("phone_number", "9080701234");
		json.put("address", "Kamskshi Palya");
		json.put("state", "Karnataka");
		json.put("zipcode", "567123");
		request.header("Content-type","application/json");
		request.header("Authorization","aWD2UASQXnQvCTMXApAw");
		request.body(json.toJSONString());
		Response respond=request.post();
		String respondstatement=respond.getBody().asString();
		System.out.println(respondstatement);
		Assert.assertEquals(respondstatement.contains("demo"),true);
		int statuscode=respond.getStatusCode();
		System.out.println(statuscode);
		Assert.assertEquals(statuscode,201);
		Headers heads=respond.getHeaders();
	System.out.println(heads);
		
	}

}
