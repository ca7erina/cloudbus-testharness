package ui.contact;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ui.BasePage;
import ui.home.HomePage;
import ui.home.VideoXDialog;
import util.CfgLoader;
import util.DriverUtil;
import util.TestWatcheRule;
/**
 * This test contains tests on Contact Page (For Guest).
 * 
 * @author XiaoXue_Chen
 *
 */
public class ValidateContactPageAsGuest {
	private final static Logger logger = LoggerFactory.getLogger(ValidateContactPageAsGuest.class);
	private static WebDriver driver = DriverUtil.getDriver(CfgLoader.browserType);
	
	HomePage homePage = BasePage.getPage(HomePage.class);
	ContactPage contactPage= BasePage.getPage(ContactPage.class);
	
	@Test
	public void $123$CheckErrorMsgtoInvalideInput(){
		contactPage.inputEmailAndMsg("werwerwerwe","ewfefe");
		contactPage.Submit();
		assertEquals(contactPage.getEmailErrorNotic(),"What is your email address?");
		
	}
	
	@Test
	public void $125$CheckResetButton(){
		contactPage.inputEmailAndMsg("werwerwerwe","ewfefe");
		contactPage.clickReset();
		assertEquals(contactPage.isInputEmpty(),true);
	}
	
	@Rule
	public TestWatcheRule watcher = new TestWatcheRule(logger, driver);

	@AfterClass
	public static void afterAllIsSaidAndDone() {
		driver.quit();
	}

	@After
	public void tearDown() {
		driver.manage().deleteAllCookies();
	}

	@Before
	public void setUp() {
		driver.get(contactPage.PAGE_URL);
	}
}
