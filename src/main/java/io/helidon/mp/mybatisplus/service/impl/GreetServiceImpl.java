package io.helidon.mp.mybatisplus.service.impl;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import io.helidon.mp.mybatisplus.mapper.GreetMapper;
import io.helidon.mp.mybatisplus.service.GreetService;
import io.helidon.mp.mybatisplus.vo.EmpVO;

@Dependent
public class GreetServiceImpl implements GreetService {

	@Inject
	GreetMapper greetMapper;

	@Override
	public List<EmpVO> getEmpVOList() {

		return greetMapper.getEmpVOList();
	}

}
