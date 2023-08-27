package com.yan.demo.demo01.controller;

import com.yan.common.utils.RResult;
import com.yan.demo.demo01.model.Student;
import com.yan.demo.demo01.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Tag(name = "学生")
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Operation(summary = "查询全部学生", description = "查询全部学生")
    @GetMapping
    public RResult<List<Student>> getAllStudent() {
        return RResult.success(studentService.list());
    }

    @Operation(summary = "根据id查询学生", description = "根据id查询学生")
    @GetMapping("/{id}")
    public RResult<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getById(id);
        if (Objects.nonNull(student)) {
            return RResult.success(student);
        } else {
            return RResult.notFound();
        }
    }

    @Operation(summary = "新增学生信息", description = "新增学生信息")
    @PostMapping()
    public RResult<Student> save(@RequestBody Student student) {
        studentService.save(student);
        return RResult.create(student);
    }

    @Operation(summary = "修改学生信息", description = "修改学生信息")
    @PutMapping()
    public RResult<Student> update(@RequestBody Student student) {
        boolean b = studentService.updateById(student);
        if (b) {
            return RResult.success(student);
        } else {
            return RResult.notFound("无此学生");
        }
    }


}
