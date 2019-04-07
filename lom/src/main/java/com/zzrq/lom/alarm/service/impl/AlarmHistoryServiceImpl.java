package com.zzrq.lom.alarm.service.impl;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Resource(name = "alarmHistoryMapper")
    private AlarmHistoryMapper historyMapper;

    @Override
    public ResponseData query(AlarmHistory alarmHistory) {

        List<AlarmHistory> alarmHistories = historyMapper.select(alarmHistory);
        return new ResponseData(alarmHistories);
    }

    @Override
    public ResponseData selectAlarmDetailByMonthByControl() {
        List<AlarmHistory> alarmHistories = historyMapper.selectAlarmDetailByMonthByControl();
        Map<String, Integer[]> returnData = new HashMap<>();

        for (AlarmHistory alarmHistory : alarmHistories) {
            if (!returnData.containsKey(alarmHistory.getGroupName())) {
                Integer[] counts = new Integer[4];
                for (int i = 0; i < counts.length; i++) {
                    counts[i] = 0;
                }
                counts[alarmHistory.getGroupDate() - alarmHistory.getFirstMonth()] = alarmHistory.getCount();
                returnData.put(alarmHistory.getGroupName(), counts);
            } else {
                Integer[] counts = returnData.get(alarmHistory.getGroupName());
                counts[alarmHistory.getGroupDate() - alarmHistory.getFirstMonth()] = alarmHistory.getCount() ;
                returnData.put(alarmHistory.getGroupName(), counts);
            }

        }
        List returnList = new ArrayList();
        returnList.add(returnData);
        return new ResponseData(returnList);
    }

    @Override
    public ResponseData selectAlarmDetailByYearByControl() {
        List<AlarmHistory> alarmHistories = historyMapper.selectAlarmDetailByYearByControl();

        Map<String, Integer[]> returnData = new HashMap<>();

        for (AlarmHistory alarmHistory : alarmHistories) {
            if (!returnData.containsKey(alarmHistory.getGroupName())) {
                Integer[] counts = new Integer[12];
                for (int i = 0; i < counts.length; i++) {
                    counts[i] = 0;
                }
                counts[alarmHistory.getGroupDate() - 1] = alarmHistory.getCount();
                returnData.put(alarmHistory.getGroupName(), counts);
            } else {
                Integer[] counts = returnData.get(alarmHistory.getGroupName());
                counts[alarmHistory.getGroupDate() - 1] = alarmHistory.getCount();
                returnData.put(alarmHistory.getGroupName(), counts);
            }

        }
        List returnList = new ArrayList();
        returnList.add(returnData);
        return new ResponseData(returnList);
    }

    @Override
    public ResponseData selectAlarmDetailByYearByGateway() {
        List<AlarmHistory> alarmHistories = historyMapper.selectAlarmDetailByYearByGateway();

        Map<String, Integer[]> returnData = new HashMap<>();

        for (AlarmHistory alarmHistory : alarmHistories) {
            if (!returnData.containsKey(alarmHistory.getGroupName())) {
                Integer[] counts = new Integer[12];
                for (int i = 0; i < counts.length; i++) {
                    counts[i] = 0;
                }
                counts[alarmHistory.getGroupDate() - 1] = alarmHistory.getCount();
                returnData.put(alarmHistory.getGroupName(), counts);
            } else {
                Integer[] counts = returnData.get(alarmHistory.getGroupName());
                counts[alarmHistory.getGroupDate() - 1] = alarmHistory.getCount();
                returnData.put(alarmHistory.getGroupName(), counts);
            }

        }
        List returnList = new ArrayList();
        returnList.add(returnData);
        return new ResponseData(returnList);
    }
}
