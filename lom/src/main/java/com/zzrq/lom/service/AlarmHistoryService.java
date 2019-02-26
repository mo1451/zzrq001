package com.zzrq.lom.service;

import com.zzrq.lom.dto.AlarmHistory;
import com.zzrq.lom.dto.ResponseData;

public interface AlarmHistoryService {
    ResponseData query(AlarmHistory alarmHistory);
}
