package io.helidon.mp.mybatisplus.mapper;

import org.mybatis.cdi.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import io.helidon.mp.mybatisplus.entity.Dept;

@Mapper
public interface DeptMapper extends BaseMapper<Dept> {

}
