package io.helidon.mp.mybatisplus.facade.impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.mybatis.cdi.Transactional;

import io.helidon.mp.mybatisplus.common.exception.DBException;
import io.helidon.mp.mybatisplus.entity.Dept;
import io.helidon.mp.mybatisplus.entity.Emp;
import io.helidon.mp.mybatisplus.facade.GreetFacade;
import io.helidon.mp.mybatisplus.service.DeptService;
import io.helidon.mp.mybatisplus.service.EmpService;

@RequestScoped
@Transactional(rollbackFor = DBException.class)
public class GreetFacadeImpl implements GreetFacade {

	@Inject
	DeptService deptService;

	@Inject
	EmpService empService;

	@Override
	public List<Dept> selectDeptList() {

		return deptService.selectList(null);
	}

	@Override
	public List<Emp> selectEmpList() {

		return empService.selectList(null);
	}

}
