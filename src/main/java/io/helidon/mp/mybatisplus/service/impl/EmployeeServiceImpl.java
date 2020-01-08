package io.helidon.mp.mybatisplus.service.impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import io.helidon.mp.mybatisplus.common.exception.DBException;
import io.helidon.mp.mybatisplus.entity.Employee;
import io.helidon.mp.mybatisplus.entity.EmployeeExample;
import io.helidon.mp.mybatisplus.mapper.EmployeeMapper;
import io.helidon.mp.mybatisplus.service.EmployeeService;

@RequestScoped
public class EmployeeServiceImpl implements EmployeeService {

	@Inject
	EmployeeMapper employeeMapper;

	public EmployeeServiceImpl() {

	}

	@Override
	public void setEmployeeMapper(SqlSession sqlSession) {
		this.employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
	}

	@Override
	public long countByExample(EmployeeExample example) {

		return employeeMapper.countByExample(new EmployeeExample());
	}

	@Override
	public int deleteByExample(EmployeeExample example) {

		return 0;
	}

	@Override
	public int insert(Employee record) {

		try {
			int i = employeeMapper.insert(record);
			return i;
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

	@Override
	public int insertSelective(Employee record) {

		return 0;
	}

	@Override
	public List<Employee> selectByExample(EmployeeExample example) {

		return employeeMapper.selectByExample(new EmployeeExample());
	}

	@Override
	public int updateByExampleSelective(Employee record, EmployeeExample example) {

		return 0;
	}

	@Override
	public int updateByExample(Employee record, EmployeeExample example) {

		return 0;
	}

}
