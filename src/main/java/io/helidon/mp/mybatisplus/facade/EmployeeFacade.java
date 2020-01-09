package io.helidon.mp.mybatisplus.facade;

import java.util.List;

import io.helidon.mp.mybatisplus.entity.Employee;

public interface EmployeeFacade {

	List<Employee> selectEmployeeByExample();

	int insertEmployee();
}
