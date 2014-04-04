package ui.integrate.intergrations;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ui.BasePage;
import ui.home.VideoXDialog;
import util.CfgLoader;
import util.DriverUtil;

public class YammerPage extends BasePage{
	public static String PAGE_URL=CfgLoader.intergrateYammerUrl;
	public static String PAGE_TITLE=CfgLoader.intergrateYammerPageTitle;
	
	
	@FindBy(css = ".site.com_content.view-article.no-layout.no-task.itemid-104")//the web element identifies the page
	private WebElement PAGE_READY_ELEMENT;
	@FindBy(css = ".download-button")	
	private WebElement DOWNLOAD_LN;

	public void ClickDownloadLink(){
		DOWNLOAD_LN.click();
	}
	
	@Override
	protected WebElement getPageReadyElement() {
		return PAGE_READY_ELEMENT;
	}
	
}
