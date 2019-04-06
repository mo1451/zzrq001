package com.zzrq.lom.alarm.service;

import com.zzrq.lom.alarm.dto.AlarmDetail;
import com.zzrq.lom.utils.ResponseData;

/**
 * @author mo1451
 */
public interface AlarmDetailService {
    /**
     * 查询报警详情
     * @param alarmDetail 查询参数
     * @return 查询结果
     */
    ResponseData query(AlarmDetail alarmDetail);

    /**
     * 根据传感器名称，控制器名称和设备名称获取alarm
     * @param sensorNumber
     * @param nodeName
     * @param gatewayName
     * @return
     */
    AlarmDetail queryAlarm(String sensorNumber,String nodeName,String gatewayName);
}
