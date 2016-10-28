package com.NUH;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class testHttpClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://123.57.134.108/yxck/control/restful/getArticleByChannel");
		httpPost.addHeader("USERNAME", "admin");
		httpPost.addHeader("PASSWORD", "ofbiz");
		List<BasicNameValuePair> valuePairList = new ArrayList<BasicNameValuePair>() ;
		BasicNameValuePair valuePair = new BasicNameValuePair("page", "1");
		valuePairList.add(valuePair);
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(valuePairList));
			CloseableHttpResponse response = client.execute(httpPost);
			HttpEntity entity = response.getEntity();
			InputStream is = entity.getContent();
			System.out.println(EntityUtils.toString(entity));
			
			
			InputStreamReader isr = new InputStreamReader(is);
			char[] c = new char[1024];
			while(isr.ready()){
				System.out.println(new String(c,0,isr.read(c)));
			}
			
			is.close();
			//isr.close();
			Header[] header = response.getAllHeaders();
			System.out.println(header);
			client.close();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		messageService();
	}
	
	
	public static void messageService(){
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://114.247.227.253:8002/service-webapp/messgeService/sendSingleMessage.html");
		List<BasicNameValuePair> valuePairList = new ArrayList<BasicNameValuePair>() ;
		valuePairList.add(new BasicNameValuePair("templateCode", "SMS_BE_INVITED_REVIEW_CODE"));
		valuePairList.add(new BasicNameValuePair("systemId", "1004"));
		valuePairList.add(new BasicNameValuePair("sendType", "I"));
		valuePairList.add(new BasicNameValuePair("receiver", "18514532600"));
		valuePairList.add(new BasicNameValuePair("sendDateTime","2016-08-16 10:42:00"));
		valuePairList.add(new BasicNameValuePair("messageContent", "{'partyName':'万变为','linkUrl':'baidu.com'}"));
		String signature = sign(valuePairList, "yxck20160719");;
		valuePairList.add(new BasicNameValuePair("signature",signature));
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(valuePairList,HTTP.UTF_8));
			CloseableHttpResponse response = client.execute(httpPost);
			System.out.println(response.getStatusLine().getStatusCode());
			HttpEntity entity = response.getEntity();
			
			System.out.println(EntityUtils.toString(entity));
			client.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String sign(List<BasicNameValuePair> params, String secret) {
		return sign(params, null, secret);
	}
	
	
	/** 
	 * @param params 
	 * @param ignoreParamNames 
	 * @param secret 
	 * @return 
	 */
	public static String sign(List<BasicNameValuePair> params,List<String> ignoreParamNames,String secret) {
		try {
			StringBuilder sb = new StringBuilder();
			List<String> paramNames = new ArrayList<String>();
			Map<String,String> paramValues =new HashMap<String, String>();
			for(BasicNameValuePair param:params){
				paramNames.add(param.getName());
				paramValues.put(param.getName(), param.getValue());
			}

			if (ignoreParamNames != null && ignoreParamNames.size() > 0) {
				for (String ignoreParamName : ignoreParamNames) {
					paramNames.remove(ignoreParamName);
				}
			}
			Collections.sort(paramNames);
			sb.append(secret);
			for (String paramName : paramNames) {
				sb.append(paramName).append(paramValues.get(paramName));
			}
			sb.append(secret);
			byte[] md5Digest = getMD5Digest(sb.toString());
			String sign = byte2hex(md5Digest);
			return sign;
		} catch (IOException e) {
			throw new RuntimeException("加密签名计算错误", e);
		}

	}
	
	
	
	
	

	public static String utf8Encoding(String value, String sourceCharsetName) {
		try {
			return new String(value.getBytes(sourceCharsetName), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new IllegalArgumentException(e);
		}
	}

	@SuppressWarnings("unused")
	private static byte[] getSHA1Digest(String data) throws IOException {
		byte[] bytes = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			bytes = md.digest(data.getBytes("UTF-8"));
		} catch (GeneralSecurityException gse) {
			throw new IOException(gse);
		}
		return bytes;
	}

	private static byte[] getMD5Digest(String data) throws IOException {
		byte[] bytes = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			bytes = md.digest(data.getBytes("UTF-8"));
		} catch (GeneralSecurityException gse) {
			throw new IOException(gse);
		}
		return bytes;
	}

	private static String byte2hex(byte[] bytes) {
		StringBuilder sign = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			String hex = Integer.toHexString(bytes[i] & 0xFF);
			if (hex.length() == 1) {
				sign.append("0");
			}
			sign.append(hex.toUpperCase());
		}
		return sign.toString();
	}
}

