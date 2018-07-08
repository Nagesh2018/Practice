package testcases;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.ProjectMethod;
import utils.Reports;

public class GetWeatherWrongCity extends ProjectMethod{

	@BeforeTest
	public void TesData() {
		testNodes= "Get Weather"; 
		testCaseName= "Get Weather Wrong City";
		testDesc="Check if you are getting weather details for  unknown city";
		cityName ="UnknownCity";
	}
	
	@Test
	public void getWeatherUnknownCity() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		response = httpRequest.request(Method.GET, "/"+cityName);
		
		responseBody = response.getBody().asString();
		
		System.out.println(responseBody);
		//System.out.println("Staus Code :" +statusCode + " and Status Line :"+statusLine);
		
/*		String actualStatusLine;
		if(response.getStatusLine().contains("Bad Request")) {
			actualStatusLine = "Bad Request";
		}
		else {
			actualStatusLine = "Nothing";
		}*/
		
		
		//Assert.assertEquals(statusCode, 400);
		checkStatusCode(400);
		//Assert.assertEquals(actualStatusLine, "Bad Request");
		checkStatusLineContains("Bad Request");
		//Assert.assertEquals(statusLine, "HTTP/1.1 400 Bad Request");
		checkStatusLine("HTTP/1.1 400 Bad Request");
		jsonPathObject = response.jsonPath();	
		checkExactJsonPath("FaultId", "FAULT_INTERNAL");
		checkExactJsonPath("fault", "An internal error occured while servicing the request");
	}
}
