package ui.deploy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ui.BasePage;
import ui.integrate.IntegratePage;
import ui.register.RegisterDialog;
import util.CfgLoader;
import util.DriverUtil;

public class EULAAgreementPage extends BasePage {
	public String PAGE_URL=CfgLoader.eulaAgreementPdfPageUrl;
	public String PAGE_TITLE=CfgLoader.eulaAgreementPdfPageTitle;



	@Override
	protected WebElement getPageReadyElement() {
		
		return null;
	}
	
	
}
