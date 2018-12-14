package com.tenze.background.common.core.service;

import java.util.List;
import java.util.Map;

import com.tenze.background.common.entity.BaseEntity;
import com.tenze.background.common.page.PageBean;
import com.tenze.background.common.page.PageParam;



/**
 * 基类Service接口
 * 
 * @author Hill
 * 
 * @param <T>
 */
public interface BaseService<T extends BaseEntity> {

	/**
	 * 根据ID查找记录.
	 * 
	 * @param id
	 *            .
	 * @return entity .
	 */
	T getById(long id);
	
	/**
	 * 分页查询 .
	 * 
	 * @param pageParam
	 *            分页参数.
	 * @param paramMap
	 *            业务条件查询参数.
	 * @return
	 */
	PageBean listPage(PageParam pageParam, Map<String, Object> paramMap);

	PageBean listPage(PageParam pageParam, Map<String, Object> paramMap, String sqlId);

	/**
	 * 根据条件查询 listBy: <br/>
	 * 
	 * @param paramMap
	 * @return 返回集合
	 */
	List<T> listBy(Map<String, Object> paramMap);

	List<Object> listBy(Map<String, Object> paramMap, String sqlId);

	/**
	 * 根据条件查询 listBy: <br/>
	 * 
	 * @param paramMap
	 * @return 返回实体
	 */
	T getBy(Map<String, Object> paramMap);

	Object getBy(Map<String, Object> paramMap, String sqlId);

	/**
	 * 根据序列名称获取下一个值
	 * 
	 * @return
	 */
	String getSeqNextValue(String seqName);
	
	/**
	 * 保存对象
	 * @param t
	 * @return
	 */
	long save(T t);
	
	/**
	 * 删除多个
	 * @param ids
	 */
	void deleteByIds(List<Long> ids);
	
	void deleteById(Long id);

}
