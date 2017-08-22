package com.pm.common.base.utils.uuid;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * UUID生成
 * @author xzj
 *
 */
public class UUIDGenerator {

	public UUIDGenerator() {
	}

	private final static Logger logger = LoggerFactory.getLogger(UUIDGenerator.class);
	
	public static String getUUID() {
		String s = UUID.randomUUID().toString();
		return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
	}
	

	
	 /**
     * 根据本机IP生成head
     * @return
     * @throws UnknownHostException
     */
	public static String getSequenceHeadByMachineIP() throws UnknownHostException {
		InetAddress addr = InetAddress.getLocalHost();
		String ip = addr.getHostAddress().toString();
		StringBuffer head = new StringBuffer(ip.replaceAll("\\.", "_"));
		while (head.length() < 16) {
			head.append("_");
		}
		// head.append("$");
		return head.toString();
	}

}
