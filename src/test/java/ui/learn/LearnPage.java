package ui.learn;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ui.BasePage;
import util.CfgLoader;
import util.DriverUtil;

public class LearnPage extends BasePage{
	public static String PAGE_URL=CfgLoader.learnPageUrl;
	public static String PAGE_TITLE= CfgLoader.learnPageTitle;
	@FindBy(css = "frameset[cols='300,*']")		//the web element identifies the page
	private WebElement PAGE_READY_ELEMENT;
//	private String CURRENT_WINDOW=DriverUtil.getDriver().getWindowHandle();
	@Override
	protected WebElement getPageReadyElement() {
		return PAGE_READY_ELEMENT;
	}
	

}
