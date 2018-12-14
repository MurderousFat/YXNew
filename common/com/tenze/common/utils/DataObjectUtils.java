package com.tenze.common.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;

import com.tenze.utils.BaseDto;
import com.tenze.utils.Dto;

/**
 * MAP 对象到 BEAN 转换用
 * 
 * @author Administrator
 * 
 */
public class DataObjectUtils {

	public DataObjectUtils() {
	}

	public static Date numberToDate(String string) throws Exception {
		SimpleDateFormat simpleDateFormat;
		if (string == null)
			return null;
		simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.parse(string);

	}

	public static Dto object2Dto(Object object) {
		Map<String, Object> map = object2Map(object);
		Dto dto = new BaseDto();
		dto.putAll(map);
		return dto;
	}

	/**
	 * 将一个JavaBean对象转换为map
	 * 
	 * @param object
	 * @return
	 */
	public static Map<String, Object> object2Map(Object object) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Field> fieldList = ReflectionUtils.getDeclaredFieldList(object);
		String name = "";
		for (Field field : fieldList) {
			name = field.getName();
			map.put(field.getName(),
					ReflectionUtils.getFieldValue(object, name));
		}
		return map;
	}

	public static void mapToObject(Object object, Map map) {
		try {
			String fieldName;
			Object o;
			PropertyDescriptor desc = null;
			Class cl = null;
			String clStr = null;
			Long time = 0L;
			Calendar calendar = null;
			String v = null;

			for (Iterator iterator = map.keySet().iterator(); iterator
					.hasNext();) {
				fieldName = (String) iterator.next();
				o = getNestedProperty(object, fieldName);
				desc = PropertyUtils.getPropertyDescriptor(o, fieldName);
				if (desc != null) {
					cl = desc.getPropertyType();
					clStr = cl.getName();
					if (java.util.Date.class.isAssignableFrom(cl)) {
						time = convert(map.get(fieldName));
						if (time != null)
							BeanUtils.setProperty(o, fieldName,
									new Date(time.longValue()));
					} else if (java.util.Calendar.class.isAssignableFrom(cl)) {
						time = convert(map.get(fieldName));
						calendar = Calendar.getInstance();
						if (time != null) {
							calendar.setTimeInMillis(time.longValue());
							BeanUtils.setProperty(o, fieldName, calendar);
						}
					} else if (java.math.BigDecimal.class.isAssignableFrom(cl)) {
						v = (String) map.get(fieldName);
						// 2013-07-23
						// 修改，当值为空时，数字型字段默认为0
						// hubo
						if (!StringUtils.isEmpty(v))
							v = "0";
						BeanUtils.setProperty(o, fieldName, v);
					}else if("long".equals(clStr)
							|| "java.lang.Long".equals(clStr)){
						if( map.get(fieldName)!=null && !"".equals(map.get(fieldName).toString().trim())){
							BeanUtils.setProperty(o, fieldName, Long.valueOf(map.get(fieldName)+""));
						}
					} else if ("java.lang.String".equals(clStr)
							|| "java.lang.Double".equals(clStr)
							|| "java.lang.Integer".equals(clStr)
							|| "java.lang.Float".equals(clStr)
							|| "java.lang.Byte".equals(clStr)
							) {
						v = null == map.get(fieldName) ? "" : map
								.get(fieldName).toString().trim();
						v = v.replace("'", "\\'");
						BeanUtils.setProperty(o, fieldName, v);
					} else if("java.lang.Boolean".equals(clStr)){
						v = null == map.get(fieldName)? "false":buildBoolean(String.valueOf(map.get(fieldName)));
						BeanUtils.setProperty(o, fieldName, Boolean.valueOf(v));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private static String buildBoolean(String _b){
		if("1".equals(_b))return "true";
		if("0".equals(_b))return "false";
		if("on".equals(_b.toLowerCase()))return "true";
		if("true".equals(_b.toLowerCase()))return "true";
		if("false".equals(_b.toLowerCase()))return "false";
		return "false";
	}

	private static Object getNestedProperty(Object o, String propertyDesc)
			throws NoSuchMethodException, InvocationTargetException,
			IllegalAccessException {
		Object value = o;
		String properties[] = StringUtils.split(propertyDesc, ".");
		String property = null;
		for (int i = 0; i < properties.length; i++) {
			if (properties.length == 1)
				break;
			property = properties[i];
			value = PropertyUtils.getProperty(value, property);
			if (i + 2 == properties.length)
				break;
		}

		return value;
	}

	private static Long convert(Object arg1) {
		String p;
		p = (String) arg1;
		if (p == null || p.trim().length() == 0)
			return null;

		if (p.indexOf("年") != -1) {
			p = getDateString("yyyyMMdd", new Date()).substring(0, 2)
					+ p.replaceAll("年", "-").replaceAll("月", "-")
							.replaceAll("日", "");
		}

		SimpleDateFormat df ;
		if(p.contains(":")){
			df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}else{
			df = new SimpleDateFormat("yyyy-MM-dd");
		}
		try {
			return new Long(df.parse(p.trim()).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return null;
		}

	}

	/**
	 * 获取某个日期的开始时间点
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateStart(Date date) {
		return getDateString("yyyy-MM-dd", date).concat(" 00:00:00");
	}
	
	/**
	 * 返回传入时间的format格式的字符串
	 * 
	 * @param format
	 *            格式字符串,如果当前时间为2009年9月29日12点30分，则yyyyMMddHHmm格式后为-->200909291230
	 *            ,yyyyMM格式后为-->200909,yyMM-->0909
	 * @param c
	 *            Date对象
	 * @return 格式字符串
	 */
	public static String getDateString(String format, Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(d);
	}
	
}
