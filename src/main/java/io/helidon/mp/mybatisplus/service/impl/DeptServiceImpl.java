package io.helidon.mp.mybatisplus.service.impl;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import com.baomidou.mybatisplus.core.conditions.Wrapper;

import io.helidon.mp.mybatisplus.entity.Dept;
import io.helidon.mp.mybatisplus.mapper.DeptMapper;
import io.helidon.mp.mybatisplus.service.DeptService;

@Dependent
public class DeptServiceImpl implements DeptService {

	@Inject
	DeptMapper deptMapper;

	@Override
	public List<Dept> selectList(Wrapper<Dept> queryWrapper) {

		return deptMapper.selectList(queryWrapper);
	}

}
