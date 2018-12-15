package WepAppHomeTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import UtilitesHomeTest.base;

public class homePage extends base

{
public WebDriver driver;
	

	@FindBy(how = How.ID, using = ("input-254"))
	public WebElement searchField ;
	
	@FindBy(how = How.CSS, using = ("div[class='autocomplete-entity autocomplete-desc']"))
	public WebElement searchTerm ;
	
	@FindBy(how = How.CSS, using = ("div[class='_md-text']"))
	public WebElement searchCountryList ;
	
	@FindBy(how = How.CSS, using = ("span[class=_md-select-icon]"))
	public WebElement searchCountrybutton ;
	
	

	public homePage(WebDriver driver) 

	{
		this.driver = driver;
	}
	
	

}
