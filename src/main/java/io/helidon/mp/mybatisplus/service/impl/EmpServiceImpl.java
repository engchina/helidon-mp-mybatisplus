package io.helidon.mp.mybatisplus.service.impl;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import io.helidon.mp.mybatisplus.common.extension.service.impl.MyServiceImpl;
import io.helidon.mp.mybatisplus.entity.Emp;
import io.helidon.mp.mybatisplus.mapper.EmpMapper;
import io.helidon.mp.mybatisplus.service.EmpService;
import io.helidon.mp.mybatisplus.vo.EmpVO;

@Dependent
public class EmpServiceImpl extends MyServiceImpl<EmpMapper, Emp> implements EmpService {

	@Inject
	EmpMapper empMapper;

	@Override
	public List<EmpVO> getEmpVOList() {

		return empMapper.getEmpVOList();
	}

}
