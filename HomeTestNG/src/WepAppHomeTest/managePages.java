package WepAppHomeTest;

import org.openqa.selenium.support.PageFactory;

import UtilitesHomeTest.base;

public class managePages extends base
{
	public static void init()
	 {
		 HP = PageFactory.initElements(driver, WepAppHomeTest.homePage.class);
		 RP = PageFactory.initElements(driver, WepAppHomeTest.resultPage.class);
		 CP = PageFactory.initElements(driver, WepAppHomeTest.cityPage.class);
		 SM = PageFactory.initElements(driver, WepAppHomeTest.sendMail.class);

	 }
}
