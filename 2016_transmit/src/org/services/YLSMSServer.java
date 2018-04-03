package org.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;

import org.apache.log4j.Logger;

public class YLSMSServer extends Thread {
	private static Logger log = Logger.getLogger(YLSMSServer.class);
	// 等待验证进程的时间周期
	public static long waiteTime = 60 * 1000 * 60;
	// 服务线程，用以控制服务器只启动一个实例
	public static ServerSocket tempSocket = null;
	// 占用一个端口，用以控制服务器只启动一个实例
	public static final int socketPort = 18819;

	public static void main(String[] args) throws IOException {
		checkSimpleInstance();
		System.out
				.println("***************************************************************");
		System.out
				.println("**                  上传移车信息系统启动                        **");
		System.out
				.println("***************************************************************");
		System.out.println("");
		startthread();
	}

	/**
	 * 启动发送短信网关
	 */
	private static void startthread() {
//		System.out.println("------- sleep 11 h -------");
//		try {
//			sleep(11 * 60 * 60 * 1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		YLSMSThread thread = new YLSMSThread();
		thread.start();
		System.out.println("提示：上传移车信息系统启动  ...[启动成功]");
		// System.out.println(System.currentTimeMillis());
		// System.out.println(thread.getCurrentTime());
		System.out.println("");

		// 检测，防止线程死掉
/*
		while (true) {
			log.info("* 启动检测线程 *");
			if (System.currentTimeMillis() - thread.getCurrentTime() > waiteTime) {
				System.out.println("线程死锁...");
				System.out.println("停止死锁线程");
				thread.interrupt();
				System.out.println("提示：[停止成功]");
				System.out.println("创建新线程...");
				thread = new YLSMSThread();
				thread.start();
				System.out.println("提示：[创建成功]");
			}
			try {
				System.out.println("提示：[没有死锁]");
				log.info("* 睡眠 " + waiteTime + " *");
				sleep(waiteTime);
			} catch (InterruptedException e) {
				log.info("* 检测错误： " + e.getMessage() + " *");
				e.printStackTrace();
			}
		}*/

	}

	/**
	 * 检测系统只启动了一个实例
	 */
	private static void checkSimpleInstance() {
		try {
			tempSocket = new ServerSocket(socketPort);
		} catch (IOException ex) {
			log.info("本程序在本台计算机上已经启动，请不要重复启动！");
			// if (ex.getMessage().indexOf("Address already in use") > -1) {
			System.out
					.println("***************************************************************");
			System.out
					.println("**         本程序在本台计算机上已经启动，请不要重复启动！          **");
			System.out
					.println("***************************************************************");
			System.out.println("按Enter键退出!");
			try {
				new BufferedReader(new InputStreamReader(System.in)).readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.exit(0);
		}
	}

}
