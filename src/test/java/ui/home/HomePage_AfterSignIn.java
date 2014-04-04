package ui.home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ui.BasePage;
import ui.account.AccountDialog;
import ui.deploy.DeployPage_AfterSignIn;
import ui.develop.DevelopPage_AfterSignIn;
import ui.integrate.IntegratePage;
import ui.learn.LearnPage;
import ui.price.PricePage;
import ui.register.RegisterDialog;
import ui.signIn.SignInDialog;
import util.CfgLoader;
import util.DriverUtil;

/**
 * 
 * 
 */

public class HomePage_AfterSignIn extends BasePage {

	public String PAGE_URL=CfgLoader.homePageUrl;
	public String PAGE_TITLE=CfgLoader.homePageTitle;
	@FindBy(css = ".site.com_content.view-article.no-layout.no-task.itemid-101.home-welcome")
	// Web element in the page
	private WebElement PAGE_READY_ELEMENT;
	
	@FindBy(css = ".txt-bold.username")
	// The user welcome message shows after user logined.
	private WebElement USER_WELCOME_MSG;
	
	@FindBy(css = ".caret")
	private WebElement ACCOUNT_BTN;
	
	@FindBy(css = ".item-103 a") //btn register-button
	private WebElement DEVELOP_BTN;

	@FindBy(css = ".item-102 a")
	private WebElement DEPLOY_BTN;
	
	@FindBy(css = ".pull-right.subscribe-button.upgrade-subscribe-button")
	private WebElement SUBSCRIB_BTN;
	
	@FindBy(css=".pull-right.subscribe-button.upgrade-subscribe-button .button-title") //Subcribe
	private WebElement SUBSCRIB_TITLE;
	
	@FindBy(css=".pull-right.subscribe-button.upgrade-subscribe-button .remain-time") //Evaluation period expired
	private WebElement SUBSCRIB_REMAIN_TEXT; 
	
	
	@FindBy(css = ".welcome-integrate-container")
	private WebElement INTEGRATE_IMG;
	@FindBy(css = ".welcome-develop-container")
	private WebElement DEVELOP_IMG;
	@FindBy(css = ".welcome-deploy-container")
	private WebElement DEPLOY_IMG;
	
	
	
	
	public HomePage_AfterSignIn() {
		super();

	}

	protected WebElement getPageReadyElement() {
		return this.PAGE_READY_ELEMENT;
	}	

	/**
	 * get the user welcome message at the upper-right corner of home page.
	 * @return string msg
	 */
	public String getUserWelcomeMsg() {
		DriverUtil.wait(ExpectedConditions.visibilityOf(USER_WELCOME_MSG));
		return USER_WELCOME_MSG.getText();
	}
	
//	public SubscribeDialog clickSubscribeBTN(){
//		SUBSCRIB_BTN.click();
//		return BasePage.getPage(SubscribeDialog.class);
//	}
	
	public AccountDialog clickAccountBTN(){
		ACCOUNT_BTN.click();
		return BasePage.getPage(AccountDialog.class);
	}
	 
	public IntegratePage clickIntegrateImg(){
		INTEGRATE_IMG.click();
		return BasePage.getPage(IntegratePage.class);
	}
	
	public DevelopPage_AfterSignIn clickDevelopImg(){
		DEVELOP_IMG.click();
		return BasePage.getPage(DevelopPage_AfterSignIn.class);
	}
	
	public DeployPage_AfterSignIn clickDeployImg(){
		DEPLOY_IMG.click();
		return BasePage.getPage(DeployPage_AfterSignIn.class);
	}
	
	public DevelopPage_AfterSignIn clickDevelopBtn(){
		DEVELOP_BTN.click();
		return BasePage.getPage(DevelopPage_AfterSignIn.class);
	}
	
	public DeployPage_AfterSignIn clickDeployBtn(){
		DEPLOY_BTN.click();
		return BasePage.getPage(DeployPage_AfterSignIn.class);
	}
	
}
