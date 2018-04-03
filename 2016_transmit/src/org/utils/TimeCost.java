package org.utils;

public class TimeCost {
	
	public static String showCost(long cost){
		String res = "" ;
		long hours = cost / 3600 ;
		long min = cost % 3600 / 60 ;
		long second = cost % 60 ;
		res = hours+"–° ±"+min+"∑÷"+second+"√Î";
		
		return res;
	}


}
