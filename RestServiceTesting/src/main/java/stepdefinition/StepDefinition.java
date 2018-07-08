package stepdefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepDefinition extends WebServicesFunctions{

	@Given("I set baseuri (.*)")
	public void i_set_baseuri(String baseUri) {
		setBaseUri(baseUri);

	}

	@And("provide the required data (.*) and submit the WebService Request")
	public void provideData_and_SubmitRequest(String data1) {
		httpGet(data1);

	}


	@Then("verify responsecode (.*)")
	public void verify_responsecode(String code) {
		int code1 = Integer.parseInt(code);
		checkStatus(code1);

	}

	@Then("verify responseStatusLine (.*)")
	public void verify_responseStatusLine_HTTP_OK(String statusline) {
		checkStatusLine(statusline);

	}

	@Then("verify ContentType (.*)")
	public void verify_ContentType_application_json(String contentType) {
		checkJsonContentType(contentType);

	}


	
}
