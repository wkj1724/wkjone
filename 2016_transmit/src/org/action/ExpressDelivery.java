package org.action;

import java.util.HashMap;
import java.util.Map;

import org.utils.HttpUtil;
import org.utils.Order;
import org.utils.RopUtils;



public class ExpressDelivery {
	private static String APP_KEY = "move_car_service";
	private static String prodCode = "move_car";
	private static String APP_SECRET = "30F2DCDA200D7111625A21D32B3CC439";
	private static String SERVER_URL = "http://116.228.55.190:50022/bop/service";  //���Ե�ַ
//	private static String SERVER_URL = "http://116.228.55.172:9088/bop/service";
	
	
	public void send(Order order){
		Map <String, String>map = new HashMap<String, String>();
    	map.put("appKey", APP_KEY); //�ڶ�������ΪAppKey, ��O2Oϵͳ����
    	map.put("method", "common.saveOrder"); 
    	map.put("v", "1.0");
    	map.put("messageFormat", "json");
    	map.put("prodCode", prodCode); //�ڶ���������O2Oϵͳ����
    	map.put("cityCode", order.getCityCode());
    	map.put("cityName", order.getCityName());
    	map.put("orderId", order.getOrderId());
    	map.put("userPhone", order.getUserPhone());
    	map.put("userId", order.getUserId());
    	map.put("userName", order.getUserName());
    	map.put("userAddress", order.getUserAddress());
//    	map.put("userCardId", "110110190001010001");
//    	map.put("email", "common@besttone.com.cn");
    	map.put("actionDate", order.getActionDate());
    	map.put("orderName", order.getOrderName());
    	map.put("fee", order.getCost());
    	map.put("status", "2");
    	String content =  "{\"һ������\":\""+order.getKind()+"\",\"��������\":\""+order.getDanhao()
		+"\",\"�̻�����\":\""+order.getCompany()+"\"}";
//    	System.out.println(content);
    	map.put("orderContent", content);
    	map.put("note", "��");
    	map.put("source", "0");
    	String sign = RopUtils.sign(map, APP_SECRET); //�ڶ�������ΪSecretKey, ��O2Oϵͳ����
    	map.put("sign", sign);
    	String response = HttpUtil.post(SERVER_URL, map);
    	String status = response.substring(response.indexOf("\"status\":")+9,response.indexOf("\"status\":")+10);
    	if(!(status.equals("0"))){
    		status = response.substring(0,response.length()-1);
    	}
    	try {
    		order.setStatus(Integer.parseInt(status));    	
		} catch (Exception e) {
			System.out.println("�ϴ�ʧ�ܣ��ӿڷ��ز���"+status);
			order.setStatus(-1);
		}
    	
//    	System.out.println("--"+status);
		
	}
	
	public static void main(String[] args){
		/*
		Map <String, String>map = new HashMap<String, String>();
    	map.put("appKey", APP_KEY); //�ڶ�������ΪAppKey, ��O2Oϵͳ����
    	map.put("method", "common.saveOrder"); 
    	map.put("v", "1.0");
    	map.put("messageFormat", "json");
    	map.put("prodCode", prodCode); //�ڶ���������O2Oϵͳ����
    	map.put("cityCode", "330100");
    	map.put("cityName", "����");
    	map.put("orderId", "0123456789012345678901234567890123456789");
    	map.put("userPhone", "137508828888");
    	map.put("userId", "");
    	map.put("userName","����");
    	map.put("userAddress","�������Ӱ�·");
//    	map.put("userCardId", "110110190001010001");
//    	map.put("email", "common@besttone.com.cn");
    	map.put("actionDate", "2014-10-18 00:00:00");
    	map.put("orderName", "���");
    	map.put("status", "2");
//    	map.put("orderContent", "{[\"�û�����\":\"����\",\"�û�����\":18],[\" �û�����\":\"����\",\"�û�����\":19]}");
    	map.put("note", "��");
    	map.put("source", "0");
    	String sign = RopUtils.sign(map, APP_SECRET); //�ڶ�������ΪSecretKey, ��O2Oϵͳ����
    	map.put("sign", sign);
    	String response = HttpUtil.post(SERVER_URL, map);
    	System.out.println(response.length());
    	*/
	}

}
