package io.helidon.mp.mybatisplus.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;

import io.helidon.mp.mybatisplus.entity.Emp;
import io.helidon.mp.mybatisplus.vo.EmpVO;

public interface EmpService {

	List<Emp> selectList(@Param(Constants.WRAPPER) Wrapper<Emp> queryWrapper);

	List<EmpVO> getEmpVOList();
}
