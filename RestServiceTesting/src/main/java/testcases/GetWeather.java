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

public class GetWeather extends ProjectMethod{

	@BeforeTest
	public void TesData() {
		testNodes= "Weather"; 
		testCaseName= "Get Weather";
		testDesc="Get Weather for a City";
	}
	
	@Test
	public void getWeatherCity() {

		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		RequestSpecification httpRequest = RestAssured.given();

		//Response response = httpRequest.request(Method.GET, "/Bangalore");
		response = httpRequest.request(Method.GET, "/Bangalore");

		//String responseBody = response.getBody().asString();
		responseBody = response.getBody().asString();

		int statusCode = response.getStatusCode();
		String statusLine = response.getStatusLine();

		System.out.println(responseBody);

		/*		System.out.println(response.header("Content-Type"));
		System.out.println(response.header("Server"));
		System.out.println(response.header("Content-Encoding"));*/

		/*		System.out.println(response.getHeader("Content-Type"));
		System.out.println(response.getHeader("Server"));
		System.out.println(response.getHeader("Content-Encoding"));*/

		
		
		Assert.assertEquals(statusCode, 200);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

		//VERIFY HEADERS

		//Headers headers = response.getHeaders();

		/*		for(Header each:headers) {
			System.out.println("Header Name is "+each.getName() + " and Value is : "+each.getValue());
		}*/


		String contentType = response.getHeader("Content-Type");
		String server = response.header("Server");
		String encoding = response.getHeader("Content-Encoding");

		Assert.assertEquals(contentType, "application/json");
		Assert.assertEquals(server, "nginx/1.12.2");
		Assert.assertEquals(encoding, "gzip");

		// VERIFY BODY

		Assert.assertEquals(responseBody.toLowerCase().contains("bangalore"), true);

		//JsonPath jsonPathObject = response.jsonPath();
		
		 jsonPathObject = response.jsonPath();
		 
		String city = jsonPathObject.get("City");
		

		Assert.assertEquals(city, "Bangalore", "Correct City Name in Response");
		
		System.out.println("Temp in Response "+jsonPathObject.get("Temperature"));
		System.out.println("Humidity in Response "+jsonPathObject.get("Humidity"));
		System.out.println("WeatherDescription in Response "+jsonPathObject.get("WeatherDescription"));
		System.out.println("WindSpeed in Response "+jsonPathObject.get("WindSpeed"));
		
		
	}
}
