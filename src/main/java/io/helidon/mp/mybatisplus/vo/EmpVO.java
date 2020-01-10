package io.helidon.mp.mybatisplus.vo;

import io.helidon.mp.mybatisplus.entity.Emp;

public class EmpVO extends Emp {

	private String dname;

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	@Override
	public String toString() {
		return "EmpVO [dname=" + dname + ", toString()=" + super.toString() + "]";
	}

}
