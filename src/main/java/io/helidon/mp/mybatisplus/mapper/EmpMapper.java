package io.helidon.mp.mybatisplus.mapper;

import org.mybatis.cdi.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import io.helidon.mp.mybatisplus.entity.Emp;

@Mapper
public interface EmpMapper extends BaseMapper<Emp> {

}
