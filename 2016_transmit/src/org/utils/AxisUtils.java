package org.utils;

import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.log4j.Logger;

/**
 * 
 * @Title: AxisUtils.java
 * @Package com.hesc.itra.utils
 * @Description: TODO(Axis2工具�?
 * @author panxiaochao
 * @date 2016-7-7 下午03:59:39
 * @version V1.0
 */
public class AxisUtils {
	private static Logger log = Logger.getLogger(AxisUtils.class);

	/**
	 * 远程调用方法
	 * 
	 * @param map
	 * @param xmlType
	 * @param url
	 * @return
	 */
	public static String aixs2Get(Map<String, String> map,
			Map<String, String> xmlType, String url) {
		String result = "";
		try {
			Service service = new Service();
			Call call = (Call) service.createCall();
			call.setUseSOAPAction(true);
			String qname = map.get("qname");
			call.setOperationName(new QName(qname, "outService"));
			call.setTargetEndpointAddress(url);
			// 参数
			call.addParameter(xmlType.get("mode1"), XMLType.XSD_STRING,
					ParameterMode.IN);
			call.addParameter(xmlType.get("mode2"), XMLType.XSD_STRING,
					ParameterMode.IN);
			call.addParameter(xmlType.get("mode3"), XMLType.XSD_STRING,
					ParameterMode.IN);
			//
			call.setReturnType(XMLType.XSD_STRING);
			result = (String) call.invoke(new Object[] { map.get("id"),
					map.get("key"), map.get("xml") });

			System.out.println("\n调用参数\n" + map.get("xml") + "\n返回结果\n"
					+ result + "\n");
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
			result = errorXml(e.getMessage());
		}
		return result;
	}

	/**
	 * 远程调用方法
	 * 
	 * @param map
	 * @param url
	 * @return
	 */
	public static String aixs2Get_m2(Map<String, String> map, String url) {
		// TODO Auto-generated method stub
		String result = "";
		try {
			Service service = new Service();
			Call call = (Call) service.createCall();
			call.setUseSOAPAction(true);
			String qname = "http://server.xfire.service.oserver.cdt.com";
			call.setOperationName(new QName(qname, "outSyncService"));
			call.setTargetEndpointAddress(url);
			// 参数
			call.addParameter("jkurl", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("jkhsm", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("jkcs", XMLType.XSD_STRING, ParameterMode.IN);
			//
			call.setReturnType(XMLType.XSD_STRING);
			result = (String) call.invoke(new Object[] { map.get("id"),
					map.get("key"), map.get("xml") });

			System.out.println("\n调用参数\n" + map.get("xml") + "\n返回结果\n"
					+ result + "\n");
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
			result = errorXml(e.getMessage());
		}
		return result;
	}

	/**
	 * 远程调用方法
	 * 
	 * @param map
	 * @param xmlType
	 * @param url
	 * @return
	 */
	public static String aixs2Get_m5(Map<String, String> map, String[] xmlType,
			String[] xmlArgs, String url) {
		String result = "";
		try {
			String method = map.get("method");
			String targetNamespace = map.get("namespace");
			//
			Service service = new Service();
			Call call = (Call) service.createCall();
			//
			call.setOperationName(new QName(targetNamespace, method));
			call.setTargetEndpointAddress(url);
			// 参数
			for (String paramName : xmlType) {
				call.addParameter(new QName(targetNamespace, paramName),
						XMLType.XSD_STRING, ParameterMode.IN);
			}
			call.setReturnType(XMLType.XSD_STRING);
			//
			call.setUseSOAPAction(true);
			call.setSOAPActionURI(targetNamespace + method);
			//
			Object[] object = new Object[xmlArgs.length];
			for (int i = 0; i < xmlArgs.length; i++) {
				object[i] = xmlArgs[i];
			}
			result = (String) call.invoke(object);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			result = errorXml(e.getMessage());
		}
		return result;
	}

	/**
	 * 接口报错，返�?99
	 * 
	 * @param errorinfo
	 * @return
	 */
	private static String errorXml(String errorinfo) {
		// TODO Auto-generated method stub
		String code = "-99";
		String errorJson = "{\"Code\": \"" + code + "\",\"Message\": \""
				+ errorinfo + "\"}";
		return errorJson;
	}

	public static void main(String[] args) {
		String[] xmlArgs = { "select", "tz114", "" };
		System.out.println(xmlArgs.toString());
	}
}
