package io.helidon.mp.mybatisplus.facade;

import java.util.List;

import io.helidon.mp.mybatisplus.entity.Dept;
import io.helidon.mp.mybatisplus.entity.Emp;

public interface GreetFacade {

	List<Dept> selectDeptList();

	List<Emp> selectEmpList();

}
