package com.yan.demo.demo01.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@TableName("student")
@Schema(description = "学生")
public class Student {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(description = "名称")
    @TableField("name")
    private String name;

    @Schema(description = "年龄")
    @TableField("age")
    private Integer age;

}
