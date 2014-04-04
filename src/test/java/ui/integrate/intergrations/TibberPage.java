package ui.integrate.intergrations;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ui.BasePage;
import ui.home.VideoXDialog;
import util.CfgLoader;
import util.DriverUtil;

public class TibberPage extends BasePage{
	public static String PAGE_URL=CfgLoader.intergrateTibberUrl;
	public static String PAGE_TITLE=CfgLoader.intergrateTibberPageTitle;
	
	@FindBy(css = ".site.com_content.view-article.no-layout.no-task.itemid-104")//the web element identifies the page
	private WebElement PAGE_READY_ELEMENT;
	
	@FindBy(css = ".thumbnails li.span img")	
	private WebElement VIDEO_IMG;
	
	@FindBy(css = ".download-button")	
	private WebElement DOWNLOAD_LN;

	public void ClickDownloadLink(){
		DOWNLOAD_LN.click();
	}
	
	
	
	public VideoXDialog ClickVideo()  {
		DriverUtil.wait(ExpectedConditions.visibilityOf(VIDEO_IMG));
		VIDEO_IMG.click();
		return BasePage.getPage(VideoXDialog.class);
	}
	
	
	@Override
	protected WebElement getPageReadyElement() {
		return PAGE_READY_ELEMENT;
	}
	

	
}
