package com.zzrq.lom.service;

import com.zzrq.lom.dto.AlarmDetail;
import com.zzrq.lom.dto.ResponseData;

public interface AlarmDetailService {
    ResponseData query(AlarmDetail alarmDetail);
}
