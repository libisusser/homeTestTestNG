package UtilitesHomeTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import WepAppHomeTest.sendMail;

public class base 


{
	public static WebDriver driver;
	public static Screen screen;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());
	public static String ReportFullPathName;
	
 

	public static WepAppHomeTest.homePage HP;
	public static WepAppHomeTest.resultPage RP;
	public static WepAppHomeTest.cityPage CP;
	public static WepAppHomeTest.sendMail SM;







	public static String getData (String nodeName) throws ParserConfigurationException, SAXException, IOException
	{
		File fXmlFile = new File("./configHomeTest.xml");



		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile); 
		doc.getDocumentElement().normalize();
		return doc.getElementsByTagName(nodeName).item(0).getTextContent();
	}

	public static void initBrowser(String browserType) throws ParserConfigurationException, SAXException, IOException
	{
		switch (browserType.toLowerCase())
		{
		case "firfox":
			driver = initFFDriver();
			break;
		case "chrome":
			driver = initChromeDriver();
			break;

		}

		
	}

	public static WebDriver initFFDriver() throws ParserConfigurationException, SAXException, IOException
	{
		System.setProperty ("webdriver.gecko.driver" , getData ("FFDriverPath"));
		WebDriver driverff = new FirefoxDriver();
		return driverff;

	}


	public static WebDriver initChromeDriver() throws ParserConfigurationException, SAXException, IOException
	{
		System.setProperty ("webdriver.chrome.driver" , getData ("ChromeDriverPath"));
		WebDriver driver = new ChromeDriver();
		return driver;

	}


	public static void InstanceReport(String currentTime) throws ParserConfigurationException, SAXException, IOException
	{
		ReportFullPathName = getData("ReportFilePath")+ getData("ReportFileName") + currentTime + ".html";
		extent = new ExtentReports(getData("ReportFilePath")+ getData("ReportFileName") + currentTime + ".html",false);


	}

	public static void initReportTest(String testName, String testDescription)

	{
		test = extent.startTest(testName,testDescription);
	}

	public static void finalizeReportTest()
	{
		extent.endTest(test);
	}

	public static void finalizeReport()
	{
		extent.flush();
		extent.close();
	}

	public static String takeSS() throws ParserConfigurationException, SAXException, IOException

	{

		String SSpath = getData("ReportFilePath") + "screenshot_" + getRandomNumber() + ".png";
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(SSpath));
		return SSpath;

	}

	public static int getRandomNumber()
	{
		Random rand = new Random();
		return rand.nextInt(999999) + 1000;
	}

	
	

	@BeforeClass

	public static void  startsSession() throws ParserConfigurationException, SAXException, IOException

	{

		InstanceReport(timeStamp);
		WepAppHomeTest.managePages.init();
		

	}

	@AfterClass
	public static void  CloseSession()
	{
		finalizeReport();
		driver.quit();
		sendMail.sendingMail("Home test report", ReportFullPathName);
	}

	@AfterTest


	public void doAfterTest()
	{

		finalizeReportTest();

	}
	
		


}

