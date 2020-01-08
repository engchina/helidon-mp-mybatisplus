package io.helidon.mp.mybatisplus.facade.impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.mybatis.cdi.Transactional;

import io.helidon.mp.mybatisplus.common.exception.DBException;
import io.helidon.mp.mybatisplus.entity.Employee;
import io.helidon.mp.mybatisplus.entity.EmployeeExample;
import io.helidon.mp.mybatisplus.facade.EmployeeFacade;
import io.helidon.mp.mybatisplus.service.EmployeeService;

@RequestScoped
@Transactional(rollbackFor = DBException.class)
public class EmployeeFacadeImpl implements EmployeeFacade {

	@Inject
	EmployeeService employeeService;

	public EmployeeFacadeImpl() {

	}

	@Override
	public List<Employee> selectEmployeeByExample() {

		List<Employee> employees = null;
		try {

			employees = employeeService.selectByExample(new EmployeeExample());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return employees;
	}

	@Override
	public int insertEmployee(Employee employee) {

		for (int i = 0; i < 10; i++) {
			employee.setEmployeeId(i + "");
			employee.setLastName("test1");
			employee.setFirstName("test1");
			try {
				employeeService.insert(employee);
			} catch (DBException e) {
				throw e;
			}
		}

		return 0;
	}

}
