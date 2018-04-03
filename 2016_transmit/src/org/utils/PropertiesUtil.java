package org.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesUtil {

	private static Properties props_define = new Properties();

	/**
	 * 根据自定义属性文件获取键值
	 */
	public static String getDefineKeyValue(String filename, String key) {
		try {
			props_define.load(new FileInputStream(ResourceUtil.getClassPath()
					+ filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(-1);
		} catch (IOException e) {
			System.exit(-1);
		}
		return props_define.getProperty(key);
	}

	public static void main(String[] args) {
		// System.out.println(PropertiesUtil.getKeyValue_token("access_token"));
		System.out.println(PropertiesUtil.getDefineKeyValue("jdbc.properties",
				"driverClassName"));
	}

}
