package com.yan.demo.demo01.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yan.demo.demo01.mapper.StudentMapper;
import com.yan.demo.demo01.model.Student;
import com.yan.demo.demo01.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
