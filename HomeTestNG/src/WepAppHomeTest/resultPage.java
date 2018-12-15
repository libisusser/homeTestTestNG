package WepAppHomeTest;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import UtilitesHomeTest.base;

public class resultPage extends base
{
public WebDriver driver;
	

	@FindBy(how = How.ID, using = ("input-9"))
	public WebElement searchCountryText ;
	
	
	
	@FindBy(how = How.CSS, using = ("div[class='hierarchy-select ng-pristine ng-valid']"))
	public WebElement searchCountry ;
	
	@FindBy(how = How.XPATH, using = ("//*[@id='ul-9']/li/md-autocomplete-parent-scope/div/div/span/span"))
	public WebElement searchTermCountry ;
	
	@FindBy(xpath = "//span[@ng-bind='bidiText']")
	public List<WebElement> subregionsList;
	
	@FindBy(how = How.CSS, using = ("div[class='fe-atoms-generic-title']"))
	public WebElement relatedQqueries ;
	
	
	
	
	
	


	public resultPage(WebDriver driver) 

	{
		this.driver = driver;
	}
	
	
}
