package com.yan.demo.demo01.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yan.demo.demo01.model.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}