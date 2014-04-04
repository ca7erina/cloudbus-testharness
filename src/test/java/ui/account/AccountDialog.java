package ui.account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import ui.BasePage;
import ui.home.HomePage;

/**
 * This is the Sign-in dialog object shows after click the sign-in link on the upper right of home page.
 * It's seen as a type of Page.
 * 
 * @author XiaoXue_Chen
 *
 */
public class AccountDialog extends BasePage {
	
	@FindBy(id = "logout-dialog")		//Sign-in dialog window shows after click the sign-in link.
	@CacheLookup
	private WebElement PAGE_READY_ELEMENT;
	
	@FindBy(css = ".control-group:nth-child(1) a")		//Sign-in button at the dialog window.
	private WebElement MGR_ACCOUNT_LINK;
	@FindBy(css = ".control-group:nth-child(2) input.btn.btn-link.logout-link")		//Username input
	private WebElement SIGN_OUT_LINK;


	public AccountDialog() {
		super();

	}

	protected WebElement getPageReadyElement() {
		return this.PAGE_READY_ELEMENT;
	}

	public HomePage clickSignOutLink(){
		if (isElementVisible(SIGN_OUT_LINK)) {
			SIGN_OUT_LINK.click();

		}
		return BasePage.getPage(HomePage.class);
	}
	
	
	public AccountInfoPage_AfterSignIn clickManageAccountLink(){
		MGR_ACCOUNT_LINK.click();
		return BasePage.getPage(AccountInfoPage_AfterSignIn.class);
	}
	
	
	
}