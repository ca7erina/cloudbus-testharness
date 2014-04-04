package ui.signIn;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ui.BasePage;
import ui.home.HomePage;
import ui.home.HomePage_AfterSignIn;
import ui.register.ResetPwdPage;
import util.CfgLoader;
import util.DataLoader;
import util.DriverUtil;

/**
 * This is the Sign-in dialog object shows after click the sign-in link on the upper right of home page.
 * It's seen as a type of Page.
 * 
 * @author XiaoXue_Chen
 *
 */
public class SignInDialog extends BasePage {
	
	@FindBy(id = "login-dialog")		//Sign-in dialog window shows after click the sign-in link.
	@CacheLookup
	private WebElement PAGE_READY_ELEMENT;
	@FindBy(css = ".btn.pull-right.sub-action-button")		//Sign-in button at the dialog window.
	private WebElement SIGN_IN_BTN;
	@FindBy(id = "username")		//Username input
	private WebElement USRNAME_INPUT;
	@FindBy(id = "password")		//Password input
	private WebElement PWD_INPUT;
	@FindBy(css = "#form-login div.error-msg")		//Error message shows after input a wrong password or username.
	private WebElement ERROR_MSG_DIV;
	@FindBy(css = "#agreement input.eula")		//Agreement check shows some time in the sign in dialog after submitting to login.
	private WebElement AGREEMENT_CHECKBOX;
	@FindBy(css = "#form-login a.forget-password-link.pull-right")		//Forgot password link at the dialog window.
	private WebElement FORGOT_PWD_LINK;
	private By LOADIND_DIV_LOCATOR = new By.ByCssSelector(".login-loading");		//The locator to get the dynamic loading sign.

	public SignInDialog() {
		super();

	}
//	@Test
//	public void test() {
//		System.out.println(CfgLoader.accountInfoPageTitle);
//		System.out.println(DataLoader.userEmail+" "+DataLoader.userPwd);
//		System.out.println(new HomePage().PAGE_URL);
//		DriverUtil.getDriver(CfgLoader.browserType).get(new HomePage().PAGE_URL);
//		HomePage.getPage(HomePage.class).OpenSignInDiv();
//		loginAs(DataLoader.userEmail,DataLoader.userPwd);
//	}
	protected WebElement getPageReadyElement() {
		return this.PAGE_READY_ELEMENT;
	}

	public HomePage_AfterSignIn loginAs(String username, String password) {
		clickLogin(username, password);
		return BasePage.getPage(HomePage_AfterSignIn.class);
	}

	public void failLoginAs(String username, String password)throws InterruptedException {
		clickLogin(username, password);

	}
	
	private void clickLogin(String username, String password) {
		USRNAME_INPUT.clear();
		USRNAME_INPUT.sendKeys(username);
		PWD_INPUT.clear();
		PWD_INPUT.sendKeys(password);
		SIGN_IN_BTN.click();
		DriverUtil.wait(ExpectedConditions.invisibilityOfElementLocated(LOADIND_DIV_LOCATOR));
		if (isElementVisible(AGREEMENT_CHECKBOX)) {
			AGREEMENT_CHECKBOX.click();
			SIGN_IN_BTN.click();
		}
	}

	public String getErrorMessage() throws InterruptedException {
		DriverUtil.wait(ExpectedConditions.invisibilityOfElementLocated(LOADIND_DIV_LOCATOR));
		DriverUtil.wait(ExpectedConditions.visibilityOf(ERROR_MSG_DIV));
		return ERROR_MSG_DIV.getText();
	}

	public ResetPwdPage OpenForgetPwdLink() {
		FORGOT_PWD_LINK.click();
		return BasePage.getPage(ResetPwdPage.class);

	}

	public String GetUrlOfResetPwdPage() {
		return FORGOT_PWD_LINK.getAttribute("href");
	}
	
	
}