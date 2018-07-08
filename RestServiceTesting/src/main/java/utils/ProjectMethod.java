package utils;

import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class ProjectMethod extends CommonMethods {


@BeforeSuite
public void startReport1() {
	startReport();
}
	
@BeforeClass
public void startTestModule() {
	 startSuite(testCaseName, testDesc);
}

@BeforeMethod
public void startTestCase() throws IOException {
	test = startTest(testNodes);

}

@AfterMethod
public void afterMethod() {
}

@AfterSuite
public void closeReport() throws IOException {
	endReport();
}

	
}
