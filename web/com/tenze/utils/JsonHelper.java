package com.tenze.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.ValueFilter;

/**
 * Json处理器<br>
 * 
 * @author TenzeTseng
 */
public class JsonHelper {

	private static Log log = LogFactory.getLog(JsonHelper.class);
	private static ValueFilter valueFilter = new ValueFilter(){

		@Override
		public Object process(Object arg0, String arg1, Object arg2) {
			if( arg2!=null && //
					((arg2.getClass().getName().equals("java.lang.Long")) //
							|| arg2.getClass().getName().equals("long")))
				return String.valueOf(arg2);
			return arg2;
		}
		
	};


	public static String toJSON(Object obj){
		if(obj==null)return "{}";
		return JSON.toJSONString(obj,valueFilter);
	}
}
