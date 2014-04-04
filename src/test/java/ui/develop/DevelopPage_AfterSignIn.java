package ui.develop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ui.BasePage;
import ui.deploy.EULAAgreementPage;
import util.CfgLoader;

public class DevelopPage_AfterSignIn extends BasePage{
	public static String PAGE_URL=CfgLoader.developPageUrl;
	public static String PAGE_TITLE=CfgLoader.developPageTitle;
	
	
	@FindBy(css = ".site.com_content.view-article.no-layout.no-task.itemid-103")// Web element in the page
	private WebElement PAGE_READY_ELEMENT;
	@FindBy(css = ".download-button")
	private WebElement DOWNLOAD_LINK;

	@FindBy(css = ".eula")
	private WebElement LICENSE_AGREE_LINK;
	@FindBy(css=".development-video1")
	private WebElement VIDEO;
	
	
	public void clickDownloadLink(){
		DOWNLOAD_LINK.click();
	}
	public void clickVideo(){
		VIDEO.click();
	}
	public EULAAgreementPage clickLicenseAgreenmentLink(){
		LICENSE_AGREE_LINK.click();
		return BasePage.getPage(EULAAgreementPage.class);
	}
	
	
	@Override
	protected WebElement getPageReadyElement() {
		return PAGE_READY_ELEMENT;
	}
}
