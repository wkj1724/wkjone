package org.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


	public class HttpUtil {
		
		static{
			PropertyConfigurator.configure (HttpUtil.class.getClassLoader().getResource("log4j.properties"));
			//System.out.println("log4j配置成功!");
		}
		private static Logger logger = Logger.getLogger(HttpUtil.class);
		public static String post(String url, Map<String, String> params) {
			URL u = null;
			HttpURLConnection con = null;
			// 构建请求参数
			StringBuffer sb = new StringBuffer();
			if (params != null) {
				for (String e : params.keySet()) {
					sb.append(e);
					sb.append("=");
					sb.append(params.get(e));
					sb.append("&");
				}
				sb.substring(0, sb.length() - 1);
			}
//			logger.info("send_data:" + sb.toString());
			// 尝试发送请求
			try {
				u = new URL(url);
				con = (HttpURLConnection) u.openConnection();
				con.setRequestMethod("GET");
				con.setDoOutput(true);
				con.setDoInput(true);
				con.setUseCaches(false);
				con.setRequestProperty("Content-Type",
						"application/x-www-form-urlencoded");
				OutputStreamWriter osw = new OutputStreamWriter(
						con.getOutputStream(), "UTF-8");
				osw.write(sb.toString());
				osw.flush();
				osw.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (con != null) {
					con.disconnect();
				}
			}

			// 读取返回内容
			StringBuffer buffer = new StringBuffer();
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(
						con.getInputStream(), "UTF-8"));
				String temp;
				while ((temp = br.readLine()) != null) {
					buffer.append(temp);
					buffer.append("\n");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			return buffer.toString();
		}
	}
