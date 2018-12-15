package TestCasesHomeTest;
import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import UtilitesHomeTest.base;
import UtilitesHomeTest.commonOps;

public class Test1 extends base


{

	public static commonOps comOps = new commonOps();

	@Parameters("BrowserName")
	
	@BeforeClass (alwaysRun=true)
	public static void openBrowser( String BrowserName) throws ParserConfigurationException, SAXException, IOException
	{

		if ( BrowserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty ("webdriver.chrome.driver" , getData ("ChromeDriverPath"));
			WebDriver driver = new ChromeDriver();
			String URL = getData("URL");
			driver.get(URL);
			driver.manage().window().setSize(new Dimension(1366, 768));
			
			HP = PageFactory.initElements(driver, WepAppHomeTest.homePage.class);
			RP = PageFactory.initElements(driver, WepAppHomeTest.resultPage.class);
			CP = PageFactory.initElements(driver, WepAppHomeTest.cityPage.class);
			SM = PageFactory.initElements(driver, WepAppHomeTest.sendMail.class);
		}
			
			else if (BrowserName.equalsIgnoreCase("firefox"))
			{
				System.setProperty ("webdriver.gecko.driver" , getData ("FFDriverPath"));
				WebDriver driverff = new FirefoxDriver();
				String URL = getData("URL");
				driver.get(URL);
				driver.manage().window().setSize(new Dimension(1366, 768));
				
				HP = PageFactory.initElements(driver, WepAppHomeTest.homePage.class);
				RP = PageFactory.initElements(driver, WepAppHomeTest.resultPage.class);
				CP = PageFactory.initElements(driver, WepAppHomeTest.cityPage.class);
				SM = PageFactory.initElements(driver, WepAppHomeTest.sendMail.class);
			}
		

		
	}
	
	
	
	@Test 
	public void test01_homeTestFlow() throws InterruptedException, AWTException, ParserConfigurationException, SAXException, IOException

	{
	
		initReportTest("test01", "homeTestFlow");
		commonOps.clickOrChose(HP.searchField, "searchField");
		commonOps.insertText(HP.searchField, "selenuim", "searchField");
		commonOps.clickOrChose(HP.searchTerm, "searchTerm");
		commonOps.clickOrChose(RP.searchCountry, "searchCountry");
		commonOps.insertText(RP.searchCountryText, "Israel", "searchCountryText");
		commonOps.clickOrChose(RP.searchTermCountry, "searchTermCountry");
		commonOps.scroll(); //for the screen shot for the report
		commonOps.assertTextInList(RP.subregionsList, "Tel Aviv", CP.relatedQueries, "Hmm, your search doesn't have enough data to show here.");
	}
}
