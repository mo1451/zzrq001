package com.zzrq.lom.controller;

import com.zzrq.lom.dto.AlarmDetail;
import com.zzrq.lom.dto.ResponseData;
import com.zzrq.lom.service.AlarmDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AlarmDetailController {
    @Autowired
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
