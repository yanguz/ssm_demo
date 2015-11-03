/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.demo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service基类
 * 
 * @author ThinkGem
 * @version 2014-05-16
 */

public abstract class CrudService<D extends CrudDao<T>, T extends DataEntity<T>> extends BaseService {


	/**
	 * 持久层对象
	 */
	@Autowired
	protected D dao;

	/**
	 * 获取单条记录
	 * 
	 * @param entity
	 * @return
	 */
	public T get(T entity) {
		return dao.get(entity);
	}

	/**
	 * 获取多条记录
	 * 
	 * @param entity
	 * @return
	 */
	public List<T> getList(T entity) {
		return dao.getList(entity);
	}

	/**
	 * 插入数据
	 * 
	 * @param entity
	 * @return
	 */
	public int insert(T entity) {
		if (entity.getId() == null) {
			entity.setId(System.nanoTime());
		}
		entity.setCreateTime(new Date());
		entity.setUpdateTime(new Date());
		return dao.insert(entity);
	}

	/**
	 * 更新数据
	 * 
	 * @param entity
	 * @return
	 */
	public int update(T entity) {
		entity.setUpdateTime(new Date());
		return dao.update(entity);
	}

	/**
	 * 保存
	 * 
	 * @param entity
	 * @return
	 */
	public int save(T entity) {
		if (entity.getId() != null) {
			return update(entity);
		} else {
			return insert(entity);
		}
	}

	/**
	 * 删除数据（一般为逻辑删除，更新del_flag字段为1）
	 * 
	 * @param entity
	 * @return
	 */
	@Transactional(readOnly = false)
	public int delete(T entity) {
		return dao.delete(entity);
	}

}
