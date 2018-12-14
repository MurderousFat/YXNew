package com.tenze.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

/**
 * 普通工具类
 * @author Administrator
 *
 */
public class TenzeUtils {

	public static List<Long> str2IdList(String payload){
		String[] _ids = payload.split(",");
		List<Long> ids = new ArrayList<Long>();
		for(int i=0;i<_ids.length;i++){
			ids.add(Long.valueOf(_ids[i]));
		}
		return ids;
	}
	
	/**
	 * 返回传入时间的format格式的字符串
	 * 
	 * @param format
	 *            格式字符串,如果当前时间为2009年9月29日12点30分，则yyyyMMddHHmm格式后为-->200909291230
	 *            ,yyyyMM格式后为-->200909,yyMM-->0909
	 * @param c
	 *            Calendar对象
	 * @return 格式字符串
	 */
	public static String getDateString(String format, Calendar c) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(c.getTime());
	}
	
	/**
	 * 返回传入时间的format格式的字符串
	 * 
	 * @param format
	 *            格式字符串,如果当前时间为2009年9月29日12点30分，则yyyyMMddHHmm格式后为-->200909291230
	 *            ,yyyyMM格式后为-->200909,yyMM-->0909
	 * @param c
	 *            Calendar对象
	 * @return 格式字符串
	 */
	public static String getDateString(String format, Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
}
