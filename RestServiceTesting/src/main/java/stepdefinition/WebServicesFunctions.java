package stepdefinition;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import utils.CommonMethods;

public class WebServicesFunctions extends CommonMethods{

	public void setBaseUri(String baseUri) {
		RestAssured.baseURI = baseUri;
		 httpRequest = RestAssured.given();
	}
	public void httpGet(String param1) {
		response = httpRequest.request(Method.GET, "/"+param1);
		responseBody = response.getBody().asString();
		jsonPathObject = response.jsonPath();
	}
	
	public void checkStatus(int code) {
		checkStatusCode(code);
	}
	
	public void checkStatusLine(String statusLine) {
		checkStatusLine(statusLine);
	}
	
	public void checkContentType(String contentType) {
		checkJsonContentType(contentType);
	}
	public void checkServer(String serverName) {
		checkServerDetails(serverName);
	}
	public void checkEncode(String encoding) {
		checkEncoding(encoding);
	}
	public void checkExactJson(String node, String val) {
		checkExactJsonPath(node, val);
	}
	
	public void checkJsonPath1(String node) {
		checkJsonPath(node);
	}
	
	
	
}
