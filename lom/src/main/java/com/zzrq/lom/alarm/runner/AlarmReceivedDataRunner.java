package com.zzrq.lom.alarm.runner;

import javax.annotation.Resource;

import com.zzrq.lom.alarm.service.impl.AlarmReceivedDataServiceImpl;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @Author: mo1451
 * @Date: 2019/04/06 19:28
 */
@Component
public class AlarmReceivedDataRunner implements ApplicationRunner {

    @Resource
    private AlarmReceivedDataServiceImpl receivedDataService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        receivedDataService.AlarmReceiveData();
    }
}
