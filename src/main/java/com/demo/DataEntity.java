/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.demo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 数据Entity类
 * 
 */
public abstract class DataEntity<T> extends BaseEntity<T> {

	private static final long serialVersionUID = 1L;
	protected Date createTime; // 创建日期
	protected Date updateTime; // 更新日期

	public DataEntity() {
		super();
	}

	public DataEntity(Long id) {
		super(id);
	}

	/**
	 * 插入之前执行方法，需要手动调用
	 */
	@Override
	public void preInsert() {
		this.updateTime = new Date();
		this.createTime = this.updateTime;
	}

	/**
	 * 更新之前执行方法，需要手动调用
	 */
	@Override
	public void preUpdate() {
		this.updateTime = new Date();
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createDate) {
		this.createTime = createDate;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateDate) {
		this.updateTime = updateDate;
	}

}
