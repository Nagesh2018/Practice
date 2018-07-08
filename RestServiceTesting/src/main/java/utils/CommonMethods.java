package utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CommonMethods extends Reports{
	public Response response;
	public RequestSpecification httpRequest;
	public String responseBody;
	public JsonPath jsonPathObject;

	public void checkStatusCode(int statusCode) {
		if ( response.getStatusCode()==statusCode) {
			reportStep("Check Status Code in Response "+ response.getStatusCode(),"Pass");
		}
		else {
			reportStep("Check Status Code in Response "+ response.getStatusCode(),"fail");
		}
	}

	public void checkStatusLine(String statusLine) {
		if (response.getStatusLine().equalsIgnoreCase(statusLine)) {
			reportStep("Check Status Line in Response "+response.getStatusLine(),"Pass");
		}
		else {
			reportStep("Check Status Line in Response "+response.getStatusLine(),"fail");
		}
	}

	public void checkStatusLineContains(String statusLine) {
		if (response.getStatusLine().contains(statusLine)) {
			reportStep("Check Status Line in Response contains ","Pass");
		}
		else {
			reportStep("Check Status Line in Response contains ","fail");
		}
	}

	public void checkJsonContentType(String contentType) {
		if (response.getHeader("Content-Type").equalsIgnoreCase(contentType)) {
			reportStep("Check Content Type in Response","Pass");
		}
		else {
			reportStep("Check Content Type in Response","fail");
		}
	}

	public void checkServerDetails(String server) {
		if ( response.header("Server").equalsIgnoreCase(server)) {
			reportStep("Check Server Details of the Response","Pass");
		}
		else {
			reportStep("Check Server Details of the Response","fail");
		}
	}

	public void checkEncoding(String encodingType) {
		if ( response.getHeader("Content-Encoding").equalsIgnoreCase(encodingType)) {
			reportStep("Check Encoding Type of the Response","Pass");
		}
		else {
			reportStep("Check Encoding Type of the Response","fail");
		}
	}

	public void checkResponseBodyContains(String checkString) {
		if (responseBody.toLowerCase().contains(checkString)) {
			reportStep("Check Response body Contains "+ checkString,"Pass");
		}
		else {
			reportStep("Check Response body Contains "+ checkString,"fail");
		}
	}

	public void checkJsonPath(String jsonNode) {
		try {
			if (jsonPathObject.getString(jsonNode).length()>0) {
				reportStep("Check Json Path "+jsonNode + " contains value " +jsonPathObject.get(jsonNode), "Pass");
			}
			else {
				reportStep("Check Json Path "+jsonNode + " contains value " +jsonPathObject.get(jsonNode), "Fail");
			}
		} catch (Exception e) {
			reportStep("Check Json Path "+jsonNode, "Fail");
		}
	}

	public void checkExactJsonPath(String jsonNode, String jsonValue) {
			try {
				if(jsonPathObject.getString(jsonNode).equals(jsonValue)) {

					reportStep("Check Json Path "+jsonNode + " contains value " +jsonPathObject.get(jsonNode), "Pass");
				}

				else {
					reportStep("Check Json Path "+jsonNode + " contains value " +jsonPathObject.get(jsonNode), "Fail");
				}
			} catch (Exception e) {
				reportStep("Check Json Path "+jsonNode, "Fail");
			}
	}
}
