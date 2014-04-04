package ui.account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ui.BasePage;
import util.CfgLoader;

public class AccountInfoPage_AfterSignIn extends BasePage {
	public String PAGE_URL=CfgLoader.accountInfoPageUrl;
	public String PAGE_TITLE=CfgLoader.accountInfoPageTitle;
	
	
	@FindBy(css = ".site.com_users.view-profile.no-layout.no-task.itemid-114")// Web element in the page
	private WebElement PAGE_READY_ELEMENT;
	@FindBy(css = ".btn.btn-edit-profile")
	private WebElement EDIT_LINK;
	
	
	public void clickEditlink(){
		EDIT_LINK.click();
	}


	@Override
	protected WebElement getPageReadyElement() {
		return PAGE_READY_ELEMENT;
	}
	
}
