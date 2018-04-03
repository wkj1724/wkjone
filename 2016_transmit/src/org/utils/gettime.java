package org.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class gettime {
	public static String getend() {
		// TODO Auto-generated method stub
		 Date date = new Date();
	     SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
	     return sd.format(date);
	}
	public static String getbg() {
		// TODO Auto-generated method stub
		 Date date = new Date(new Date().getTime()-24*60*60*1000);
	     SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
	     return sd.format(date);
	}
	public static void main(String[] args) {
		getbg();
		getend();
	}
}
