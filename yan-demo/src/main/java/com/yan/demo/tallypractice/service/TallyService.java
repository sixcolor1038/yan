package com.yan.demo.tallypractice.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yan.demo.tallypractice.mapper.TallyMapper;
import com.yan.demo.tallypractice.model.Tally;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigInteger;

@Service
public class TallyService {

    @Autowired
    private TallyMapper tallyMapper;

    public void saveTally(BigInteger value) {

        byte[] bytes = value.toByteArray();
        Tally tally = new Tally();
        tally.setValue(bytes);
        tallyMapper.insert(tally);

    }
    public boolean updateTally(Tally tally) {
        return tallyMapper.updateById(tally) > 0;
    }

    public BigInteger getLatestTally() {
        QueryWrapper<Tally> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        Long lastId = tallyMapper.selectCount(queryWrapper);
        Tally latestTally = tallyMapper.selectById(lastId);
        System.out.println("latestTally>>>>"+latestTally);
        return new BigInteger(latestTally.getValue());

    }



}
