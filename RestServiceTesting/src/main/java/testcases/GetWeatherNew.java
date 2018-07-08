package testcases;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.ProjectMethod;
import utils.Reports;

public class GetWeatherNew extends ProjectMethod{

	@BeforeTest
	public void TesData() {
		testNodes= "Weather for a Valid City"; 
		testCaseName= "Get Weather";
		testDesc="Get Weather for a City";
		cityName ="Bangalore";
	}
	
	@Test
	public void getWeatherCity() {

		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		RequestSpecification httpRequest = RestAssured.given();

		//Response response = httpRequest.request(Method.GET, "/Bangalore");
		response = httpRequest.request(Method.GET, "/"+cityName);

		
		//String responseBody = response.getBody().asString();
		responseBody = response.getBody().asString();

/*		int statusCode = response.getStatusCode();
		String statusLine = response.getStatusLine();*/

		System.out.println(responseBody);

		/*		System.out.println(response.header("Content-Type"));
		System.out.println(response.header("Server"));
		System.out.println(response.header("Content-Encoding"));*/

		/*		System.out.println(response.getHeader("Content-Type"));
		System.out.println(response.getHeader("Server"));
		System.out.println(response.getHeader("Content-Encoding"));*/

		
		checkStatusCode(200);
		//Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		checkStatusLine("HTTP/1.1 200 OK");


		//Assert.assertEquals(contentType, "application/json");
		checkJsonContentType("application/json");
		//Assert.assertEquals(server, "nginx/1.12.2");
		checkServerDetails("nginx/1.12.2");
		//Assert.assertEquals(encoding, "gzip");
		checkEncoding("gzip");

		// VERIFY BODY

		//Assert.assertEquals(responseBody.toLowerCase().contains("bangalore"), true);
	

		//JsonPath jsonPathObject = response.jsonPath();
		
		jsonPathObject = response.jsonPath();
		 
		//String city = jsonPathObject.get("City");
		

		//Assert.assertEquals(city, "Bangalore", "Correct City Name in Response");
		checkExactJsonPath("City", cityName);
		//System.out.println("Temp in Response "+jsonPathObject.get("Temperature"));
		checkJsonPath("Temperature");
		//System.out.println("Humidity in Response "+jsonPathObject.get("Humidity"));
		checkJsonPath("Humidity");
		//System.out.println("WeatherDescription in Response "+jsonPathObject.get("WeatherDescription"));
		checkJsonPath("WeatherDescription");
		//System.out.println("WindSpeed in Response "+jsonPathObject.get("WindSpeed"));
		checkJsonPath("WindSpeed");
		
	}
}
