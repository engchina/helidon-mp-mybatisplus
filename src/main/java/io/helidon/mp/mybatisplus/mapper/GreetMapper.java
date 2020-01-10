package io.helidon.mp.mybatisplus.mapper;

import java.util.List;

import org.mybatis.cdi.Mapper;

import io.helidon.mp.mybatisplus.vo.EmpVO;

@Mapper
public interface GreetMapper {

	List<EmpVO> getEmpVOList();
}
