package com.zzrq.lom.controller;

import com.zzrq.lom.dto.AlarmHistory;
import com.zzrq.lom.dto.ResponseData;
import com.zzrq.lom.service.AlarmHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class AlarmHistoryController {

    @Autowired
    private AlarmHistoryService alarmHistoryService;

    @PostMapping(value = "alarm/history/query")
    public ResponseData query(AlarmHistory alarmHistory, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return alarmHistoryService.query(alarmHistory);
    }
}
