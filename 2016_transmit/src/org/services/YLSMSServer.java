package org.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;

import org.apache.log4j.Logger;

public class YLSMSServer extends Thread {
	private static Logger log = Logger.getLogger(YLSMSServer.class);
	// �ȴ���֤���̵�ʱ������
	public static long waiteTime = 60 * 1000 * 60;
	// �����̣߳����Կ��Ʒ�����ֻ����һ��ʵ��
	public static ServerSocket tempSocket = null;
	// ռ��һ���˿ڣ����Կ��Ʒ�����ֻ����һ��ʵ��
	public static final int socketPort = 18819;

	public static void main(String[] args) throws IOException {
		checkSimpleInstance();
		System.out
				.println("***************************************************************");
		System.out
				.println("**                  �ϴ��Ƴ���Ϣϵͳ����                        **");
		System.out
				.println("***************************************************************");
		System.out.println("");
		startthread();
	}

	/**
	 * �������Ͷ�������
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
		System.out.println("��ʾ���ϴ��Ƴ���Ϣϵͳ����  ...[�����ɹ�]");
		// System.out.println(System.currentTimeMillis());
		// System.out.println(thread.getCurrentTime());
		System.out.println("");

		// ��⣬��ֹ�߳�����
/*
		while (true) {
			log.info("* ��������߳� *");
			if (System.currentTimeMillis() - thread.getCurrentTime() > waiteTime) {
				System.out.println("�߳�����...");
				System.out.println("ֹͣ�����߳�");
				thread.interrupt();
				System.out.println("��ʾ��[ֹͣ�ɹ�]");
				System.out.println("�������߳�...");
				thread = new YLSMSThread();
				thread.start();
				System.out.println("��ʾ��[�����ɹ�]");
			}
			try {
				System.out.println("��ʾ��[û������]");
				log.info("* ˯�� " + waiteTime + " *");
				sleep(waiteTime);
			} catch (InterruptedException e) {
				log.info("* ������ " + e.getMessage() + " *");
				e.printStackTrace();
			}
		}*/

	}

	/**
	 * ���ϵͳֻ������һ��ʵ��
	 */
	private static void checkSimpleInstance() {
		try {
			tempSocket = new ServerSocket(socketPort);
		} catch (IOException ex) {
			log.info("�������ڱ�̨��������Ѿ��������벻Ҫ�ظ�������");
			// if (ex.getMessage().indexOf("Address already in use") > -1) {
			System.out
					.println("***************************************************************");
			System.out
					.println("**         �������ڱ�̨��������Ѿ��������벻Ҫ�ظ�������          **");
			System.out
					.println("***************************************************************");
			System.out.println("��Enter���˳�!");
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
