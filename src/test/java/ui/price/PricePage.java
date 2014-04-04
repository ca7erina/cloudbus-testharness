package ui.price;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ui.BasePage;
import ui.integrate.IntegratePage;
import ui.register.RegisterDialog;
import util.CfgLoader;
import util.DriverUtil;

public class PricePage extends BasePage {
	public String PAGE_URL=CfgLoader.pricingPageUrl;
	public String PAGE_TITLE=CfgLoader.pricingPageTitle;

	@FindBy(css = ".site.com_content.view-article.no-layout.no-task.itemid-129")		//the web element identifies the page
	private WebElement PAGE_READY_ELEMENT;
	@FindBy(css = ".show-register-dialog")		//the web element identifies the page
	private WebElement REG_LINK;
	@FindBy(css=".pricing-questions-list li:nth-child(4) a")
	private WebElement HERE_LINK;
	@FindBy(css=".tbcsd")
	private WebElement SERVICEDOC_LINK;
	@FindBy(css=".pricing-questions-list li:nth-child(1) .question-answer  :nth-child(3)")
	private WebElement EMAIL_LINK_1;
	@FindBy(css=".contact-us a")
	private WebElement EMAIL_LINK_2;
	
	public RegisterDialog clickRegLink(){
		REG_LINK.click();
		return BasePage.getPage(RegisterDialog.class);
	}
	
	public IntegratePage clickHereLink(){
		HERE_LINK.click();
		return BasePage.getPage(IntegratePage.class);
	}
	
	public void clickServiceDocLink(){
		SERVICEDOC_LINK.click();
	}
	
	public void clickEmailAdress1(){
		EMAIL_LINK_1.click();
	}
	
	public void clickEmailAdress2(){
		EMAIL_LINK_2.click();
	}
	@Override
	protected WebElement getPageReadyElement() {
		System.out.println("return page ready element"+ PAGE_READY_ELEMENT);
		return PAGE_READY_ELEMENT;
	}

}
