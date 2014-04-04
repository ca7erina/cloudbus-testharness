package util.report;

import java.net.InetAddress;
import java.util.TimeZone;

import org.junit.Test;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import util.CfgLoader;
import util.DriverUtil;

public class EnvDetector {
	private final static Logger logger = LoggerFactory
			.getLogger(EnvDetector.class);
	private static WebDriver driver = DriverUtil
			.getDriver(CfgLoader.browserType);
	private static Capabilities capabilities = ((RemoteWebDriver) driver)
			.getCapabilities();
	private static TimeZone tz = TimeZone.getDefault();
	private static String broswerInfo;
	private static String javascriptInfo;
	private static String OsInfo;
	private static String timezone;
	private static String ip;
	private static String hostname;
	public static String testEvn;

	static {
		broswerInfo = "Browser: " + capabilities.getBrowserName() + "-"
				+ capabilities.getVersion();
		javascriptInfo = "JavascriptEnabled:"
				+ capabilities.isJavascriptEnabled();
		OsInfo = "OS: " + System.getProperty("os.name") + " version-"
				+ System.getProperty("os.version") + " "
				+ System.getProperty("os.arch");
		timezone = "TimeZone:" + tz.getDisplayName();
		// ip + hostname
		InetAddress netAddress = getInetAddress();
		ip = "IP: "+getHostIp(netAddress);
		hostname ="HostName: " +getHostName(netAddress);
		
		testEvn = broswerInfo + "<br/>" + OsInfo + "<br/>" + timezone+ "<br/>" +ip+ "<br/>" + hostname+"<br/>" ;
		driver.quit();
	}

	@Test
	public void getInfo() {
		// System.out.println(broswerInfo+"\n"+OsInfo+"\n"+ timezone);
		InetAddress netAddress = getInetAddress();
		System.out.println("host ip:" + getHostIp(netAddress));
		System.out.println("host name:" + getHostIp(netAddress));
	}

	public static InetAddress getInetAddress() {

		try {
			return InetAddress.getLocalHost();
		} catch (Exception e) {
			System.out.println("unknown host!");
		}
		return null;

	}

	public static String getHostIp(InetAddress netAddress) {
		if (null == netAddress) {
			return null;
		}
		String ip = netAddress.getHostAddress(); // get the ip address
		return ip;
	}

	public static String getHostName(InetAddress netAddress) {
		if (null == netAddress) {
			return null;
		}
		String name = netAddress.getHostName(); // get the host address
		return name;
	}
}
