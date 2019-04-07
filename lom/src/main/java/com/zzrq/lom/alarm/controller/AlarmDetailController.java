package com.zzrq.lom.alarm.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzrq.lom.alarm.dto.AlarmDetail;
import com.zzrq.lom.alarm.service.AlarmDetailService;
import com.zzrq.lom.utils.ResponseData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author mo1451
 */
@Controller
public class AlarmDetailController {
    @Resource(name="alarmDetailServiceImpl")
    private AlarmDetailService alarmDetailService;

    @PostMapping(value = "alarm/detail/query")
    @ResponseBody
    public ResponseData query(AlarmDetail alarmDetail, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return alarmDetailService.query(alarmDetail);
    }

    @GetMapping(value = "alarm/detail")
    public String alarmDetail() {
        return "alarmDetail";
    }






}
