package io.helidon.mp.mybatisplus.facade;

import io.helidon.mp.mybatisplus.entity.Employee;

import java.util.List;

public interface EmployeeFacade {

    List<Employee> selectEmployeeByExample();

    int insertEmployee(Employee employee);
}
