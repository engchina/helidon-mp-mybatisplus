package io.helidon.mp.mybatisplus.facade.impl;

import io.helidon.mp.mybatisplus.entity.Employee;
import io.helidon.mp.mybatisplus.entity.EmployeeExample;
import io.helidon.mp.mybatisplus.facade.EmployeeFacade;
import io.helidon.mp.mybatisplus.service.EmployeeService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
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
}
