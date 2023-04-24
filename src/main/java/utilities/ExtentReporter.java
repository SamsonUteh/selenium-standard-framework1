package utilities;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
	WebDriver driver;
	static ExtentReports extentReport;
	
	public static ExtentReports getExtentReport() {
		String reportPath = System.getProperty("user.dir") + "\\reports\\extentReport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
		
		reporter.config().setReportName("Tutorials Ninja Report");
		reporter.config().setDocumentTitle("Report Title");
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(reporter);
		extentReport.setSystemInfo("Operating System", "Windows 11");
		extentReport.setSystemInfo("Tested By", "Samson Uteh");
		
		return extentReport;
	}

}
