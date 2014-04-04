package ui.price;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ui.BasePage;
import ui.integrate.IntegratePage;
import ui.register.RegisterDialog;
import util.CfgLoader;
import util.DriverUtil;

public class ServicePdfPage extends BasePage {
	public String PAGE_URL=CfgLoader.servicePdfPageUrl;
	public String PAGE_TITLE=CfgLoader.servicePdfPageTitle;



	@Override
	protected WebElement getPageReadyElement() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
