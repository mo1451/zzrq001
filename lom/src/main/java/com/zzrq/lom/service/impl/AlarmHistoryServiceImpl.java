package com.zzrq.lom.service.impl;

import com.zzrq.lom.dto.AlarmHistory;
import com.zzrq.lom.dto.ResponseData;
import com.zzrq.lom.mapper.AlarmHistoryMapper;
import com.zzrq.lom.service.AlarmHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlarmHistoryServiceImpl implements AlarmHistoryService {

    @Autowired
    private AlarmHistoryMapper historyMapper;

    @Override
    public ResponseData query(AlarmHistory alarmHistory) {

        List<AlarmHistory> alarmHistories = historyMapper.select(alarmHistory);
        return new ResponseData(alarmHistories);
    }
}
