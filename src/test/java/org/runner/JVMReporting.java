package org.runner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JVMReporting {
	
	public static void generateReport(String jsonfile) {
		// TODO Auto-generated method stub
		
		File f = new File("D:\\Pradeep\\ECLIPS\\eclipse\\Task\\src\\test\\resources\\Reports");
		Configuration configuration = new Configuration(f, "Amazon app");
		configuration.addClassifications("OS", "Window");
		configuration.addClassifications("Browser", "Chrome");
		
		List<String> jsonfiles = new ArrayList<String>();
		jsonfiles.add(jsonfile);
		
		
		ReportBuilder reportBuilder = new ReportBuilder(jsonfiles, configuration);
		reportBuilder.generateReports();
		System.out.println();
	}

}
