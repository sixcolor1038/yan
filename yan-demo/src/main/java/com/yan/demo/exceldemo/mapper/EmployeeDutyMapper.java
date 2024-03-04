package com.yan.demo.exceldemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yan.demo.exceldemo.entity.EmployeeDuty;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author: sixcolor
 * @Date: 2024-03-03 18:57
 * @Description:
 */
@Mapper
public interface EmployeeDutyMapper extends BaseMapper<EmployeeDuty> {
    /**
     * 通过ID查询单条数据
     *
     * @param employeeDutyId 主键
     * @return 实例对象
     */
    EmployeeDuty queryById(Long employeeDutyId);

    /**
     * 分页查询指定行数据
     *
     * @param employeeDuty 查询条件
     * @param pageable     分页对象
     * @return 对象列表
     */
    List<EmployeeDuty> queryAllByLimit(EmployeeDuty employeeDuty, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param employeeDuty 查询条件
     * @return 总行数
     */
    long count(EmployeeDuty employeeDuty);

    /**
     * 新增数据
     *
     * @param employeeDuty 实例对象
     * @return 影响行数
     */
    int addEmployeeDuty(EmployeeDuty employeeDuty);

    /**
     * 批量新增数据
     *
     * @param entities List<EmployeeDuty> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<EmployeeDuty> entities);

    /**
     * 批量新增或按主键更新数据
     *
     * @param entities List<EmployeeDuty> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<EmployeeDuty> entities);

    /**
     * 更新数据
     *
     * @param employeeDuty 实例对象
     * @return 影响行数
     */
    int update(EmployeeDuty employeeDuty);

    /**
     * 通过主键删除数据
     *
     * @param employeeDutyId 主键
     * @return 影响行数
     */
    int deleteById(String employeeDutyId);
}
