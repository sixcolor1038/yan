package com.yan.demo.exceldemo.service;

import com.yan.common.utils.RResult;
import com.yan.demo.exceldemo.entity.EmployeeDuty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @Author: sixcolor
 * @Date: 2024-03-03 18:58
 * @Description:
 */
public interface EmployeeDutyService {

    RResult<List<EmployeeDuty>> importEmployeeDuty(MultipartFile file) throws IOException;

    /**
     * 通过ID查询单条数据
     *
     * @param employeeDutyId 主键
     * @return 实例对象
     */
    EmployeeDuty queryById(Long employeeDutyId);

    /**
     * 分页查询
     *
     * @param employeeDuty 筛选条件
     * @param pageRequest  分页对象
     * @return 查询结果
     */
    Page<EmployeeDuty> paginQuery(EmployeeDuty employeeDuty, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param employeeDuty 实例对象
     * @return 实例对象
     */
    EmployeeDuty insertEmployeeDuty(EmployeeDuty employeeDuty);

    /**
     * 更新数据
     *
     * @param employeeDuty 实例对象
     * @return 实例对象
     */
    EmployeeDuty update(EmployeeDuty employeeDuty);

    /**
     * 通过主键删除数据
     *
     * @param employeeDutyId 主键
     * @return 是否成功
     */
    boolean deleteById(String employeeDutyId);
}
