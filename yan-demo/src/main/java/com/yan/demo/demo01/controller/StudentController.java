package com.yan.demo.demo01.controller;


import com.yan.demo.demo01.model.Student;
import com.yan.demo.demo01.service.StudentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "学生")
@RestController
@RequestMapping("/student")
public class StudentController  {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public boolean save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @PutMapping(value = "/updateById")
    public boolean update(@RequestBody Student student) {
        return studentService.updateById(student);
    }
}
