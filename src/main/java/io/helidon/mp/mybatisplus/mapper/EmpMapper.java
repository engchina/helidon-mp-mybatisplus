package io.helidon.mp.mybatisplus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.mybatis.cdi.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import io.helidon.mp.mybatisplus.entity.Emp;
import io.helidon.mp.mybatisplus.vo.EmpVO;

@Mapper
public interface EmpMapper extends BaseMapper<Emp> {

	@Select("select emp.*, dept.dname from emp, dept where emp.deptno = dept.deptno")
	List<EmpVO> getEmpVOList();
}
