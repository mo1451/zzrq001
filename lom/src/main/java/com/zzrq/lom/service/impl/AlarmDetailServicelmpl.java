package com.zzrq.lom.service.impl;

import com.zzrq.lom.dto.AlarmDetail;
import com.zzrq.lom.dto.ResponseData;
import com.zzrq.lom.mapper.AlarmDetailMapper;
import com.zzrq.lom.service.AlarmDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlarmDetailServicelmpl implements AlarmDetailService {
    @Autowired
    private AlarmDetailMapper detailMapper;

    @Override
    public ResponseData query(AlarmDetail alarmDetail) {

        List<AlarmDetail> alarmDetails = detailMapper.select(alarmDetail);
        return new ResponseData(alarmDetails);
    }
}
