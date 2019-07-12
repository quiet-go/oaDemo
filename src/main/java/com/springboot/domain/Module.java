package com.springboot.domain;

import java.io.Serializable;

import javax.persistence.Id;

/*
 * 模块实体类
 * @author dashuai
 * */
public class Module implements Serializable{

	private static final Long serialVersionUID = 5139796285142133024L;

	@Id
	private String code;//模块代码
	private String name;
	private String remark;//模块描述
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
