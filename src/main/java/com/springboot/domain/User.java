package com.springboot.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	@JoinColumn(name="dept_id", referencedColumnName="dept_id",
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
	//referencedColumnName是user_id的原因是上面定义的User类的id是user_id
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
	@ManyToMany(fetch=FetchType.LAZY, targetEntity=Role.class)
	@JoinTable(name = "PersonANDFlight", joinColumns = {@JoinColumn(name = "user_id")},
		inverseJoinColumns = {@JoinColumn(name = "role_id")})
	private Set<Role> roles = new HashSet<Role>();

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public short getSex() {
		return sex;
	}

	public void setSex(short sex) {
		this.sex = sex;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQqNum() {
		return qqNum;
	}

	public void setQqNum(String qqNum) {
		this.qqNum = qqNum;
	}

	public Short getQuestion() {
		return question;
	}

	public void setQuestion(Short question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
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

	public User getChecker() {
		return checker;
	}

	public void setChecker(User checker) {
		this.checker = checker;
	}

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
