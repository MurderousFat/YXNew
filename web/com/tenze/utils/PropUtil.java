package com.tenze.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * @author  TenzeTseng
 *
 */
public class PropUtil {
	
	private static Properties p;
	
	static{
		InputStream is = null;
		try {
			is = PropUtil.class.getClassLoader().getResourceAsStream(
					"sysConfig.properties");
			p = new Properties();
			p.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static String getValue(String key) {
		return p.getProperty(key);
	}


}
