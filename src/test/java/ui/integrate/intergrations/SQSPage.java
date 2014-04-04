package ui.integrate.intergrations;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ui.BasePage;
import util.CfgLoader;

public class SQSPage extends BasePage {
	public static String PAGE_URL=CfgLoader.intergrateSqsUrl;
	public static String PAGE_TITLE=CfgLoader.intergrateSqsPageTitle;
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
