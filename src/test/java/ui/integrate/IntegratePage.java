package ui.integrate;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ui.BasePage;
import ui.integrate.intergrations.*;
import util.CfgLoader;
import util.DriverUtil;

public class IntegratePage extends BasePage{
	public String PAGE_URL=CfgLoader.intergratePageUrl;
	public String PAGE_TITLE=CfgLoader.intergratePageTitle;

	@FindBy(css = ".site.com_content.view-featured.no-layout.no-task.itemid-104")		//the web element identifies the page
	private WebElement PAGE_READY_ELEMENT;
	@FindBy(css =".span12.list-horizontal.applications-list.top-integrate li:nth-child(1) div.list-button.clearfix a" )
	private WebElement TIBBR_LM_BTN;
	@FindBy(css =".span12.list-horizontal.applications-list.top-integrate li:nth-child(2) div.list-button.clearfix a" )
	private WebElement SALEFORCE_LM_BTN;
	@FindBy(css =".span12.list-horizontal.applications-list.top-integrate li:nth-child(3) div.list-button.clearfix a" )
	private WebElement SAP_LM_BTN;
	@FindBy(css =".quick-connect .span12.list-horizontal.applications-list li:nth-child(1) div.list-button.clearfix a" )
	private WebElement FOURSQUARE_LM_BTN;
	@FindBy(css =".quick-connect .span12.list-horizontal.applications-list li:nth-child(2) div.list-button.clearfix a" )
	private WebElement EVERNOTE_LM_BTN;
	@FindBy(css =".quick-connect .span12.list-horizontal.applications-list li:nth-child(3) div.list-button.clearfix a" )
	private WebElement DROPBOX_LM_BTN;
	@FindBy(css =".quick-connect .span12.list-horizontal.applications-list li:nth-child(4) div.list-button.clearfix a" )
	private WebElement FACEBOOK_LM_BTN;
	@FindBy(css =".quick-connect .span12.list-horizontal.applications-list li:nth-child(5) div.list-button.clearfix a" )
	private WebElement SATISFACTION_LM_BTN;
	@FindBy(css =".quick-connect .span12.list-horizontal.applications-list li:nth-child(6) div.list-button.clearfix a" )
	private WebElement YAMMER_LM_BTN;
	@FindBy(css =".quick-connect .span12.list-horizontal.applications-list li:nth-child(7) div.list-button.clearfix a" )
	private WebElement MAILCHIMP_LM_BTN;
	@FindBy(css =".quick-connect .span12.list-horizontal.applications-list li:nth-child(8) div.list-button.clearfix a" )
	private WebElement INSTAGRAM_LM_BTN;
	@FindBy(css =".quick-connect .span12.list-horizontal.applications-list li:nth-child(9) div.list-button.clearfix a" )
	private WebElement SQS_LM_BTN;
	@FindBy(css =".quick-connect .span12.list-horizontal.applications-list li:nth-child(10) div.list-button.clearfix a" )
	private WebElement FLICKR_LM_BTN;
	@FindBy(css =".quick-connect .span12.list-horizontal.applications-list li:nth-child(11) div.list-button.clearfix a" )
	private WebElement JIGSAW_LM_BTN;
	
	public TibberPage clickTibberLMBtn(){
		TIBBR_LM_BTN.click();
		return BasePage.getPage(TibberPage.class);
		
	}
	public SalesforcePage clickSaleforceLMBtn(){
		SALEFORCE_LM_BTN.click();
		return BasePage.getPage(SalesforcePage.class);
		
	}
	public SapPage clickSapLMBtn(){
		SAP_LM_BTN.click();
		return BasePage.getPage(SapPage.class);
		
	}
	public FoursquarePage clickFoursquareLMBtn(){
		FOURSQUARE_LM_BTN.click();
		return BasePage.getPage(FoursquarePage.class);
		
	}
	public EvernotePage clickEvernoteLMBtn(){
		EVERNOTE_LM_BTN.click();
		return BasePage.getPage(EvernotePage.class);
		
	}
	public DropboxPage clickDropboxLMBtn(){
		DROPBOX_LM_BTN.click();
		return BasePage.getPage(DropboxPage.class);
		
	}
	public FacebookPage clickFacebookLMBtn(){
		FACEBOOK_LM_BTN.click();
		return BasePage.getPage(FacebookPage.class);
		
	}
	public SatisfactionPage clickSatisfactionLMBtn(){
		SATISFACTION_LM_BTN.click();
		return BasePage.getPage(SatisfactionPage.class);
		
	}
	public YammerPage clickYammerLMBtn(){
		YAMMER_LM_BTN.click();
		return BasePage.getPage(YammerPage.class);
		
	}
	public MailchimpPage clickMailchimpLMBtn(){
		MAILCHIMP_LM_BTN.click();
		return BasePage.getPage(MailchimpPage.class);
		
	}
	public InstagramPage clickInstagramLMBtn(){
		INSTAGRAM_LM_BTN.click();
		return BasePage.getPage(InstagramPage.class);
		
	}
	public SQSPage clickSQSLMBtn(){
		SQS_LM_BTN.click();
		return BasePage.getPage(SQSPage.class);
		
	}
	public FlickrPage clickFlickrLMBtn(){
		FLICKR_LM_BTN.click();
		return BasePage.getPage(FlickrPage.class);
		
	}
	public JigsawPage clickJigsawLMBtn(){
		JIGSAW_LM_BTN.click();
		return BasePage.getPage(JigsawPage.class);
	}
	
	protected WebElement getPageReadyElement() {
		return PAGE_READY_ELEMENT;
	}
	


	public IntegratePage(){
		super();
	}
	
}
