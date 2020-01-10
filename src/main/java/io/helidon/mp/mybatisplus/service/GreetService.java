package io.helidon.mp.mybatisplus.service;

import java.util.List;

import io.helidon.mp.mybatisplus.vo.EmpVO;

public interface GreetService {

	List<EmpVO> getEmpVOList();
}
