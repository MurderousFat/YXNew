package com.tenze.utils.helper;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.BeforeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.tenze.utils.BaseDto;
import com.tenze.utils.Dto;

/**
 * Json处理器<br>
 * 
 * @author hubo
 * @since 2009-07-07
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

	/**
	 * 将不含日期时间格式的Java对象系列化为Json资料格式
	 * 
	 * @param pObject
	 *            传入的Java对象
	 * @return
	 */
	public static final String encodeObject2Json(Object pObject) {
		String jsonString = "[]";
		if (pObject==null) {
			// log.warn("传入的Java对象为空,不能将其序列化为Json资料格式.请检查!");
		} else {
			jsonString = JSON.toJSONString(pObject, valueFilter);
		}
		if (log.isInfoEnabled()) {
			log.info("序列化后的JSON资料输出:\n" + jsonString);
		}
		return jsonString;
	}

	
	/**
	 * 将含有日期时间格式的Java对象系列化为Json资料格式<br>
	 * Json-Lib在处理日期时间格式是需要实现其JsonValueProcessor接口,所以在这里提供一个重载的方法对含有<br>
	 * 日期时间格式的Java对象进行序列化
	 * 
	 * @param pObject
	 *            传入的Java对象
	 * @return
	 */
	public static final String encodeObject2Json(Object pObject,
			String pFormatString) {
		
		String jsonString = "[]";
		if (pObject==null) {
			// log.warn("传入的Java对象为空,不能将其序列化为Json资料格式.请检查!");
		} else {
			jsonString = JSON.toJSONString(pObject, valueFilter);
		}
		if (log.isInfoEnabled()) {
			log.info("序列化后的JSON资料输出:\n" + jsonString);
		}
		return jsonString;
	}

	/**
	 * 直接将List转为分页所需要的Json资料格式
	 * 
	 * @param list
	 *            需要编码的List对象
	 * @param totalCount
	 *            记录总数
	 * @param pGxUtils
	 *            时间日期格式化,传null则表明List不包含日期时间属性
	 */
	public static final String encodeList2PageJson(List list,
			Integer totalCount, String dataFormat) {
		return encodeList2PageJson(list, totalCount, dataFormat, "total",
				"items");
	}

	/**
	 * 直接将List转为分页所需要的Json资料格式
	 * 
	 * @param list
	 *            需要编码的List对象
	 * @param totalCount
	 *            记录总数
	 * @param pGxUtils
	 *            时间日期格式化,传null则表明List不包含日期时间属性
	 * @param totalField
	 *            总记录数字段名称
	 * @param listField
	 *            列表字段名称
	 */
	public static final String encodeList2PageJson(List list,
			Integer totalCount, String dataFormat, String totalField,
			String listField) {
		String subJsonString = "";
		if (dataFormat==null || dataFormat.trim().length()==0) {
			subJsonString = encodeObject2Json(list);
		} else {
			subJsonString = encodeObject2Json(list, dataFormat);
		}
		String jsonString = "{\"" + totalField + "\":" + totalCount + ", \""
				+ listField + "\":" + subJsonString + "}";
		return jsonString;
	}

	public static final String encodeList2PageJson(List list,
			Integer totalCount, Integer page, Integer pageSize,
			String dataFormat, String totalField, String listField,
			String pageField, String pageSizeField) {
		String subJsonString = "";
		if (dataFormat==null || dataFormat.trim().length()==0) {
			subJsonString = encodeObject2Json(list);
		} else {
			subJsonString = encodeObject2Json(list, dataFormat);
		}
		String jsonString = "{\"" + pageSizeField + "\":" + pageSize + ", \""
				+ pageField + "\":" + page + "," + totalField + "\":"
				+ totalCount + ", \"" + listField + "\":" + subJsonString + "}";
		return jsonString;
	}

	/**
	 * 将数据系列化为表单数据填充所需的Json格式
	 * 
	 * @param pObject
	 *            待系列化的对象
	 * @param pFormatString
	 *            日期时间格式化,如果为null则认为没有日期时间型字段
	 * @return
	 */
	public static String encodeDto2FormLoadJson(Dto pDto, String pFormatString) {
		String jsonString = "";
		String sunJsonString = "";
		if (pFormatString==null || pFormatString.trim().length()==0) {
			sunJsonString = encodeObject2Json(pDto);
		} else {
			sunJsonString = encodeObject2Json(pDto, pFormatString);
		}
		jsonString = "{success:"
				+ (StringUtils.isEmpty(pDto.getAsString("success")) ? "true" : pDto
						.getAsString("success")) + ",data:" + sunJsonString
				+ "}";
		if (log.isInfoEnabled()) {
			log.info("序列化后的JSON资料输出:\n" + jsonString);
		}
		return jsonString;
	}

	/**
	 * 将单一Json对象解析为DTOJava对象
	 * 
	 * @param jsonString
	 *            简单的Json对象
	 * @return dto
	 */
	public static Dto parseSingleJson2Dto(String jsonString) {
		Dto dto = new BaseDto();
		if (StringUtils.isEmpty(jsonString)) {
			return dto;
		}
		dto = (BaseDto) JSON.parseObject(jsonString, BaseDto.class);
		return dto;
	}

	/**
	 * 将复杂Json资料格式转换为List对象
	 * 
	 * @param jsonString
	 *            复杂Json对象,格式必须符合如下契约<br>
	 *            {"1":{"name":"托尼.贾","age":"27"},
	 *            "2":{"name":"甄子丹","age":"72"}}
	 * @return List
	 */
	public static List parseJson2List(String jsonString) {
		return JSON.parseArray(jsonString);
	}

	/**
	 * 将一个Grid的所有记录组成的字符串，构造为一个Dto的列表
	 * 
	 * @param recordStr
	 * @return
	 */
	public static List<Dto> castGridRecordToDto(String recordStr) {
		String[] newDatas = null;
		List<Dto> rtnDto = new ArrayList<Dto>();
		Dto dto = null;
		if (StringUtils.isNotEmpty(recordStr)) {
			recordStr = recordStr.substring(1, recordStr.length() - 1);
			newDatas = recordStr.split("},");
			for (int i = 0; i < newDatas.length; i++) {
				if (i != newDatas.length - 1) {
					newDatas[i] += "}";
				}
				dto = JsonHelper.parseSingleJson2Dto(newDatas[i]);
				rtnDto.add(dto);
			}
		}
		return rtnDto;
	}
	
	/**
	 * 将含有日期时间格式的Java对象系列化为Json资料格式<br>
	 * Json-Lib在处理日期时间格式是需要实现其JsonValueProcessor接口,所以在这里提供一个重载的方法对含有<br>
	 * 日期时间格式的Java对象进行序列化
	 * 
	 * @param pObject
	 *            传入的Java对象
	 * @return
	 */
	public static final String encodeObject2Json2(Object pObject,
			String pFormatString) {
		String jsonString = "[]";
		if (pObject!=null) {
			// log.warn("传入的Java对象为空,不能将其序列化为Json资料格式.请检查!");
		} else {
			jsonString = JSON.toJSONStringWithDateFormat(pObject, pFormatString, SerializerFeature.WriteNonStringKeyAsString);
		}
		return jsonString;
	}
}
