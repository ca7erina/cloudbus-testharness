package ui.learn;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ui.BasePage;
import util.CfgLoader;
import util.DriverUtil;
import util.TestWatcheRule;

/**
 * This class contains all test cases on Learn Page.
 * 
 * 
 * @author XiaoXue_Chen
 * 
 */
public class ValidateLearnPage {
	private final static Logger logger = LoggerFactory.getLogger(ValidateLearnPage.class);
	private static WebDriver driver = DriverUtil.getDriver(CfgLoader.browserType);
	private LearnPage learnPage = BasePage.getPage(LearnPage.class);
	String CURRENT_WINDOW=DriverUtil.getDriver().getWindowHandle();
	
	@Test
	public void $32$validatePricePage() throws InterruptedException{
		assertTrue(learnPage.isPresent());
		assertEquals(learnPage.PAGE_TITLE,driver.getTitle());
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
		driver.get(learnPage.PAGE_URL);
	}

}