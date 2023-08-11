package com.yan.demo.demo01.controller;

import com.yan.demo.demo01.model.Student;
import com.yan.demo.demo01.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "用户管理")
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public boolean save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @PutMapping
    public boolean update(@RequestBody Student student) {
        return studentService.updateById(student);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return studentService.removeById(id);
    }
    @Operation(summary = "ById")
    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return studentService.getById(id);
    }

}
