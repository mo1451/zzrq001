package com.zzrq.lom.alarm.mapper;

import java.util.List;

import com.zzrq.lom.alarm.dto.AlarmDetail;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author mo1451
 */
@Component
public interface AlarmDetailMapper extends Mapper<AlarmDetail> {
    /**
     * 查询报警器信息
     * @param alarmDetail 查询参数
     * @return 查询结果
     */
    List<AlarmDetail> selectInfo(AlarmDetail alarmDetail);
}
