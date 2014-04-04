package ui.deploy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ui.BasePage;
import util.CfgLoader;

public class OnPremisesEnvironmentPage_AfterSignIn extends BasePage {
	public String PAGE_URL=CfgLoader.environmentDetailPageUrl;
	public String PAGE_TITLE=CfgLoader.environmentDetailPageTitle;
	
	
	@FindBy(css = ".site.com_content.view-article.no-layout.no-task.itemid-116")// Web element in the page
	private WebElement PAGE_READY_ELEMENT;
	@FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/div/article/div/div/div/a[1]")
	private WebElement DOWNLOAD_LINK_A;
	@FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/div/article/div/div/div/a[2]")
	private WebElement DOWNLOAD_LINK_B;
	@FindBy(css = ".download-eula-box a")
	private WebElement LICENSE_AGREE_LINK;
	
	@Override
	protected WebElement getPageReadyElement() {
		
		return PAGE_READY_ELEMENT;
	}
	public void clickDownloadLinkA(){
		DOWNLOAD_LINK_A.click();
		
	}
	
	public void clickDownloadLinkB(){
		DOWNLOAD_LINK_B.click();
	}
	
	public void clickLicenseAgreeLink(){
		LICENSE_AGREE_LINK.click();
	}
}
