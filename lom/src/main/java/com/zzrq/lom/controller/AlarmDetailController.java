package com.zzrq.lom.controller;

import com.zzrq.lom.dto.AlarmDetail;
import com.zzrq.lom.dto.ResponseData;
import com.zzrq.lom.service.AlarmDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class AlarmDetailController {
    @Autowired
    private AlarmDetailService alarmDetailService;

    @PostMapping(value = "alarm/detail/query")
    public ResponseData query(AlarmDetail alarmDetail, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return alarmDetailService.query(alarmDetail);
    }






}
