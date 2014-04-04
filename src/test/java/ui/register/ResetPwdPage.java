package ui.register;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ui.BasePage;
import util.CfgLoader;
/**
 *  This is the reset-password page object represent The page let you reset your password 
 *  
 * @author XiaoXue_Chen
 *
 */

public class ResetPwdPage extends BasePage {
	public static String PAGE_TITLE=CfgLoader.resetPwdPageTitle;

	@FindBy(css = ".forgetPasswordDiv")		//the element identifies the page
	private WebElement PAGE_READY_ELEMENT;

	public ResetPwdPage() {
		super();

	}

	protected WebElement getPageReadyElement() {
		return this.PAGE_READY_ELEMENT;
	}

}