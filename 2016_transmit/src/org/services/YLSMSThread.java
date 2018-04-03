package org.services;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.action.YcOrderServiceDouble;
import org.apache.log4j.Logger;
import org.utils.AxisUtils;
import org.utils.JdbcUtils;



public class YLSMSThread extends Thread {
	private static Logger log = Logger.getLogger(YLSMSThread.class);
	long currenttime = System.currentTimeMillis();

	public long getCurrentTime() {
		return currenttime;
	}

	@SuppressWarnings("unchecked")
	public void run() {
		while (true) {
			YcOrderServiceDouble.transmit();
			System.out.println("------- sleep 24 h -------");
			try {
				sleep(24 * 60 * 60 * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private boolean sptel(String obtel) {
		// TODO Auto-generated method stub
		if (obtel.length() == 11)
			return true;
		else
			return false;
	}

	public static String[] spiltTel(String tel) {
		return tel.split("、");
	}

	@SuppressWarnings("unchecked")
	public static void test() {
	}

	public static void main(String arg[]) {
		String[] spilttel = YLSMSThread.spiltTel("123,asd");
		System.out.println(spilttel.length);
		System.out.println("------- 短信码：[2000] 调用错误，停止调用！ -------");
	}

}
