package com.zzrq.lom.alarm.service.impl;

import javax.annotation.Resource;
import java.util.List;

import com.zzrq.lom.alarm.dto.AlarmHistory;
import com.zzrq.lom.alarm.mapper.AlarmHistoryMapper;
import com.zzrq.lom.alarm.service.AlarmHistoryService;
import com.zzrq.lom.utils.ResponseData;
import org.springframework.stereotype.Service;

/**
 * @author mo1451
 */
@Service
public class AlarmHistoryServiceImpl implements AlarmHistoryService {

    @Resource
    private AlarmHistoryMapper historyMapper;

    @Override
    public ResponseData query(AlarmHistory alarmHistory) {

        List<AlarmHistory> alarmHistories = historyMapper.select(alarmHistory);
        return new ResponseData(alarmHistories);
    }
}
