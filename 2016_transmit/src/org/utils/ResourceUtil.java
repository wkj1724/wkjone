package org.utils;

import java.io.InputStream;

/**
 * 
 * @author pxc
 * 
 */
public class ResourceUtil {
	/**
	 * 得到class路径
	 * 
	 * @return
	 */
	public static String getClassPath() {
		String path = Thread.currentThread().getContextClassLoader()
				.getResource("properties/").toString();
		String temp = path.replaceFirst("file:/", "");
		String separator = System.getProperty("file.separator");
		String resultPath = temp.replaceAll("/", separator + separator);
		return resultPath;
	}

	/**
	 * 得到getStream
	 * 
	 * @return
	 */
	public static InputStream getStream(String name) {
		return Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("properties/" + name);
	}

	public static void main(String[] args) {
		System.out.println();

	}
}
