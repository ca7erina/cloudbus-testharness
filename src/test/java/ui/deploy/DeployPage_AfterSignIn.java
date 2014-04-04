package ui.deploy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ui.BasePage;
import util.CfgLoader;
import util.DriverUtil;

public class DeployPage_AfterSignIn extends BasePage {
	public static String PAGE_URL=CfgLoader.deployPageUrl;
	public static String PAGE_TITLE=CfgLoader.deployPageTitle;
	
	
	@FindBy(css = ".site.com_content.view-article.no-layout.no-task.itemid-102")// Web element in the page
	private WebElement PAGE_READY_ELEMENT;
	@FindBy(css = "#name")
	private WebElement NAME_INPUT;
	@FindBy(css = "#url")
	private WebElement URL_INPUT;
	@FindBy(css = "#desc")
	private WebElement DESC_TEXTAREA;
	@FindBy(css = "#submit-btn")
	private WebElement SUBMIT_BTN;

	@FindBy(css = ".download-eula-box div a")
	private WebElement LICENSE_AGREEMENT_LINK;
	@FindBy(css = ".resend-credentials")
	private WebElement RESEND_CREDENTIALS_LINK;
	@FindBy(css = ".connect-button-text")
	private WebElement CONNECT_BTN;
	@FindBy(css = ".btn.btn-disabled.pull-right.premise-pack-btn.content-button")
	private WebElement ONPREMISES_ENV_BTN;
	private WebElement NewEvn_name;
	private WebElement NewEvn_desc;
	
	
	public DeployPage_AfterSignIn registerNewEnv(String name,String url,String desc){
		NAME_INPUT.clear();
		NAME_INPUT.sendKeys(name);
		URL_INPUT.clear();
		URL_INPUT.sendKeys(url);
		DESC_TEXTAREA.clear();
		DESC_TEXTAREA.sendKeys(desc);
		SUBMIT_BTN.click();
//		NewEvn_name=DriverUtil.getDriver().findElement(by);
		return BasePage.getPage(DeployPage_AfterSignIn.class);		
	}
	
	public void clickLicenseLink(){
		LICENSE_AGREEMENT_LINK.click();
	}
	public void clickResendCredentialsLink(){
		 RESEND_CREDENTIALS_LINK.click();
	}
	public void clickConnectBtn(){
		CONNECT_BTN.click();
	}
	
	public OnPremisesEnvironmentPage_AfterSignIn clickOnPremisesEnvBtn(){
		ONPREMISES_ENV_BTN.click();
		return BasePage.getPage(OnPremisesEnvironmentPage_AfterSignIn.class);
		
	} 
	
	
	
	@Override
	protected WebElement getPageReadyElement() {
		return PAGE_READY_ELEMENT;
	}
}
