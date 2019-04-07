package com.zzrq.lom.alarm.service.impl;

import java.util.List;

import com.zzrq.lom.alarm.dto.AlarmDetail;
import com.zzrq.lom.alarm.mapper.AlarmDetailMapper;
import com.zzrq.lom.alarm.service.AlarmDetailService;
import com.zzrq.lom.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author mo1451
 */
@Service
public class AlarmDetailServiceImpl implements AlarmDetailService {
    @Autowired
    private AlarmDetailMapper detailMapper;

    @Override
    public ResponseData query(AlarmDetail alarmDetail) {

        List<AlarmDetail> alarmDetails = detailMapper.selectInfo(alarmDetail);

        return new ResponseData(alarmDetails);
    }

    @Override
    public AlarmDetail queryAlarm(String sensorNumber, String nodeName, String gatewayName) {
        Example userExample = new Example(AlarmDetail.class);
        userExample.createCriteria().andEqualTo("alarmId",sensorNumber)
        .andEqualTo("nodeId",nodeName)
        .andEqualTo("gatewayId",gatewayName);

        AlarmDetail alarmDetail = detailMapper.selectOneByExample(userExample);
        return alarmDetail;
    }
}
