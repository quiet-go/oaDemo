package com.springboot.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="OA_ID_USER",
		indexes={@Index(columnList="name", name="IDX_USER_NAME")})
//@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class User {

	@Id
	private String user_id;

	//密码，使用MD5加密
	private String passWord;
	private String name;
	//性别，1:male,2:female
	private short sex = 1;
	//与部门之间存在多对一的关系
	@ManyToOne(fetch=FetchType.LAZY, targetEntity=Dept.class)
	@JoinColumn(name="dept_id", referencedColumnName="id",
			foreignKey=@ForeignKey(name="user_dept"))
	private Dept dept;

	//与职位之间存在多对一的关系
	@ManyToOne(fetch=FetchType.LAZY, targetEntity=Job.class)
	@JoinColumn(name="job_code", referencedColumnName="code",
			foreignKey=@ForeignKey(name="user_job"))
	private Job job;
	//邮箱
	private String email;
	//电话号码
	private String tel;
	//手机号码
	private String phone;
	//QQ号码
	private String qqNum;
	//问题编号
	private Short question;
	//回答结果
	private String answer;
	//状态：0新建，1审核，2不通过审核，3冻结
	private Short status = 0;
	//用户与用户创建人之间存在多对一的关系
	@ManyToOne(fetch=FetchType.LAZY, targetEntity=User.class)
	@JoinColumn(name="creater", referencedColumnName="user_id",
			foreignKey=@ForeignKey(name="user_creater"))
	private User creater;
	//创建时间
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	//用户与用户修改人之间存在多对一的关系
	@ManyToOne(fetch=FetchType.LAZY, targetEntity=User.class)
	@JoinColumn(name="modifier", referencedColumnName="user_id",
			foreignKey=@ForeignKey(name="user_modifier"))
	private User modifier;
	//修改时间
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;

	//用户与部门审核人之间存在多对一的关系
	@ManyToOne(fetch=FetchType.LAZY, targetEntity=User.class)
	@JoinColumn(name="checker", referencedColumnName="user_id",
			foreignKey=@ForeignKey(name="user_checker"))
	private User checker;
	//审核时间
	@Temporal(TemporalType.TIMESTAMP)
	private Date checkDate;

	//用户与角色之间存在多对多的关系
}
