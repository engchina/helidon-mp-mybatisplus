package io.helidon.mp.mybatisplus.mapper;

import org.mybatis.cdi.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import io.helidon.mp.mybatisplus.entity.Employee;

@Mapper
public interface EmployeeMapperPlus extends BaseMapper<Employee> {

}
