package com.yan.demo.tallypractice.task;

import com.yan.demo.tallypractice.service.TallyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.Random;

@Component
public class TallyTask {

    @Autowired
    private TallyService tallyService;

    @Scheduled(fixedRate = 5000)
    public void executeTask() {
        BigInteger value = tallyService.getLatestTally();
        Random rnd = new Random();
        int incrementRange = 50;
        if (value.compareTo(BigInteger.TEN) > 0) {
            incrementRange = 500;
        }
        if (value.compareTo(BigInteger.valueOf(1000000)) > 0) {
            incrementRange = 50000;
        }
        int increment = rnd.nextInt(incrementRange) + 50;
        BigInteger incrementBigInt = BigInteger.valueOf(increment);
        value = value.add(incrementBigInt);
        tallyService.saveTally(value);
    }

}
