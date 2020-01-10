package io.helidon.mp.mybatisplus.entity;

import java.util.Date;

import lombok.Data;

@Data
public class Emp {

	private Integer empno;
	private String ename;
	private String job;
	private Integer mgr;
	private Date hiredate;
	private Double sal;
	private Double comm;
	private Integer deptno;
}
