package com.zzrq.lom.alarm.service.impl;

import javax.annotation.Resource;
import java.util.List;

import com.zzrq.lom.alarm.dto.AlarmDetail;
import com.zzrq.lom.alarm.mapper.AlarmDetailMapper;
import com.zzrq.lom.alarm.service.AlarmDetailService;
import com.zzrq.lom.utils.ResponseData;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author mo1451
 */
@Service
public class AlarmDetailServiceImpl implements AlarmDetailService {
    @Resource
    private AlarmDetailMapper detailMapper;

    @Override
    public ResponseData query(AlarmDetail alarmDetail) {

        List<AlarmDetail> alarmDetails = detailMapper.selectInfo(alarmDetail);

        return new ResponseData(alarmDetails);
    }

    @Override
    public AlarmDetail queryAlarm(String sensorNumber, String nodeName, String gatewayName) {
        Example userExample = new Example(AlarmDetail.class);
        userExample.createCriteria().andEqualTo("sensorNumber",sensorNumber)
        .andEqualTo("nodeName",nodeName)
        .andEqualTo("gatewayName",gatewayName);

        AlarmDetail alarmDetail = detailMapper.selectOneByExample(userExample);
        return alarmDetail;
    }
}
