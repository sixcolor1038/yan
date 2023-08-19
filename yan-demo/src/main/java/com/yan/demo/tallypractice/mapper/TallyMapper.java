package com.yan.demo.tallypractice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yan.demo.tallypractice.model.Tally;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TallyMapper extends BaseMapper<Tally> {
    void update(@Param("tally") Tally tally);
}
