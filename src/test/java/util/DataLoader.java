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
public class DataLoader {
	
	// the path of 'conf.properties' file
	static String confFile = "conf/testdata.properties";

	
	//TestData 
	public static String userEmail=load("testdata.user.email");
	public static String userPwd=load("testdata.user.pwd");
	public static String userName=load("testdata.user.name");
	


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
