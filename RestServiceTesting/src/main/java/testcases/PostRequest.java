package testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.ProjectMethod;
import utils.Reports;
import java.util.Random;
public class PostRequest extends ProjectMethod {
	@BeforeTest
	public void TesData() {
		testNodes= "Insert Customer"; 
		testCaseName= "Insert New Customer";
		testDesc="Check if you are able to insert new Customer";
	}
	
	@Test
	public void addCustomer() {
		
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();
		
		Random rand = new Random();
		int rand1 = rand.nextInt(1000);
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "SDET"+rand1);
		requestParams.put("LastName", "Tester"+rand1);
		requestParams.put("UserName", "sdetupdated");
		requestParams.put("Password", "sdetpass"+rand1);
		requestParams.put("Email", "test"+rand1 +"@testabc.com");
	
		request.header("Content-Type","application/json");
		
		request.body(requestParams.toJSONString());
		
		response = request.post("/register");
		//response = request.put("/register");
		
	System.out.println(response.getStatusCode());
	System.out.println(response.getStatusLine());
	System.out.println(response.getBody().asString());
	jsonPathObject = response.jsonPath();
	
	//Assert.assertEquals(response.getStatusCode(), 201);
	checkStatusCode(201);
	
	//Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 201 Created");
	checkStatusLine("HTTP/1.1 201 Created");
	//Assert.assertEquals(response.jsonPath().get("SuccessCode"), "OPERATION_SUCCESS");
	
	//Assert.assertEquals(response.jsonPath().get("Message"), "Operation completed successfully");
	checkExactJsonPath("Message","Operation completed successfully");
	
	}
}
