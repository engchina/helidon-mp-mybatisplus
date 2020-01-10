package io.helidon.mp.mybatisplus.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

import io.helidon.mp.mybatisplus.entity.Emp;
import io.helidon.mp.mybatisplus.vo.EmpVO;

public interface EmpService extends IService<Emp> {

	List<EmpVO> getEmpVOList();
}
