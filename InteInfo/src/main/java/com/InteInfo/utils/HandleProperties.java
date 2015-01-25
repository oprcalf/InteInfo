package com.InteInfo.utils;
/**
 * @author OprCalf
 * @Date 2014/01/06
 * 
 */
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class HandleProperties {

	private Properties prop;
	private InputStream is;

	public String getProps(String str) {
		prop = new Properties();
		String strValue = "";
		try {
			is = getClass().getClassLoader().getResourceAsStream("systemConfig.properties");
			prop.load(is);
			strValue = prop.getProperty(str);
			if (is != null) {
				is = null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return strValue;
	}
}
