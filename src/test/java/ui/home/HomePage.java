package ui.home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ui.BasePage;
import ui.contact.ContactPage;
import ui.integrate.IntegratePage;
import ui.learn.LearnPage;
import ui.price.PricePage;
import ui.register.RegisterDialog;
import ui.signIn.SignInDialog;
import util.CfgLoader;
import util.DriverUtil;

/**
 * This is the home page object It contains the web elements need to be use in
 * the later tests and the methods based on those elements.
 * 
 * @author XiaoXue_Chen
 * 
 */

public class HomePage extends BasePage {

	public  String PAGE_URL=CfgLoader.homePageUrl;
	public String PAGE_TITLE=CfgLoader.homePageTitle;
	@FindBy(css = ".site.com_content.view-article.no-layout.no-task.itemid-101.home-welcome")
	// Web element in the page
	
	private WebElement PAGE_READY_ELEMENT;
	@FindBy(css = ".txt-bold.username")
	// The user welcome message shows after user logined.
	private WebElement USER_WELCOME_MSG;

	@FindBy(css = "#top .btn.login-btn")
	// Sign in link at the upper right of the page
	private WebElement SIGN_IN_LINK;
	@FindBy(css = ".btn.register-button") //btn register-button
	// register button in the senter of the page
	private WebElement REGISTER_BTN;
	@FindBy(css = ".btn.contact-link.txt-bold")
	// Contact link at the upper right of the page
	private WebElement CONTACT_BTN;
	@FindBy(css = "#footer .pull-left")
	// CopyRight information at the bottom of the page
	private WebElement COPYRIGHT_TXT;
	@FindBy(css = ".video1 .btn-play")
	// key feature video img at the left middle of the page
	private WebElement VIDEO1_BTN;
	@FindBy(css = ".video2 .btn-play")
	// end to end video img at the center of the page
	private WebElement VIDEO2_BTN;
	@FindBy(css = ".video3 .btn-play")
	// why cloud bus video img at the right middle of the page
	private WebElement VIDEO3_BTN;
	
	@FindBy(css =".slidesjs-pagination-item a[data-slidesjs-item=\"1\"]")// the point button under the banner image
	private WebElement POINT_BTN1;
	@FindBy(xpath="//*[@class='slidesjs-slide']/descendant::img[1]")// banner image 
	private WebElement BANNER_IMG2;	
	
	
	@FindBy(css=".item-129 a")// banner image 
	private WebElement PRICING_BTN;
	
	@FindBy(css=".item-104 a")// banner image 
	private WebElement INTEGRATE_BTN;
	
	@FindBy(css=".item-128 a")// banner image 
	private WebElement LEARN_BTN;
	
	@FindBy(css=".item-101 a")// banner image 
	private WebElement HOME_BTN;
	
	public HomePage() {
		super();

	}

	protected WebElement getPageReadyElement() {
		return this.PAGE_READY_ELEMENT;
	}	


	
	/**
	 * click the sign in link ,open sign in dialog
	 */
	public SignInDialog OpenSignInDiv() {
		DriverUtil.wait(ExpectedConditions.visibilityOf(SIGN_IN_LINK));
		SIGN_IN_LINK.click();
		return BasePage.getPage(SignInDialog.class);

	}
	
	/**
	 * click the register button, open register dialog
	 */
	public RegisterDialog OpenRegisterDiv() {
		DriverUtil.wait(ExpectedConditions.visibilityOf(REGISTER_BTN));
		REGISTER_BTN.click();
		return BasePage.getPage(RegisterDialog.class);
	}
	
	/**
	 * get the copy right text at the bottom of home page.
	 * @return copyright string 
	 */
	public String getCopyRightTxt() {
		DriverUtil.wait(ExpectedConditions.visibilityOf(COPYRIGHT_TXT));
		return COPYRIGHT_TXT.getText();
	}
	
	
	/**
	 * click the watch video button of the first video, count from left
	 * @return HP_VideoXDialog
	 * @throws InterruptedException
	 */
	public VideoXDialog OpenVideo1() throws InterruptedException {
		DriverUtil.wait(ExpectedConditions.visibilityOf(VIDEO1_BTN));
		VIDEO1_BTN.click();
		return BasePage.getPage(VideoXDialog.class);
	}
	/**
	 * click the watch video button of the second video, count from left
	 * @return HP_VideoXDialog
	 * @throws InterruptedException
	 */
	public VideoXDialog OpenVideo2() throws InterruptedException {
		DriverUtil.wait(ExpectedConditions.visibilityOf(VIDEO2_BTN));
		VIDEO2_BTN.click();
		return BasePage.getPage(VideoXDialog.class);
	}
	/**
	 * click the watch video button of the third video, count from left
	 * @return HP_VideoXDialog
	 * @throws InterruptedException
	 */
	public VideoXDialog OpenVideo3() throws InterruptedException {
		DriverUtil.wait(ExpectedConditions.visibilityOf(VIDEO3_BTN));
		VIDEO3_BTN.click();
		return BasePage.getPage(VideoXDialog.class);
	}
	/**
	 * click the contact link ,open contact page.
	 * @return ContactPage
	 */
	public ContactPage OpenContactPage() {
		DriverUtil.wait(ExpectedConditions.visibilityOf(CONTACT_BTN));
		CONTACT_BTN.click();
		return BasePage.getPage(ContactPage.class);
	}
	/**
	 * click the banner image, open RigisterDialog
	 * @return HP_RegisterDialog
	 */
	public RegisterDialog clickBannerImg(){
		DriverUtil.wait(ExpectedConditions.visibilityOf(BANNER_IMG2));
		BANNER_IMG2.click();
		return BasePage.getPage(RegisterDialog.class);
		
	}
	
	public LearnPage clickLearnBtn(){
		DriverUtil.wait(ExpectedConditions.visibilityOf(LEARN_BTN));
		LEARN_BTN.click();
		return BasePage.getPage(LearnPage.class);
		
	}
	
	public HomePage clickHomeBtn(){
		DriverUtil.wait(ExpectedConditions.visibilityOf(HOME_BTN));
		HOME_BTN.click();
		System.out.println("home_btn click");
		return BasePage.getPage(HomePage.class);
		
	}
	public IntegratePage clickIntegrateBtn(){
		DriverUtil.wait(ExpectedConditions.visibilityOf(INTEGRATE_BTN));
		INTEGRATE_BTN.click();
		return BasePage.getPage(IntegratePage.class);
		
	}
	public PricePage clickPricingBtn(){
		DriverUtil.wait(ExpectedConditions.visibilityOf(PRICING_BTN));
		PRICING_BTN.click();
		return BasePage.getPage(PricePage.class);
	}
	
	
}
