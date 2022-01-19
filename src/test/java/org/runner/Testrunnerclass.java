package org.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"src/test/resources"},glue = {"org.step"}, monochrome = true, plugin= {"pretty","json:src/test/resources/Reports/output.json"},dryRun= false)
public class Testrunnerclass {

	@AfterClass
	public static void jvmReport() {
		// TODO Auto-generated method stub
		JVMReporting.generateReport("D:\\Pradeep\\ECLIPS\\eclipse\\Task\\src\\test\\resources\\Reports\\output.json");
	}
}
