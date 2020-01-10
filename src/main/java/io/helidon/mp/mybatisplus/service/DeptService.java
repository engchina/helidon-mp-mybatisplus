package io.helidon.mp.mybatisplus.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;

import io.helidon.mp.mybatisplus.entity.Dept;

public interface DeptService {

	List<Dept> selectList(@Param(Constants.WRAPPER) Wrapper<Dept> queryWrapper);

}
