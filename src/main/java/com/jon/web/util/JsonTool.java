package com.jon.web.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;



public class JsonTool<T> {
	/**
	 * Json转换成对象
	 * 需要泛型
	 * @param sjon 
	 * @param classOfT 类型
	 * @return
	 */
	public T jsonToEntity(String sjon,Class<T> classOfT){
		Gson gson = new Gson();
		T obj = gson.fromJson(sjon, classOfT);
		return obj;  
	}
	/**
	 * Json转换成对象列表
	 * 需要泛型
	 * @param sjon
	 * @return
	 */
	public List<T> jsonToEntityList(String sjon ){
		Gson gson = new Gson();
		List<T> obj = gson.fromJson(sjon,new TypeToken<List<T>>(){}.getType());
		return obj;  
	}
	
	public static Map<String, Object> data=new HashMap<String, Object>();
	
	
	/**
	 * 
	 * @param obj
	 * @throws IOException
	 */
	public static void toJson(Object obj ,HttpServletResponse response ) throws IOException  {
		String result = gson(obj);
		System.out.println(result);
		//HttpServletResponse response = WebUtil.getResponse();
		
		//这个是设置响应给客户端的文档格式
		response.setContentType("application/json;charset=UTF-8");
		//这个是消除客户端的缓存
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setHeader("Access-Control-Allow-Origin","*");
			PrintWriter out = response.getWriter();
			
			out.print(result);
			out.flush();
			out.close();
			data.clear();
		 
	}
	public static String gson(Object obj) {
		Gson gson = new Gson();
		String result = gson.toJson(obj);
		
		return chinaToUnicode(result);
	}
	
	

	public static void putDataToJson(int total,List lst ,HttpServletResponse response ) throws IOException
	{
		JSONObject json = new JSONObject();
		json.accumulate("total", total);
		json.accumulate("rows", lst);
		//HttpServletResponse response = WebUtil.getResponse();
		
		response.setContentType("application/json; charset=utf-8");
		response.setHeader("cache-control", "no-cache"); 
		PrintWriter out = response.getWriter();
		out.print(json.toString());
		out.flush();
		out.close();
		
	}
	/**
	 * 把中文转成Unicode码
	 * 
	 * @param str
	 * @return
	 */
	public static  String chinaToUnicode(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			int chr1 = (char) str.charAt(i);
			if (chr1 >= 19968 && chr1 <= 171941) {// 汉字范围 \u4e00-\u9fa5 (中文)
				result += "\\u" + Integer.toHexString(chr1);
			} else {
				result += str.charAt(i);
			}
		}
		return result;
	}
	
	/**
	 * 把Unicode码转成中文
	 * 
	 * @param s
	 * @return
	 */
	public static String unicode2String(String unicodeStr){
	    StringBuffer sb = new StringBuffer();
	    String str[] = unicodeStr.toUpperCase().split("\\\\U");
	    for(int i=0;i<str.length;i++){
	      if(str[i].equals("")) continue;
	      char c = (char)Integer.parseInt(str[i].trim(),16);
	      sb.append(c);
	    }
	    return sb.toString();
	  }
}
