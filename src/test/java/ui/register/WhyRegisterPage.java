package ui.register;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ui.BasePage;
import ui.home.VideoXDialog;
import util.CfgLoader;
import util.DriverUtil;
/**
 * This is the page object of "Why Register" page
 * 
 * @author XiaoXue_Chen
 *
 */
public class WhyRegisterPage extends BasePage {
	public static String PAGE_URL=CfgLoader.whyRegPageUrl;
	public static String PAGE_TITLE=CfgLoader.whyRegPageTitle;
	
	@FindBy(css = ".site.com_content.view-article.no-layout.no-task.itemid-117") //Web element in the page 
	private WebElement PAGE_READY_ELEMENT;
	@FindBy(css = ".span8.pull-left :nth-child(1).main-content-header")		//the title of the text on this page.
	private WebElement TITLE_P;
	@FindBy(css = ".why-register-video1")		//the image of the video on this page.
	private WebElement WHY_REG_IMG;

	
	public VideoXDialog OpenWhyRegVideo() {
		DriverUtil.wait(ExpectedConditions.visibilityOf(WHY_REG_IMG));
		WHY_REG_IMG.click();
		return BasePage.getPage(VideoXDialog.class);
	}

	protected WebElement getPageReadyElement() {
		return this.PAGE_READY_ELEMENT;
	}
	
	public WhyRegisterPage() {
		super();
	}

}