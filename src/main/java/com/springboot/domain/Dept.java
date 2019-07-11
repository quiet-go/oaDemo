package com.springboot.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="OA_ID_DEPT")
public class Dept implements Serializable{

	private static final long serialVersionUID = 678100638005497362L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	/*
	 * 也可以使用@Column修饰字段，使该属性与数据表中的字段名对应
	 * */
	private Long id;
	private String name;
	private String remark;//备注

	@ManyToOne(fetch=FetchType.LAZY, targetEntity=User.class)
	@JoinColumn(name="modifier", referencedColumnName="user_id",
	foreignKey=@ForeignKey(name="dept_modifier"))//更改外键约束名
	private User modifier;//修改人

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;//修改时间

	@ManyToOne(fetch=FetchType.LAZY, targetEntity=User.class)
	@JoinColumn(name="creater", referencedColumnName="user_id",
	foreignKey=@ForeignKey(name="dept_creater"))//更改外键约束名
	private User creater;//创建人

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;//创建时间

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public User getModifier() {
		return modifier;
	}

	public void setModifier(User modifier) {
		this.modifier = modifier;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public User getCreater() {
		return creater;
	}

	public void setCreater(User creater) {
		this.creater = creater;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
