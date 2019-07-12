package com.springboot.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="OA_ID_JOB")
public class Job implements Serializable{

	private static final long serialVersionUID = 456497377750274376L;

	@Id
	//工作代码
	private int code;
	private String name;//名称
	private String remark;//职位说明
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
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
