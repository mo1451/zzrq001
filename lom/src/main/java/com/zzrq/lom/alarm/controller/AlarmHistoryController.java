package com.zzrq.lom.alarm.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzrq.lom.alarm.dto.AlarmHistory;
import com.zzrq.lom.alarm.service.AlarmHistoryService;
import com.zzrq.lom.utils.ResponseData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author mo1451
 */
@Controller
public class AlarmHistoryController {

    @Resource(name="alarmHistoryServiceImpl")
    private AlarmHistoryService alarmHistoryService;

    @PostMapping(value = "alarm/history/query")
    @ResponseBody
    public ResponseData query(AlarmHistory alarmHistory, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return alarmHistoryService.query(alarmHistory);
    }

    @GetMapping(value = "alarm/history")
    public String alarmDetail() {
        return "alarmHistory";
    }

    @GetMapping(value = "alarm/history/by/year/by/gateway")
    @ResponseBody
    public ResponseData alarmDetailByYearByGateway() {
        return alarmHistoryService.selectAlarmDetailByYearByGateway();
    }

    @GetMapping(value = "alarm/history/by/year/by/control")
    @ResponseBody
    public ResponseData alarmDetailByYearByControl() {
        return alarmHistoryService.selectAlarmDetailByYearByControl();
    }

    @GetMapping(value = "alarm/history/by/month/by/control")
    @ResponseBody
    public ResponseData alarmDetailByMonthByControl() {
        return alarmHistoryService.selectAlarmDetailByMonthByControl();
    }


}
