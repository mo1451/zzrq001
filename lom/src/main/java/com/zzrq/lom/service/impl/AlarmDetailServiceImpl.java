package com.zzrq.lom.service.impl;

import com.zzrq.lom.dto.AlarmDetail;
import com.zzrq.lom.dto.ResponseData;
import com.zzrq.lom.mapper.AlarmDetailMapper;
import com.zzrq.lom.service.AlarmDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
