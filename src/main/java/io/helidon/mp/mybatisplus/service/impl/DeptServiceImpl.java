package io.helidon.mp.mybatisplus.service.impl;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import io.helidon.mp.mybatisplus.common.extension.service.impl.MyServiceImpl;
import io.helidon.mp.mybatisplus.entity.Dept;
import io.helidon.mp.mybatisplus.mapper.DeptMapper;
import io.helidon.mp.mybatisplus.service.DeptService;

@Dependent
public class DeptServiceImpl extends MyServiceImpl<DeptMapper, Dept> implements DeptService {

	@Inject
	DeptMapper deptMapper;

}
