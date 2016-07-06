package com.jon.web.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTool {
	/**
	 * 获取当前时间Date
	 * @return
	 */
	public static Date getNow(){
		return new Date();
	}
	/**
	 * 获取当前时间的字符串
	 * 
	 * @param dateFormatString 时间格式字符串 默认格式：yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getNowString(String dateFormatString){
		SimpleDateFormat df =  null;
		if(dateFormatString == null || "".equals(dateFormatString)){
			df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		}else{
			df = new SimpleDateFormat(dateFormatString);//设置日期格式
		}
		return df.format(new Date());// new Date()为获取当前系统时间
	}
	
	
	/**
	 * 创建Date，
	 * 通过Calendar
	 * @param YEAR
	 * @param month
	 * @param DATE
	 * @return
	 */
	public static Date createDate(int YEAR,int month,int DATE){
		Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
		c.set(YEAR, month, DATE);
		return c.getTime();
	}
	/**
	 * 创建Calendar
	 * @param year
	 * @param month
	 * @param date
	 * @return
	 */
	public static Calendar getCalendar(int year,int month,int date){
		Calendar c = Calendar.getInstance();
		c.set(year, month, date);
		return c;
	}
	
	public static int getYear(){
		Date d = new Date();
		d.getYear();
		return d.getYear()+1900;
	}
	
	
	public static Date getDate(int year,int month,int date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = null;
		try {
			d = sdf.parse(year+"-"+month+"-"+date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
	
	/**
	 * 月份差值
	 * 此方法算法不正确
	 * date1 - date2
	 * 务必确保date1的日期在date2之后
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long subMonth(Date date1,Date date2){
		
		long subNum = date1.getTime() - date2.getTime();
		long day=subNum/(24*60*60*1000);
		//long ye
		long month = day/30;
		long x = month/30;
		return month - x+1;
	}
	
	/**
	 *  月份差值
	 * date1 - date2
	 * 务必确保date1的日期在date2之后
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long subMonth(Calendar date1,Calendar date2){
		int y1 = date1.get(Calendar.YEAR) ,y2 = date2.get(Calendar.YEAR);
		int m1 = date1.get(Calendar.MONTH),m2 = date2.get(Calendar.MONTH);
		int r = (y1-y2)*12 + (m1-m2);
		return r;
	}
	
	
	public static float fromMonthToYear(long month){
		long x = month/12;
		long y = month%12;
		return Float.parseFloat(x+"."+y);
	}
	
	
	/**
	 * 年龄差
	 * 务必确保date1的日期在date2之后
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long subYear(Calendar date1,Calendar date2){
		int y1 = date1.get(Calendar.YEAR) ,y2 = date2.get(Calendar.YEAR);
		int m1 = date1.get(Calendar.MONTH),m2 = date2.get(Calendar.MONTH);
		int r = (y1-y2);
		return r;
	}
	
	/**
	 * 年龄差
	 * 务必确保date1的日期在date2之后
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int subYear(Date date1,Date date2){
		Calendar c1 = Calendar.getInstance(),c2 =  Calendar.getInstance();
		c1.setTime(date1); c2.setTime(date2);
		int y1 = c1.get(Calendar.YEAR) ,y2 = c2.get(Calendar.YEAR);
		int m1 = c1.get(Calendar.MONTH),m2 = c2.get(Calendar.MONTH);
		int r = (y1-y2);
		return r;
	}
	
}
