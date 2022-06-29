package com.sgtesting.happypath;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class AllHttpMethods 
{
	@Test
	public  void loginScenario()
	{
		RestAssured.baseURI="https://enigmatic-meadow-39517.herokuapp.com/api/v1/students/sign_in";
		RequestSpecification http_request=RestAssured.given();
		JSONObject object=new JSONObject();
		object.put("email","bna3374@gmail.com");
		object.put("password","india1");
		String strjsonrequest=object.toJSONString();
		System.out.println(strjsonrequest);
		http_request.header("Content-Type", "application/json");
		http_request.body(strjsonrequest);
		
		Response response=http_request.post();
		String responsebody=response.asString();
		System.out.println(responsebody);
		
		JsonPath jpath=response.jsonPath();
		String authToken=jpath.getString("auth_token");
		System.out.println(authToken);
		
	}

}
