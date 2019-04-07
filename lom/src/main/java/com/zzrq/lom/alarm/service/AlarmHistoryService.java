package com.zzrq.lom.alarm.service;

import com.zzrq.lom.alarm.dto.AlarmHistory;
import com.zzrq.lom.utils.ResponseData;

/**
 * @author mo1451
 */
public interface AlarmHistoryService {
    /**
     * 查询报警历史
     * @param alarmHistory 查询参数
     * @return 查询结果
     */
    ResponseData query(AlarmHistory alarmHistory);

    ResponseData selectAlarmDetailByMonthByControl();

    ResponseData selectAlarmDetailByYearByControl();

    ResponseData selectAlarmDetailByYearByGateway();
}
