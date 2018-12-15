package UtilitesHomeTest;

import static org.junit.Assert.fail;
import static org.testng.Assert.assertNotEquals;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.LogStatus;

public class commonOps extends base


{
	public static void insertText(WebElement elem, String text, String string) throws ParserConfigurationException, SAXException, IOException

	{
		try
		{
			elem.sendKeys(text);
			System.out.println("Text in " + " " + string + " " + "is inserted");
			test.log(LogStatus.PASS, "Text in " + " " + string + " " + "is inserted");
		}

		catch (Exception e)
		{
			System.out.println("Text in " + " " + string + " " + "is not inserted");
			test.log(LogStatus.FAIL, string + " " + "not exist! + see Screen Shot: " + test.addScreenCapture(takeSS()));
			fail (string + " " + "not exist!");
		}

	}

	public static void clickOrChose(WebElement elem, String string) throws ParserConfigurationException, SAXException, IOException

	{
		try
		{

			elem.click();
			System.out.println(string + " " + "is clicked");
			test.log(LogStatus.PASS, string + " " + "is clicked");
		}

		catch (Exception e)
		{
			System.out.println(string + " " + "not clicked!");
			test.log(LogStatus.FAIL, string + " " + "not clicked! + see Screen Shot: " + test.addScreenCapture(takeSS()));
			fail (string + " " + "not clicked!");
		}
	}



	

	public static void scroll() throws IOException, ParserConfigurationException, SAXException
	{
		try
		{
			((JavascriptExecutor) driver).executeScript("scroll(0, 700);");
			test.log(LogStatus.PASS, "Scroll done");	
		}
		catch (Exception e)
		{

			test.log(LogStatus.FAIL, "Scroll is not done , see Screen Shot: " + e.getMessage() + test.addScreenCapture(takeSS()));
			fail("Scroll is not donet");
		}
	}

	
	
	 public static void assertTextInList(List<WebElement>elements, String text, WebElement elem1, String wrongValue ) throws ParserConfigurationException, SAXException, IOException
	 
	 /*
	 search if in your list tel aviv Exists.
	 if tel aviv exists, please press on tel aviv district and check if you have Related queries.
	 */

	 {

		    
		List<WebElement> list = elements;
		    for (WebElement elem : list) 
		    {
		    	try {
		    	
		    	if (elem.getText().equals(text)) 
		        {
		    		System.out.println("Text  " + text + "     found in the List");
		    		test.log(LogStatus.PASS, "Text  " + text + "     found in the List");
		    		elem.click();
		    		
			    	try
			    	{
			    		String actual = elem1.getText();
			    		assertNotEquals(wrongValue, actual);
			    		System.out.println("Text is OK!");
						test.log(LogStatus.PASS, "Text is OK!");
			    	}
			    	catch (Exception e)
					{
						System.out.println("Text is not OK!" );
						test.log(LogStatus.FAIL, "Text is not OK! + see Screen Shot: "  + test.addScreenCapture(takeSS()));
						fail ("Text is not OK!");
					}
		    		
		    		return;
		    		
		        }
		    	
		    	}
		    	
		    	catch (Exception e)
		    	
		    	{
		    
		    
		    System.out.println("Text  " + text + "    Not found in the List");
		    test.log(LogStatus.FAIL, "Text  " + text + "    Not found in the List" + test.addScreenCapture(takeSS()));
			fail ("Text  " + text + "    Not found in the List");
		}
		    }
	 }

	 
}
