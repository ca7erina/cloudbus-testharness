package util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;




/**
 * This is a loader utility for loading all the properties from configure file "conf.properties"
 * 
 * @author XiaoXue_Chen
 * 
 */
public class CfgLoader {
	
	// the path of 'conf.properties' file
	static String confFile = "conf/conf.properties";
	// type of browser
	public static String browserType = load("browser.type");

	//Max waiting time
	public static String maxWait=load("maxWait");
	// browser drivers path
	public static String chromeDriverPath = load("browser.chromeDriverPath");
	public static String ieDriverPath = load("browser.ieDriverPath");
	public static String firefoxDriverPath = load("browser.firefoxDriverPath");
	
	// report simple model
	public static String reportSamplePath = load("report.samplePath");

	// properties using in test report
	public static String projectName = load("report.projectName");
	public static String testResultSamplePath = load("report.testResultSamplePath");
	public static String testResultPath = load("report.testResultPath");
	public static String os = load("report.os");
	public static String browserVersion = load("report.browserVersion");
	public static String testLocation = load("report.testLocation");
	public static String screenshotPath=load("report.screenshotPath");
	public static String toCheckPath=load("report.toCheckPath");

	// properties of email
	public static String hostName = load("email.hostName");
	public static String authenticationName = load("email.authenticationName");
	public static String authenticationPwd = load("email.authenticationPwd");
	public static String sentFrom = load("email.sentFrom");
	public static String subject = load("email.subject");
	public static String dateformat = load("email.dateformat");
	public static String sendTo[];
	public static String ccTo[];

	//Page URL 
	public static String homePageUrl=load("url.homePage");
	public static String contactPageUrl=homePageUrl+load("url.contactPage");
	public static String whyRegPageUrl=homePageUrl+load("url.whyRegPage");
	public static String intergratePageUrl=homePageUrl+load("url.intergratePage");
	public static String pricingPageUrl=homePageUrl+load("url.pricingPage");
	public static String learnPageUrl=homePageUrl+load("url.learnPage");
	public static String developPageUrl=homePageUrl+load("url.developPage");
	public static String deployPageUrl=homePageUrl+load("url.deployPage");
	public static String environmentDetailPageUrl=homePageUrl+load("url.environmentDetailPage");
	public static String intergrateTibberUrl=homePageUrl+load("url.intergrateTibber");
	public static String intergrateSalesforceUrl=homePageUrl+load("url.intergrateSalesforce");
	public static String intergrateSapUrl=homePageUrl+load("url.intergrateSap");
	public static String intergrateFoursquareUrl=homePageUrl+load("url.intergrateFoursquare");
	public static String intergrateEvernoteUrl=homePageUrl+load("url.intergrateEvernote");
	public static String intergrateDropboxUrl=homePageUrl+load("url.intergrateDropbox");
	public static String intergrateFacebookUrl=homePageUrl+load("url.intergrateFacebook");
	public static String intergrateSatisfactionUrl=homePageUrl+load("url.intergrateSatisfaction");
	public static String intergrateYammerUrl=homePageUrl+load("url.intergrateYammer");
	public static String intergrateMailchimpUrl=homePageUrl+load("url.intergrateMailchimp");
	public static String intergrateInstagramUrl=homePageUrl+load("url.intergrateInstagram");
	public static String intergrateSqsUrl=homePageUrl+load("url.intergrateSqs");
	public static String intergrateFlickrUrl=homePageUrl+load("url.intergrateFlickr");
	public static String intergrateJigsawUrl=homePageUrl+load("url.intergrateJigsaw");
	public static String servicePdfPageUrl=homePageUrl+load("url.servicePdfPage");
	public static String eulaAgreementPdfPageUrl=load("url.eulaAgreementPdfPage");
	public static String accountInfoPageUrl=homePageUrl+load("url.accountInfoPage");

	//Page PageTitle 
	public static String homePageTitle=load("title.homePage");
	public static String contactPageTitle=load("title.contactPage");
	public static String whyRegPageTitle=load("title.whyRegPage");
	public static String intergratePageTitle=load("title.intergratePage");
	public static String pricingPageTitle=load("title.pricingPage");
	public static String learnPageTitle=load("title.learnPage");
	public static String developPageTitle=load("title.developPage");
	public static String deployPageTitle=load("title.deployPage");
	public static String environmentDetailPageTitle=load("title.environmentDetailPage");
	public static String intergrateTibberPageTitle=load("title.intergrateTibber");
	public static String intergrateSalesforcePageTitle=load("title.intergrateSalesforce");
	public static String intergrateSapPageTitle=load("title.intergrateSap");
	public static String intergrateFoursquarePageTitle=load("title.intergrateFoursquare");
	public static String intergrateEvernotePageTitle=load("title.intergrateEvernote");
	public static String intergrateDropboxPageTitle=load("title.intergrateDropbox");
	public static String intergrateFacebookPageTitle=load("title.intergrateFacebook");
	public static String intergrateSatisfactionPageTitle=load("title.intergrateSatisfaction");
	public static String intergrateYammerPageTitle=load("title.intergrateYammer");
	public static String intergrateMailchimpPageTitle=load("title.intergrateMailchimp");
	public static String intergrateInstagramPageTitle=load("title.intergrateInstagram");
	public static String intergrateSqsPageTitle=load("title.intergrateSqs");
	public static String intergrateFlickrPageTitle=load("title.intergrateFlickr");
	public static String intergrateJigsawPageTitle=load("title.intergrateJigsaw");
	public static String servicePdfPageTitle=homePageUrl+load("title.servicePdfPage");
	public static String eulaAgreementPdfPageTitle=load("title.eulaAgreementPdfPage");
	public static String resetPwdPageTitle=load("title.resetPwdPage");
	public static String createAccountPageTitle=load("title.createAccountPage");

	public static String accountInfoPageTitle=load("title.accountInfoPage");
	
	//Data 
	public static String testcasesPath=load("data.testCases");
	
	
	//parse email list.
	static{
		sendTo=parseEmail("email.sentTo");
		ccTo=parseEmail("email.ccTo");
	}
	
	
	private static String[] parseEmail(String cfgname){
		String loaded=load(cfgname);
		String singleAddress[]=new String[1];
		if (loaded.indexOf(",")>0){
			return loaded.split(",");
		}
		 singleAddress[0]=loaded;
		return singleAddress;
	}
	
	

	public static String load(String key) {
		Properties props = new Properties();
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(
					confFile));
			props.load(in);
			String value = props.getProperty(key);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
