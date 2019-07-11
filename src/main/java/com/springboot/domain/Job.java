package com.springboot.domain;

import javax.persistence.*;

@Entity
@Table(name="OA_ID_JOB")
public class Job {

	@Id
	private String job_id;

	//编码
	private int code;
}
