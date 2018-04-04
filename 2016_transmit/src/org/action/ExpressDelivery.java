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
	private static String SERVER_URL = "http://116.228.55.190:50022/bop/service";  //测试地址
//	private static String SERVER_URL = "http://116.228.55.172:9088/bop/service";111111
	
	
	public void send(Order order){
		Map <String, String>map = new HashMap<String, String>();
    	map.put("appKey", APP_KEY); //第二个参数为AppKey, 有O2O系统分配
    	map.put("method", "common.saveOrder"); 
    	map.put("v", "1.0");
    	map.put("messageFormat", "json");
    	map.put("prodCode", prodCode); //第二个参数有O2O系统分配
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
    	String content =  "{\"一级分类\":\""+order.getKind()+"\",\"二级分类\":\""+order.getDanhao()
		+"\",\"商户名称\":\""+order.getCompany()+"\"}";
//    	System.out.println(content);
    	map.put("orderContent", content);
    	map.put("note", "无");
    	map.put("source", "0");
    	String sign = RopUtils.sign(map, APP_SECRET); //第二个参数为SecretKey, 有O2O系统分配
    	map.put("sign", sign);
    	String response = HttpUtil.post(SERVER_URL, map);
    	String status = response.substring(response.indexOf("\"status\":")+9,response.indexOf("\"status\":")+10);
    	if(!(status.equals("0"))){
    		status = response.substring(0,response.length()-1);
    	}
    	try {
    		order.setStatus(Integer.parseInt(status));    	
		} catch (Exception e) {
			System.out.println("上传失败！接口返回参数"+status);
			order.setStatus(-1);
		}
    	
//    	System.out.println("--"+status);
		
	}
	
	public static void main(String[] args){
		/*
		Map <String, String>map = new HashMap<String, String>();
    	map.put("appKey", APP_KEY); //第二个参数为AppKey, 有O2O系统分配
    	map.put("method", "common.saveOrder"); 
    	map.put("v", "1.0");
    	map.put("messageFormat", "json");
    	map.put("prodCode", prodCode); //第二个参数有O2O系统分配
    	map.put("cityCode", "330100");
    	map.put("cityName", "杭州");
    	map.put("orderId", "0123456789012345678901234567890123456789");
    	map.put("userPhone", "137508828888");
    	map.put("userId", "");
    	map.put("userName","张三");
    	map.put("userAddress","杭州市延安路");
//    	map.put("userCardId", "110110190001010001");
//    	map.put("email", "common@besttone.com.cn");
    	map.put("actionDate", "2014-10-18 00:00:00");
    	map.put("orderName", "快递");
    	map.put("status", "2");
//    	map.put("orderContent", "{[\"用户名称\":\"张三\",\"用户年龄\":18],[\" 用户名称\":\"李四\",\"用户年龄\":19]}");
    	map.put("note", "无");
    	map.put("source", "0");
    	String sign = RopUtils.sign(map, APP_SECRET); //第二个参数为SecretKey, 有O2O系统分配
    	map.put("sign", sign);
    	String response = HttpUtil.post(SERVER_URL, map);
    	System.out.println(response.length());
    	*/
	}

}
