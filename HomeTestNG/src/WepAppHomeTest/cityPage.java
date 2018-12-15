package WepAppHomeTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import UtilitesHomeTest.base;

public class cityPage extends base

{
	
		public WebDriver driver;
		

		
		
		@FindBy(how = How.CSS, using = ("p[class='widget-error-title']"))
		public WebElement relatedQueries ;
		
		
		

		public cityPage(WebDriver driver) 

		{
			this.driver = driver;
		}
		
}
