package io.helidon.mp.mybatisplus.facade;

import java.util.List;

import io.helidon.mp.mybatisplus.entity.Dept;
import io.helidon.mp.mybatisplus.entity.Emp;
import io.helidon.mp.mybatisplus.vo.EmpVO;

public interface GreetFacade {

	List<Dept> selectDeptList();

	List<Emp> selectEmpList();

	List<EmpVO> selectEmpVOList();

}
