package com.crawler.constant;

import java.util.HashMap;
import java.util.Map;

public class HeaderConstant {

	private static Map<String, String> header;

	public static Map<String, String> genomcan;

	static {
		header = new HashMap<String, String>();
		header.put("Accept", "application/json, text/plain, */*");
		header.put("Accept-Encoding", "gzip, deflate, sdch");
		header.put("Accept-Language", "zh-CN,zh;q=0.8");
		header.put("Content-Type","application/json; charset=UTF-8");
		header.put("Cache-Control", "max-age=0");
		header.put("Connection", "keep-alive");
		header.put("Upgrade-Insecure-Requests", "1");
		header.put("Referer","https://www.genomcan.cn/");
		header.put("Origin","https://www.genomcan.cn/");
		header.put("Host","www.genomcan.cn");
		header.put("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
		
		genomcan= new HashMap<String, String>();
		genomcan.put("Accept", "application/json, text/plain, */*");
		genomcan.put("Accept-Encoding", "gzip, deflate, br");
		genomcan.put("Accept-Language", "zh-CN,zh;q=0.8");
		genomcan.put("Connection", "keep-alive");
		genomcan.put("Content-Type", "application/json; charset=UTF-8");
		genomcan.put("Host","www.genomcan.cn");
		genomcan.put("Origin","https://www.genomcan.cn");
		genomcan.put("Referer","https://www.genomcan.cn/");
		genomcan.put("User-Agent",
				"Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.78 Safari/537.36");
	}

	public static void initCookie(String cookies) {
		header.put("Cookie", cookies);
	}
	
	

	public static Map<String, String> getHeaderPage() {
		return header;
	}

}
